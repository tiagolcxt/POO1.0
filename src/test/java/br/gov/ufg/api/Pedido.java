package br.gov.ufg.api;

import java.util.Arrays;
import java.util.Date;

public class Pedido {

    private int idPedido;
    private Data dataPedido;
    private String status;
    private int idCliente;
    private Item[] itens;

    public Pedido(int idPedido, int dia, int mes, int ano, String status, int idCliente) {
        this.idPedido = idPedido;
        this.dataPedido = new Data(dia, mes, ano);
        this.status = status;
        this.idCliente = idCliente;
    }

    public Pedido(Item[] itens) {
        this.itens = itens;
    }

    public int getIdPedido(int idPedido) {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Data getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Data dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public double calcularTotal(Item[] itens) {
        double total = 0;
        for (Item item : itens) {
            if (item != null) {
                total += item.calcularSubtotal();
            }
        }
        return total;
    }

    /*public String atualizarStatus(String status){

    }*/

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", dataPedido=" + dataPedido.toString() +
                ", status='" + status + '\'' +
                ", idCliente=" + idCliente +
                ", itens=" + Arrays.toString(itens) +
                '}';


    }

    public String itensComprados() {
        return "Pedido{" +
                "itens=" + Arrays.toString(itens) +
                "Subtotal=" + calcularTotal(itens) +
                '}';
    }
}
