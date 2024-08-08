package br.gov.ufg.api;

import br.gov.ufg.entity.Item;
import br.gov.ufg.entity.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

class PedidoTest {

    @Test
    void testConstructorAndGetters() {
        Data expectedData = new Data(7, 8, 2023); // Ajustado para dia, mês, ano
        Pedido pedido = new Pedido(1, 7, 8, 2023, "Aberto", 100);

        // Comparar os valores individuais da data
        assertEquals(1, pedido.getIdPedido(1), "O ID do pedido deve ser 1.");
        assertEquals(expectedData.getDia(), pedido.getDataPedido().getDia(), "O dia do pedido deve ser 07.");
        assertEquals(expectedData.getMes(), pedido.getDataPedido().getMes(), "O mês do pedido deve ser 08.");
        assertEquals(expectedData.getAno(), pedido.getDataPedido().getAno(), "O ano do pedido deve ser 2023.");
        assertEquals("Aberto", pedido.getStatus(), "O status do pedido deve ser 'Aberto'.");
        assertEquals(100, pedido.getIdCliente(), "O ID do cliente deve ser 100.");
    }

    @Test
    void testSetters() {
        Pedido pedido = new Pedido(1, 7, 8, 2023, "Aberto", 100);
        pedido.setIdPedido(2);
        pedido.setDataPedido(new Date(2023, 8, 8)); // Ajuste a ordem para dia, mês, ano
        pedido.setStatus("Fechado");
        pedido.setIdCliente(101);

        // Comparar os valores individuais da data
        assertEquals(2, pedido.getIdPedido(2), "O ID do pedido deve ser 2.");
        assertEquals(7, pedido.getDataPedido().getDia(), "O dia do pedido deve ser 07.");
        assertEquals(8, pedido.getDataPedido().getMes(), "O mês do pedido deve ser 08.");
        assertEquals(2023, pedido.getDataPedido().getAno(), "O ano do pedido deve ser 2023.");
        assertEquals("Fechado", pedido.getStatus(), "O status do pedido deve ser 'Fechado'.");
        assertEquals(101, pedido.getIdCliente(), "O ID do cliente deve ser 101.");
    }

    @Test
    void testCalcularTotal() {
        Item[] itens = {
            new Item(1, 2, 3, 2, 10.0f),
            new Item(2, 2, 4, 3, 20.0f)
        };
        Pedido pedido = new Pedido(List.of(itens));

        assertEquals(80.0, pedido.calcularTotal(List.of(itens)), 0.001, "O total do pedido deve ser 80.0.");
    }

    @Test
    void testItensComprados() {
        Item[] itens = {
            new Item(1, 2, 3, 2, 10.0f),
            new Item(2, 2, 4, 3, 20.0f)
        };
        Pedido pedido = new Pedido(List.of(itens));

        String expected = "Pedido{itens=" + Arrays.toString(itens) + ", Subtotal=80.0}";
        assertEquals(expected, pedido.itensComprados(), "A representação de itens comprados deve corresponder.");
    }
}
