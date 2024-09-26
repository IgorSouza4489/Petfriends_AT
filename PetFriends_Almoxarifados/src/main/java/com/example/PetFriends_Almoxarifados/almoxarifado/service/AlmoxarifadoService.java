package com.example.PetFriends_Almoxarifados.almoxarifado.service;

import com.example.PetFriends_Almoxarifados.almoxarifado.eventos.StatusAlterado;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AlmoxarifadoService {
    private static final Logger LOG = LoggerFactory.getLogger(AlmoxarifadoService.class);

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @ServiceActivator(inputChannel = "inputMessageChannelEstadoPedidoMudou")
    public void processarEstadoPedido(StatusAlterado evento,
                                      @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) ConvertedBasicAcknowledgeablePubsubMessage<StatusAlterado> message) {
        LOG.info("**Evento recebido: {}", evento);

        switch (evento.getNovoStatus()) {
            case NOVO:
                LOG.info("Pedido {} é novo. Preparando para alocação de estoque.", evento.getIdPedido());

                break;
            case EM_TRANSITO:
                LOG.info("Pedido {} está em trânsito.", evento.getIdPedido());

                break;
            case FECHADO:
                LOG.info("Pedido {} foi fechado.", evento.getIdPedido());
        }

    }
}