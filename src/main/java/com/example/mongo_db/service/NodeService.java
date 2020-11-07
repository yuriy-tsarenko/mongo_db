package com.example.mongo_db.service;

import com.example.mongo_db.document.Node;
import com.example.mongo_db.dto.NodeDto;
import com.example.mongo_db.mapper.NodeMapper;
import com.example.mongo_db.repository.NodeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Data
public class NodeService {

    private final NodeRepository nodeRepository;
    private final NodeMapper nodeMapper;

    public Flux<Node> getAllItems() {
        return nodeRepository.findAll();
    }

    public Mono<Node> saveOne(NodeDto mono) {
       return nodeRepository.save(nodeMapper.mapDtoToDocument(mono));
    }
}
