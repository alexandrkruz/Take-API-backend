package com.example.documents.controller;

import com.example.documents.model.Document;
import com.example.documents.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping
    public Document create(@RequestBody Document doc) {
        return service.create(doc);
    }

    @PutMapping("/{id}")
    public Document update(@PathVariable Long id, @RequestBody Document doc) {
        return service.update(id, doc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{username}")
    public List<Document> getByUsername(@PathVariable String username) {
        return service.getByUsername(username);
    }

    @GetMapping("/user/{username}/signed")
    public List<Document> getSignedByUsername(@PathVariable String username) {
        return service.getSignedByUsername(username);
    }

    @GetMapping("/user/{username}/unsigned")
    public List<Document> getUnsignedByUsername(@PathVariable String username) {
        return service.getUnsignedByUsername(username);
    }

    @GetMapping("/range")
    public List<Document> getByDateRange(@RequestParam LocalDateTime from,
                                         @RequestParam LocalDateTime to) {
        return service.getByDateRange(from, to);
    }
}