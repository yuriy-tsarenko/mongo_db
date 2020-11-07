package com.example.mongo_db.repository;

import com.example.mongo_db.document.Node;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends ReactiveMongoRepository<Node, Long> {
}
