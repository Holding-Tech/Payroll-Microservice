package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payslips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payslip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payslipId;

    private Long employeeId;

    private BigDecimal salary;

    private BigDecimal deductions;

    @Transient
    private BigDecimal netSalary;

    private LocalDate payDate;

    public BigDecimal getNetSalary() {
        if (salary != null && deductions != null) {
            return salary.subtract(deductions);
        }
        return null;
    }

    public org.example.dto.PayslipDTO toDTO() {
        return new org.example.dto.PayslipDTO(
                payslipId,
                employeeId,
                salary,
                deductions,
                getNetSalary(),
                payDate
        );
    }
}

