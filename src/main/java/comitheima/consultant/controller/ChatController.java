package comitheima.consultant.controller;

import comitheima.consultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
//    @Autowired
//    private OpenAiChatModel openAiChatModel;
//    @RequestMapping("/chat")
//    public String chat(String msg) {//浏览器传递的用户问题
//        String res=openAiChatModel.chat(msg);
//        return res;
//
//    }
    @Autowired
    private ConsultantService consultantService;
    @RequestMapping(value="/chat",produces = "text/html;charset=utf-8")//指定编码utf-8
//    public String chat(String msg) {
//        return consultantService.chat(msg);
//    }
    public Flux<String> chat(String msg) {
        return consultantService.chat(msg);
    }
}
