package com.java.moviereviewsite.services;

import com.java.moviereviewsite.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    public void sendEmail(String email){
        rabbitTemplate.convertAndSend(rabbitMQConfig.getQueueName(), email);
    }
}
