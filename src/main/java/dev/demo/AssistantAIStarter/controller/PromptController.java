package dev.demo.AssistantAIStarter.controller;


import dev.demo.AssistantAIStarter.model.*;
import dev.demo.AssistantAIStarter.service.EmbeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PromptController {

    @Autowired
    private EmbeddingService embeddingService;

    @PostMapping("/embed")
    public KnowledgeBase embedPrompt(@RequestBody String textData) {
        List<Double> vectorData = embeddingService.getEmbedding(textData);
        return embeddingService.saveKnowledgeBase(textData, vectorData);
    }

    @GetMapping("/knowledge_base")
    public List<KnowledgeBase> getKnowledgeBase() {
        return embeddingService.getAllKnowledgeBase();
    }
}
