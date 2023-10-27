package com.example.fitness.model.request;

import com.example.fitness.model.Participant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
}
