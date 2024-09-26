package com.example.atddd.transportes.eventos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PedidoEntregue {
    private Long idPedido;
    private Date dataHoraEntrega;
    private String estado;


    public PedidoEntregue() {
    }

    public PedidoEntregue(Long idPedido, Date dataHoraEntrega, String estado) {
        this.idPedido = idPedido;
        this.dataHoraEntrega = dataHoraEntrega;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PedidoEntregue{" +
                "idPedido=" + idPedido +
                ", dataHoraEntrega=" + dataHoraEntrega +
                '}';
    }

}



