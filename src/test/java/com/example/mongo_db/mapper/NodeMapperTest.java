package com.example.mongo_db.mapper;

import com.example.mongo_db.TestUtil;
import com.example.mongo_db.document.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class NodeMapperTest {

    @InjectMocks NodeMapperImpl nodeMapper;

    @Test
    void mapDtoToDocument() {
        Node expected = TestUtil.getNode();

        Node result = nodeMapper.mapDtoToDocument(TestUtil.getNodeDto());

        assertEquals(expected, result);
    }
}