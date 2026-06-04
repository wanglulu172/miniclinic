package tw.edu.fju.miniclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.fju.miniclinic.model.AppointmentRepository;
import tw.edu.fju.miniclinic.model.DoctorRepository;
import tw.edu.fju.miniclinic.model.PatientRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class StatsApiController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    /**
     * GET /api/stats
     * 回傳系統資料摘要，不需要登入即可存取。
     */
    @GetMapping("/api/stats")
    public Map<String, Object> getStatsSummary() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("totalDoctors", doctorRepo.count());
        response.put("totalPatients", patientRepo.count());
        response.put("totalAppointments", appointmentRepo.count());

        Map<String, Long> byStatus = new LinkedHashMap<>();
        byStatus.put("BOOKED", appointmentRepo.countByStatus("BOOKED"));
        byStatus.put("COMPLETED", appointmentRepo.countByStatus("COMPLETED"));
        byStatus.put("CANCELLED", appointmentRepo.countByStatus("CANCELLED"));
        response.put("byStatus", byStatus);

        return response;
    }
}