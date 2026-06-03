package tw.edu.fju.miniclinic.model;

import jakarta.persistence.*;
import java.sql.Types;
import java.time.LocalDate;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "chart_no", length = 20)
    private String chartNo;    // 病歷號

    @Column(name = "name", length = 50, nullable = false)
    private String name;       // 姓名

    @Column(name = "gender", length = 10)
    private String gender;     // 性別

    @JdbcTypeCode(Types.VARCHAR)
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "birth_date", columnDefinition = "TEXT")
    private LocalDate birthDate;

    @Column(name = "phone", length = 20)
    private String phone;      // 電話

    // JPA 需要無參數的建構子
    public Patient() {
    }

    public Patient(String chartNo, String name, String gender, String phone) {
        this.chartNo = chartNo;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    // Getters and Setters
    public String getChartNo() { return chartNo; }
    public void setChartNo(String chartNo) { this.chartNo = chartNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}