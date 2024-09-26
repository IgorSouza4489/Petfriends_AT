package com.example.PetFriends_Almoxarifados.almoxarifado.infra.message;

import com.example.PetFriends_Almoxarifados.almoxarifado.eventos.StatusAlterado;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class PedidoStatusAlteradoSerializer extends StdSerializer<StatusAlterado> {

    public PedidoStatusAlteradoSerializer() {
        super(StatusAlterado.class);
    }

    @Override
    public void serialize(StatusAlterado evento, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("idPedido", evento.getIdPedido());
        jgen.writeStringField("estado", evento.getNovoStatus().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        String data = sdf.format(evento.getDataHoraAlteracao());
        jgen.writeStringField("momento", data);
    }
}
