package org.example.controller;

import org.example.dto.PayslipDTO;
import org.example.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payslips")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @GetMapping
    public List<PayslipDTO> getAllPayslips() {
        return payslipService.getAllPayslips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayslipDTO> getPayslipById(@PathVariable Long id) {
        return payslipService.getPayslipById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PayslipDTO> createPayslip(@RequestBody PayslipDTO dto) {
        PayslipDTO created = payslipService.savePayslip(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayslipDTO> updatePayslip(@PathVariable Long id, @RequestBody PayslipDTO dto) {
        return payslipService.updatePayslip(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayslip(@PathVariable Long id) {
        if (payslipService.deletePayslip(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

