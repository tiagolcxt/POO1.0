
import java.util.ArrayList;

class PedidoTest {

    @Test
    void testCalcularTotal() {
        Item item1 = new Item(1, 1, 1, 2, 50.0f);
        Item item2 = new Item(2, 1, 2, 1, 30.0f);
        Pedido pedido = new Pedido(new Item[]{item1, item2});
        assertEquals(130.0, pedido.calcularTotal(pedido.getItens()));
    }

    @Test
    void testToString() {
        Item item1 = new Item(1, 1, 1, 2, 50.0f);
        Pedido pedido = new Pedido(1, 1, 1, 2024, "Pendente", 1);
        pedido.setItens(new Item[]{item1});
        String expected = "Pedido 1, dataPedido=1/1/2024, status='Pendente', idCliente=1, itens=[Item{idItemPedido=1, idPedido=1, idProduto=1, quantidade=2, precoUnitario=50.0}]";
        assertEquals(expected, pedido.toString());
    }
}
