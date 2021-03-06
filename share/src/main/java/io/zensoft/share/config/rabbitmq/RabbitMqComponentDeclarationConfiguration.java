package io.zensoft.share.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqComponentDeclarationConfiguration {

    public static final String TOPIC_SHARE = "share";
    public static final String QUEUE_FACEBOOK_PUBLISH = "facebookPublish";
    public static final String QUEUE_FACEBOOK_GET_INFO = "facebookGetInfo";
    public static final String QUEUE_TELEGRAM_PUBLISH = "telegramPublish";
    public static final String QUEUE_TELEGRAM_GET_INFO = "telegramGetInfo";
    public static final String QUEUE_DIESEL_PUBLISH = "dieselPublish";
    public static final String QUEUE_DIESEL_GET_INFO = "dieselGetInfo";
    public static final String QUEUE_JOB_KG_PUBLISH = "jobKgPublish";
    public static final String QUEUE_JOB_KG_GET_INFO = "jobKgGetInfo";

    @Bean
    public TopicExchange shareTopicExchange() {
        return new TopicExchange(TOPIC_SHARE);
    }

    @Bean()
    public Queue facebookPublisherQueue() {
        return new Queue(QUEUE_FACEBOOK_PUBLISH);
    }

    @Bean
    public Queue facebookGetInfoQueue() {
        return new Queue(QUEUE_FACEBOOK_GET_INFO);
    }

    @Bean()
    public Queue telegramPublisherQueue() {
        return new Queue(QUEUE_TELEGRAM_PUBLISH);
    }

    @Bean
    public Queue telegramGetInfoQueue() {
        return new Queue(QUEUE_TELEGRAM_GET_INFO);
    }

    @Bean()
    public Queue dieselPublisherQueue() {
        return new Queue(QUEUE_DIESEL_PUBLISH);
    }

    @Bean
    public Queue dieselGetInfoQueue() {
        return new Queue(QUEUE_DIESEL_GET_INFO);
    }

    @Bean
    public Queue jobKgPublisherQueue() {
        return new Queue(QUEUE_JOB_KG_PUBLISH);
    }

    @Bean
    public Queue jobKgGetInfoQueue() {
        return new Queue(QUEUE_JOB_KG_GET_INFO);
    }

}
