package org.example.dto;

import org.example.model.Payslip;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayslipDTO {

    private Long employeeId;
    private BigDecimal salary;
    private BigDecimal deductions;
    private BigDecimal netSalary;
    private LocalDate payDate;

    public PayslipDTO() {
    }

    public PayslipDTO(Long employeeId, BigDecimal salary, BigDecimal deductions,
                      BigDecimal netSalary, LocalDate payDate) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.payDate = payDate;
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
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public Payslip toEntity() {
        Payslip payslip = new Payslip();
        payslip.setEmployeeId(this.employeeId);
        payslip.setSalary(this.salary);
        payslip.setDeductions(this.deductions);
        payslip.setPayDate(this.payDate);
        // No need to set netSalary as it is computed dynamically in Payslip
        return payslip;
    }
}
