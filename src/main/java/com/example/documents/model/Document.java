package com.example.documents.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "documents")

public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime createdAt;

    private LocalDateTime signedAt;

    private String username;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // getters и setters ↓↓↓
}