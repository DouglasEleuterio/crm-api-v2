package br.com.tresptecnologia.service.rabbit;


import br.com.tresptecnologia.core.entity.BaseEntity;

public interface RabbitMQService {

    <T extends BaseEntity> void sendEvent(T t) ;
}
