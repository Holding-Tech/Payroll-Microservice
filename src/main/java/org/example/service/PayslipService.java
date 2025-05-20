package org.example.service;

import org.example.dto.PayslipDTO;
import org.example.model.Payslip;
import org.example.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    public List<PayslipDTO> getAllPayslips() {
        return payslipRepository.findAll()
                .stream()
                .map(Payslip::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PayslipDTO> getPayslipById(Long id) {
        return payslipRepository.findById(id).map(Payslip::toDTO);
    }

    public PayslipDTO savePayslip(PayslipDTO dto) {
        Payslip saved = payslipRepository.save(dto.toEntity());
        return saved.toDTO();
    }

    public Optional<PayslipDTO> updatePayslip(Long id, PayslipDTO dto) {
        return payslipRepository.findById(id).map(existing -> {
            existing.setEmployeeId(dto.getEmployeeId());
            existing.setSalary(dto.getSalary());
            existing.setDeductions(dto.getDeductions());
            existing.setPayDate(dto.getPayDate());
            return payslipRepository.save(existing).toDTO();
        });
    }

    public boolean deletePayslip(Long id) {
        if (payslipRepository.existsById(id)) {
            payslipRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
