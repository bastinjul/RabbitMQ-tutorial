package be.bastinjul.rabbitmqtutorial.services;

import be.bastinjul.rabbitmqtutorial.messages.MsgType1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue toBeConvertedQueue;

    public ProducerService(RabbitTemplate rabbitTemplate, @Qualifier("ToBeConvertedQueue") Queue toBeConvertedQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.toBeConvertedQueue = toBeConvertedQueue;
    }

    public void sendMessage(String name, Double value) {
        MsgType1 msgType1 = new MsgType1(name, value);
        LOGGER.info("Sending msg with UUID '{}', name '{}' and value '{}'", msgType1.getId(), name, value);
        rabbitTemplate.convertAndSend(toBeConvertedQueue.getName(), msgType1);
    }
}
