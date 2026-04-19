package com.example.documents.repository;

import com.example.documents.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByUsername(String username);

    List<Document> findByUsernameAndSignedAtIsNotNull(String username);

    List<Document> findByUsernameAndSignedAtIsNull(String username);

    List<Document> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);
}