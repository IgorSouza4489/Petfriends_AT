package com.example.atddd.transportes.infra.message;

import com.example.atddd.transportes.eventos.PedidoEntregue;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PedidoEntregueDeserializer extends StdDeserializer<PedidoEntregue> {

    public PedidoEntregueDeserializer() {
        super(PedidoEntregue.class);
    }

    @Override
    public PedidoEntregue deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        PedidoEntregue evento = null;
        JsonNode node = jp.getCodec().readTree(jp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        try {
            evento = new PedidoEntregue(
                    node.get("idPedido").asLong(),
                    sdf.parse(node.get("dataHoraEntrega").asText()),
                    node.get("estado").asText()
            );
        } catch (ParseException e) {
            throw new IOException("Erro na data");
        }
        return evento;
    }
}
