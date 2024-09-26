package com.example.PetFriends_Almoxarifados.almoxarifado.eventos;

import com.example.PetFriends_Almoxarifados.almoxarifado.domain.StatusPedido;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StatusAlterado implements Serializable {
    private Long idPedido;
    private StatusPedido novoStatus;
    private Date dataHoraAlteracao;

    public StatusAlterado() {}

    public StatusAlterado(Long idPedido, StatusPedido novoStatus) {
        this.idPedido = idPedido;
        this.novoStatus = novoStatus;
        this.dataHoraAlteracao = new Date();
    }

    public StatusAlterado(Long idPedido, StatusPedido novoStatus, Date dataHoraAlteracao) {
        this.idPedido = idPedido;
        this.novoStatus = novoStatus;
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    @Override
    public String toString() {
        return "PedidoStatusAlterado{" + "idPedido=" + idPedido + ", novoStatus=" + novoStatus + ", dataHoraAlteracao=" + dataHoraAlteracao + '}';
    }
}
