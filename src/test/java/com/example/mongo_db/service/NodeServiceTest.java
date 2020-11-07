package com.example.mongo_db.service;

import com.example.mongo_db.TestUtil;
import com.example.mongo_db.document.Node;
import com.example.mongo_db.mapper.NodeMapper;
import com.example.mongo_db.repository.NodeRepository;
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
class NodeServiceTest {

    @Mock
    private NodeRepository nodeRepository;
    @Mock
    private NodeMapper nodeMapper;
    @InjectMocks
    private NodeService nodeService;

    @Test
    void getAllItems() {
        Flux<Node> expected = TestUtil.all();

        when(nodeRepository.findAll()).thenReturn(TestUtil.all());

        Flux<Node> result = nodeService.getAllItems();

        assertEquals(expected.blockFirst(), result.blockFirst());

        verify(nodeRepository).findAll();
    }

    @Test
    void saveOne() {
        Mono<Node> expected = TestUtil.save();

        when(nodeRepository.save(nodeMapper.mapDtoToDocument(TestUtil.getNodeDto()))).thenReturn(TestUtil.save());

        Mono<Node> result = nodeService.saveOne(TestUtil.getNodeDto());

        assertEquals(expected.block(), result.block());

        verify(nodeRepository).save(nodeMapper.mapDtoToDocument(TestUtil.getNodeDto()));
    }
}