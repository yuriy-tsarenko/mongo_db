package com.example.mongo_db.mapper;

import com.example.mongo_db.document.Node;
import com.example.mongo_db.dto.NodeDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NodeMapper {

    Node mapDtoToDocument(NodeDto nodeDtoMono);
}
