package com.example.mongo_db.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Node {
    @Id
    private Long id;
    private String nodeRoot;
    private String nodeDesc;
}