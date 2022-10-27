package entities;

import entities.enums.OrdemStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date momento;
    private OrdemStatus status;

    private Cliente cliente;
    private List<PedidoItems> pedidoItems = new ArrayList<>();

    public Pedido(){

    }

    public Pedido(Date momento, OrdemStatus status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public void setStatus(OrdemStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addPedido(PedidoItems items){
        pedidoItems.add(items);
    }

    public void removePedido(PedidoItems items){
        pedidoItems.remove(items);
    }

    public double total(){
        double soma = 0.0;
        for(PedidoItems item : pedidoItems){
            soma += item.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento pedido ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("Starus pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente ");
        sb.append(cliente + "\n");
        sb.append("Items pedido:\n");
        for (PedidoItems item : pedidoItems) {
            sb.append(item + "\n");
        }
        sb.append("Preco total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
