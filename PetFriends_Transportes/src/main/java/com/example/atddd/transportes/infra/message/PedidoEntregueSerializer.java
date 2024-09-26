package com.example.atddd.transportes.infra.message;

import com.example.atddd.transportes.eventos.PedidoEntregue;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class PedidoEntregueSerializer extends StdSerializer<PedidoEntregue> {

    public PedidoEntregueSerializer() {
        super(PedidoEntregue.class);
    }

    @Override
    public void serialize(PedidoEntregue evento, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("idPedido", evento.getIdPedido());
        jgen.writeStringField("estado", evento.getEstado().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        String data = sdf.format(evento.getDataHoraEntrega());
        jgen.writeStringField("momento", data);
    }
}
