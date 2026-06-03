package tw.edu.fju.miniclinic.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.edu.fju.miniclinic.model.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentApiController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @PutMapping("/{apptId}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long apptId,
            @RequestBody Map<String, String> payload,
            HttpSession session) {

        String loggedInDoctorId = (String) session.getAttribute("loggedInDoctorId");
        
        // 1. 檢查 Session 狀態（攔截器通常已處理，此處為雙重保護）
        if (loggedInDoctorId == null) {
            return ResponseEntity.status(401).body(Map.of("error", "請先登入"));
        }

        // 2. 查詢掛號資料
        Appointment appt = appointmentRepo.findById(apptId).orElse(null);
        if (appt == null) {
            return ResponseEntity.notFound().build();
        }

        // 3. 安全檢查：只有該診次的負責醫師可以修改狀態
        if (!appt.getDoctor().getDoctorId().equals(loggedInDoctorId)) {
            return ResponseEntity.status(403).body(Map.of("error", "權限不足：您只能操作自己的掛號資料"));
        }

        // 4. 驗證傳入的狀態值
        String newStatus = payload.get("status");
        if (newStatus == null || !List.of("BOOKED", "COMPLETED", "CANCELLED").contains(newStatus)) {
            return ResponseEntity.badRequest().body(Map.of("error", "無效的狀態值"));
        }

        // 5. 更新並儲存
        appt.setStatus(newStatus);
        appointmentRepo.save(appt);
        
        return ResponseEntity.ok().build();
    }
}