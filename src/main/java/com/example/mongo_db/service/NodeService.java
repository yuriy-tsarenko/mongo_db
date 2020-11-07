package com.example.mongo_db.service;

import com.example.mongo_db.document.Node;
import com.example.mongo_db.dto.NodeDto;
import com.example.mongo_db.mapper.NodeMapper;
import com.example.mongo_db.repository.NodeRepository;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Data
public class NodeService {

    private static final Logger log = Logger.getLogger(NodeService.class);
    private final NodeRepository nodeRepository;
    private final NodeMapper nodeMapper;

    public Flux<Node> getAllItems() {
        return nodeRepository.findAll();
    }

    public Mono<Node> saveOne(NodeDto dto) {
        if (dto.getNodeRoot() != null && dto.getId() != null)
            return nodeRepository.save(nodeMapper.mapDtoToDocument(dto));
        log.error("app received incorrect data: "
                + " id: " + dto.getId() + " nodeRoot: " + dto.getNodeRoot());
        return Mono.empty();
    }
}
