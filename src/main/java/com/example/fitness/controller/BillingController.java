package com.example.fitness.controller;

import com.example.fitness.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/verify-bill")
    public ResponseEntity<String> verifyBillAmount(@RequestParam Long participantId,@RequestParam BigDecimal expectedBillAmount) {
        if (paymentService.verifyBillAmount(participantId,expectedBillAmount)) {
            return ResponseEntity.ok("Verifikasi tagihan berhasil.");
        } else {
            return ResponseEntity.badRequest().body("Verifikasi tagihan gagal.");
        }
    }
}
