package comitheima.consultant.aiservice;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel"
)
//@AiService//默认使用默认模型
public interface ConsultantService
{
    //String chat(String msg);
    public Flux<String> chat(String msg);
}
