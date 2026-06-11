package comitheima.consultant.repository;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

public class RedisChatMemoryStore implements ChatMemoryStore {

    //注入RedisTemplate
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        return List.of();
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        //更新会话消息
        //1.把list转换成json数据

        //2.把json数据存储到redis中

    }

    @Override
    public void deleteMessages(Object memoryId) {

    }
}
