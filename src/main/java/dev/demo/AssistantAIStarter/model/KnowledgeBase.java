package dev.demo.AssistantAIStarter.model;

import java.util.List;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "KNOWLEDGE_BASE")
public class KnowledgeBase {

    @Id
    private String id;
    @Field("text_data")
    private String textData;
    @Field("vector_data")
    private List<Double> vectorData;

}
