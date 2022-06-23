package be.bastinjul.rabbitmqtutorial.services;

import be.bastinjul.rabbitmqtutorial.messages.MsgType2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenderService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue toBeSentQueue;

    public SenderService(RabbitTemplate rabbitTemplate, @Qualifier("ToBeSentQueue") Queue toBeSentQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.toBeSentQueue = toBeSentQueue;
    }

    @RabbitListener(queues = "#{ToBeSentQueue.name}")
    public void receiveMsgToSend(MsgType2 msgType2) {
        if(new Random().nextBoolean()) { //the message is sent correctly
            LOGGER.info("The message with id '{}' converted from msg1 with UUID '{}' is sent", msgType2.getId(), msgType2.getMsgType1Id());
        } else {
            LOGGER.error("Message with id '{}' converted from msg1 with UUID '{}' is not sent correctly. Placing it in '{}' queue", msgType2.getId(), msgType2.getMsgType1Id(), toBeSentQueue.getName());
            rabbitTemplate.convertAndSend(toBeSentQueue.getName(), msgType2);
        }
    }
}
