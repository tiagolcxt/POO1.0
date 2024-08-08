import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Data dataPedido;
    private String status;
    private int idCliente;
    private List<Item> itens;

    public Pedido(int idPedido, int dia, int mes, int ano, String status, int idCliente) {
        this.idPedido = idPedido;
        this.dataPedido = new Data(dia, mes, ano);
        this.status = status;
        this.idCliente = idCliente;
        this.itens = new ArrayList<>();
    }

    public Pedido(List<Item> itens) {
        this.itens = new ArrayList<>(itens);
    }

    public int getIdPedido() {
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

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            if (item != null) {
                total += item.calcularSubtotal();
            }
        }
        return total;
    }

    public void salvarPedido(String caminhoArquivo) throws IOException {
        List<String> linhas = new ArrayList<>();
        linhas.add(toString());
        FileUtils.atualizarArquivo(caminhoArquivo, linhas);
    }

    public String toFileString() {
        return getIdPedido() + "," + getStatus() + "," + getIdCliente() +
                "," + this.dataPedido.getDia() + "," + this.dataPedido.getMes() + "," + this.dataPedido.getAno();
    }

    @Override
    public String toString() {
        return "Pedido" + idPedido +
                ", dataPedido" + dataPedido.toString() +
                ", status" + status + '\'' +
                ", idCliente" + idCliente +
                ", itens" + itens.toString() + "\n";
    }

    public String itensComprados() {
        return "Pedido{" +
                "itens=" + itens.toString() +
                "Subtotal=" + calcularTotal() +
                '}';
    }
}
