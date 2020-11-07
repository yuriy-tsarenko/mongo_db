package com.example.mongo_db.controller;

import com.example.mongo_db.document.Node;
import com.example.mongo_db.dto.NodeDto;
import com.example.mongo_db.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(MainController.BASE_PATH)
@RequiredArgsConstructor
public class MainController {

    private static final Logger log = Logger.getLogger(MainController.class);
    public static final String BASE_PATH = "/";
    private final NodeService nodeService;

    @GetMapping
    public @ResponseBody
    Flux<Node> list() {
        return nodeService.getAllItems();
    }

    @PostMapping("/add_one")
    public @ResponseBody
    Mono<Node> add(@RequestBody NodeDto dto) {
        if (dto.getNodeRoot() != null && dto.getId() != null)
            return nodeService.saveOne(dto);
        log.error("app received incorrect data: " + " id: " + dto.getId() + " nodeRoot: " + dto.getNodeRoot());
        return Mono.empty();
    }
}
