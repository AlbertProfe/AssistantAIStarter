package dev.demo.AssistantAIStarter.service;

import dev.demo.AssistantAIStarter.model.KnowledgeBase;
import dev.demo.AssistantAIStarter.repository.KnowledgeBaseRepository;
import org.springframework.ai.bedrock.titan.api.TitanEmbeddingBedrockApi;
import org.springframework.ai.bedrock.titan.api.TitanEmbeddingBedrockApi.TitanEmbeddingRequest;
import org.springframework.ai.bedrock.titan.api.TitanEmbeddingBedrockApi.TitanEmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmbeddingService {

    private final KnowledgeBaseRepository knowledgeBaseRepository;
    private final TitanEmbeddingBedrockApi titanEmbeddingApi;

    @Autowired
    public EmbeddingService(KnowledgeBaseRepository knowledgeBaseRepository,
                            @Value("${spring.ai.bedrock.aws.region}") String region,
                            TitanEmbeddingBedrockApi titanEmbeddingBedrockApi) {
        this.knowledgeBaseRepository = knowledgeBaseRepository;
        this.titanEmbeddingApi = titanEmbeddingBedrockApi;
        //this.titanEmbeddingApi.setRegion(region);
    }

    public List<Double> getEmbedding(String textData) {
        TitanEmbeddingRequest request = TitanEmbeddingRequest.builder()
                .withInputText(textData)
                .build();

        TitanEmbeddingResponse response = titanEmbeddingApi.embedding(request);
        return response.embedding();
    }

    public KnowledgeBase saveKnowledgeBase(String textData, List<Double> vectorData) {
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        knowledgeBase.setTextData(textData);
        knowledgeBase.setVectorData(vectorData);
        return knowledgeBaseRepository.save(knowledgeBase);
    }

    public List<KnowledgeBase> getAllKnowledgeBase() {
        return knowledgeBaseRepository.findAll();
    }
}
