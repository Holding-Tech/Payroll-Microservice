package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payslips")
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

    public Long getPayslipId() {
        return payslipId;
    }

    public void setPayslipId(Long payslipId) {
        this.payslipId = payslipId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public BigDecimal getNetSalary() {

        if (salary != null && deductions != null) {
            return salary.subtract(deductions);
        }
        return null;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }


    public org.example.dto.PayslipDTO toDTO() {
        return new org.example.dto.PayslipDTO(
                employeeId,
                salary,
                deductions,
                getNetSalary(),
                payDate
        );
    }
}
