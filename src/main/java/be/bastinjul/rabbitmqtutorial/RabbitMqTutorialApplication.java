package be.bastinjul.rabbitmqtutorial;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqTutorialApplication.class, args);
    }

    @Bean("ToBeSentQueue")
    public Queue toBeSentMsgQueue() {
        return new Queue("msg.tobesent");
    }

    @Bean("ToBeConvertedQueue")
    public Queue toBeConvertedQueue() {
        return new Queue("msg.tobeconverted");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
