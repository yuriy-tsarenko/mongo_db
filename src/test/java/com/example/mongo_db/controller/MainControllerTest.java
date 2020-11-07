package com.example.mongo_db.controller;

import com.example.mongo_db.TestUtil;
import com.example.mongo_db.document.Node;
import com.example.mongo_db.service.NodeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    private NodeService nodeService;
    @InjectMocks
    private MainController mainController;

    @Test
    void list() {

        Flux<Node> expected = TestUtil.all();

        when(nodeService.getAllItems()).thenReturn(TestUtil.all());

        Flux<Node> result = mainController.all();

        assertEquals(expected.blockFirst(), result.blockFirst());

        verify(nodeService).getAllItems();
    }

    @Test
    void add() {

        Mono<Node> expected = TestUtil.save();

        when(nodeService.saveOne(TestUtil.getNodeDto())).thenReturn(TestUtil.save());

        Mono<Node> result = mainController.save(TestUtil.getNodeDto());

        assertEquals(expected.block(), result.block());

        verify(nodeService).saveOne(TestUtil.getNodeDto());
    }
}