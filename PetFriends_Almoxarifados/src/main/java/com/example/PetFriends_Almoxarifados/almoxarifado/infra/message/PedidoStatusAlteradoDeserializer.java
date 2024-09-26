package com.example.PetFriends_Almoxarifados.almoxarifado.infra.message;

import com.example.PetFriends_Almoxarifados.almoxarifado.domain.StatusPedido;
import com.example.PetFriends_Almoxarifados.almoxarifado.eventos.StatusAlterado;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PedidoStatusAlteradoDeserializer extends StdDeserializer<StatusAlterado> {

    public PedidoStatusAlteradoDeserializer() {
        super(StatusAlterado.class);
    }

    @Override
    public StatusAlterado deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        StatusAlterado evento = null;
        JsonNode node = jp.getCodec().readTree(jp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        try {
            evento = new StatusAlterado(
                    node.get("idPedido").asLong(),
                    StatusPedido.valueOf(node.get("estado").asText()),
                    sdf.parse(node.get("momento").asText())
            );
        } catch (ParseException e) {
            throw new IOException("Erro na data");
        }
        return evento;
    }
}

