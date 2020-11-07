package com.example.mongo_db;

import com.example.mongo_db.document.Node;
import com.example.mongo_db.dto.NodeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestUtil {

    public static Flux<Node> all() {
        Node node = new Node();
        node.setId(1L);
        node.setNodeRoot("nodeRoot");
        node.setNodeDesc("nodeDesc");

        Node node1 = new Node();
        node.setId(1L);
        node.setNodeRoot("nodeRoot");
        node.setNodeDesc("nodeDesc");

        return Flux.just(node, node1).map(x -> {
            Node node2 = new Node();
            node2.setId(node.getId());
            node2.setNodeRoot(node.getNodeRoot());
            node2.setNodeDesc(node.getNodeDesc());
            return node2;
        });
    }

    public static Mono<Node> save() {
        Node node = new Node();
        node.setId(1L);
        node.setNodeRoot("nodeRoot");
        node.setNodeDesc("nodeDesc");
        return Mono.just(node).map(x -> {
            Node node2 = new Node();
            node2.setId(node.getId());
            node2.setNodeRoot(node.getNodeRoot());
            node2.setNodeDesc(node.getNodeDesc());
            return node2;
        });
    }

    public static NodeDto getNodeDto() {
        NodeDto node = new NodeDto();
        node.setId(1L);
        node.setNodeRoot("nodeRoot");
        node.setNodeDesc("nodeDesc");
        return node;
    }

    public static Node getNode() {
        Node node = new Node();
        node.setId(1L);
        node.setNodeRoot("nodeRoot");
        node.setNodeDesc("nodeDesc");
        return node;
    }
}
