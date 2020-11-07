package com.example.mongo_db.controller;

import com.example.mongo_db.document.Node;
import com.example.mongo_db.dto.NodeDto;
import com.example.mongo_db.service.NodeService;
import lombok.RequiredArgsConstructor;
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

    public static final String BASE_PATH = "/";
    private final NodeService nodeService;

    @GetMapping
    public @ResponseBody
    Flux<Node> all() {
        return nodeService.getAllItems();
    }

    @PostMapping("/add_one")
    public @ResponseBody
    Mono<Node> save(@RequestBody NodeDto dto) {
        return nodeService.saveOne(dto);
    }
}