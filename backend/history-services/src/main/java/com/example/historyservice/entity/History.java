package com.example.historyservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;
    private String output;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;

    // Automatically set timestamp when a record is created
    @PrePersist
    public void onCreate() {
        this.timestamp = LocalDateTime.now(); // Local server time (e.g., IST if your server runs in IST)
    }

    // ✅ Custom getter to format timestamp (no fractional seconds)
    public String getTimestamp() {
        if (timestamp == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    // Getters & setters
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getQuery() { 
        return query; 
    }
    public void setQuery(String query) { 
        this.query = query; 
    }

    public String getOutput() { 
        return output; 
    }
    public void setOutput(String output) { 
        this.output = output; 
    }
}

