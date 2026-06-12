package comitheima.consultant.repository;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository//交给ioc容器
public class RedisChatMemoryStore implements ChatMemoryStore {

    //注入RedisTemplate
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {

        String json = redisTemplate.opsForValue().get(memoryId.toString());
        if(json==null){
            return new ArrayList<>();
        }
        //把json数据转换成ChatMessage对象
        List<ChatMessage> chatMessage = ChatMessageDeserializer.messagesFromJson(json);
        return chatMessage;
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        //更新会话消息
        //1.把list转换成json数据
        String s = ChatMessageSerializer.messagesToJson(messages);
        //2.把json数据存储到redis中
        redisTemplate.opsForValue().set(memoryId.toString(),s, Duration.ofDays(1));//并且设置有效期为一天
    }

    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete(memoryId.toString());

    }
}
