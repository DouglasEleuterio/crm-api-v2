package br.com.tresptecnologia.service.rabbit;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.model.base.BaseMQEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQServiceImpl implements RabbitMQService{

    private final RabbitTemplate rabbitTemplate;

    @Value(value = "${application.rabbitmq.exchangename}")
    private String exchange;

    @Override
    public <T extends BaseEntity> void sendEvent(T t) {
        rabbitTemplate.convertAndSend(exchange, "", t);
    }
}
