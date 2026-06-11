package comitheima.consultant.config;

import comitheima.consultant.aiservice.ConsultantService;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Autowired
    private OpenAiChatModel openAiChatModel;
//    @Bean
//    public ConsultantService consultantService(){
//        ConsultantService consultantService = AiServices.builder(ConsultantService.class)//要创建哪个接口，就传入哪个
//                .chatModel(openAiChatModel)
//                .build();
//        return consultantService;
//    }

    //构建会话记忆对象
    @Bean
    public ChatMemory chatMemory(Object memoryId){
        MessageWindowChatMemory memory = MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(20)
                .build();
        return memory;
    }
}
