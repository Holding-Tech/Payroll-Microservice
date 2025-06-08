package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.model.Payslip;
import java.math.BigDecimal;
import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayslipDTO {

    @JsonProperty("payslip_id")
    private Long payslipId;

//    @NotNull(message = "Employee ID is required")
    private Long employeeId;
    private BigDecimal salary;
    private BigDecimal deductions;
    private BigDecimal netSalary;
    private LocalDate payDate;

    public Payslip toEntity() {
        Payslip payslip = new Payslip();
        payslip.setPayslipId(this.payslipId);
        payslip.setEmployeeId(this.employeeId);
        payslip.setSalary(this.salary);
        payslip.setDeductions(this.deductions);
        payslip.setPayDate(this.payDate);
        return payslip;
    }
}

