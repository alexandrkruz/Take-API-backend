package com.example.documents.service;

import com.example.documents.model.Document;
import com.example.documents.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository repo;

    public DocumentService(DocumentRepository repo) {
        this.repo = repo;
    }

    public Document create(Document doc) {
        return repo.save(doc);
    }

    public Document update(Long id, Document newDoc) {
        Document doc = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        if (newDoc.getTitle() != null) {
            doc.setTitle(newDoc.getTitle());
        }
        if (newDoc.getType() != null) {
            doc.setType(newDoc.getType());
        }
        if (newDoc.getBody() != null) {
            doc.setBody(newDoc.getBody());
        }
        if (newDoc.getSignedAt() != null) {
            doc.setSignedAt(newDoc.getSignedAt());
        }
        if (newDoc.getUsername() != null) {
            doc.setUsername(newDoc.getUsername());
        }

        return repo.save(doc);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Document> getByUsername(String username) {
        return repo.findByUsername(username);
    }

    public List<Document> getSignedByUsername(String username) {
        return repo.findByUsernameAndSignedAtIsNotNull(username);
    }

    public List<Document> getUnsignedByUsername(String username) {
        return repo.findByUsernameAndSignedAtIsNull(username);
    }

    public List<Document> getByDateRange(LocalDateTime from, LocalDateTime to) {
        return repo.findByCreatedAtBetween(from, to);
    }
}