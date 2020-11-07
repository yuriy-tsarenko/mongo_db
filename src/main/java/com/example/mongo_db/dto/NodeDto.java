package com.example.mongo_db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeDto {
    private Long id;
    private String nodeRoot;
    private String nodeDesc;
}
