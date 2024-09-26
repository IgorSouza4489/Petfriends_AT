package com.example.PetFriends_Almoxarifados.almoxarifado.infra.message;

import com.example.PetFriends_Almoxarifados.almoxarifado.eventos.StatusAlterado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

public class PetFriendsAlmoxarifadoMessageConfig {

    @Bean
    public JacksonPubSubMessageConverter estadoMudouConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(StatusAlterado.class, new PedidoStatusAlteradoSerializer());
        simpleModule.addDeserializer(StatusAlterado.class, new PedidoStatusAlteradoDeserializer());
        objectMapper.registerModule(simpleModule);
        return new JacksonPubSubMessageConverter(objectMapper);
    }

    @Bean
    public MessageChannel inputMessageChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter inboundChannelAdapter(
            @Qualifier("inputMessageChannel") MessageChannel messageChannel, PubSubTemplate pubSubTemplate) {

        pubSubTemplate.setMessageConverter(estadoMudouConverter());
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "PetFriends_Almoxarifados");
        adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(StatusAlterado.class);
        return adapter;
    }
}
