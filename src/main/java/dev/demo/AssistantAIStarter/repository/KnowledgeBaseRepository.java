package dev.demo.AssistantAIStarter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.demo.AssistantAIStarter.model.KnowledgeBase;

@Repository
public interface KnowledgeBaseRepository extends MongoRepository<KnowledgeBase, String> {

}
