package be.bastinjul.rabbitmqtutorial.services;

import be.bastinjul.rabbitmqtutorial.messages.MsgType1;
import be.bastinjul.rabbitmqtutorial.messages.MsgType2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue toBeSentQueue;

    public ConverterService(RabbitTemplate rabbitTemplate, @Qualifier("ToBeSentQueue") Queue toBeSentQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.toBeSentQueue = toBeSentQueue;
    }

    @RabbitListener(queues = "#{ToBeConvertedQueue.name}")
    public void receiveMsgToConvert(MsgType1 msgType1) {
        MsgType2 msgType2 = new MsgType2(msgType1.getId(), msgType1.getName(), msgType1.getValue());
        LOGGER.info("Converting msgType1 with UUID '{}' to msgType2 with id '{}'", msgType1.getId(), msgType2.getId());
        rabbitTemplate.convertAndSend(toBeSentQueue.getName(), msgType2);
    }
}
