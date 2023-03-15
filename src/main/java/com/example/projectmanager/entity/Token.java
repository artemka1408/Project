package com.example.projectmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokens")
@Data
public class Token {
    @Id
    private String token;
    @ManyToOne
    private User user;
    @Column(insertable = false, columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDate created;
}
