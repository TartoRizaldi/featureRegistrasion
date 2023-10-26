package com.example.fitness.controller;

import com.example.fitness.model.Participant;
import com.example.fitness.repository.ParticipantRepository;
import com.example.fitness.service.EmailService;
import com.example.fitness.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Participant participant) {
        try {
            String subject = "Konfirmasi Pendaftaran";
            String text = "Terima kasih atas pendaftaran Anda di pusat kebugaran kami. Silakan klik link konfirmasi berikut untuk mengaktifkan akun Anda: [LINK KONFIRMASI]";
            emailService.sendEmail(participant.getEmail(), subject, text);
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal mengirim email konfirmasi.");
        }

        return ResponseEntity.ok("Registrasi berhasil. Silakan cek email Anda untuk konfirmasi.");
    }

    @GetMapping("/check-status")
    public ResponseEntity<String> checkStatus(@RequestParam String email) {
        Optional<Participant> participantOptional = participantRepository.findByEmail(email);

        if (participantOptional.isPresent()) {
            Participant participant = participantOptional.get();

            if (participant.isVerified()) {
                return ResponseEntity.ok("Status kepesertaan: TERDAFTAR");
            } else {
                return ResponseEntity.ok("Status kepesertaan: BELUM TERVALIDASI");
            }
        } else {
            return ResponseEntity.ok("Status kepesertaan: TIDAK TERDAFTAR");
        }
    }




}
