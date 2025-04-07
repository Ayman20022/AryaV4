package com.example.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    private String firstname;
    private String lastname;

    @NonNull
    private String username;

    @NonNull
    private String email;

    private String bio;
    private String birthDate;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now(); // Default if not set

    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now(); // Default if not set

    private BigDecimal balance;
}