package br.gov.ufg.api;

import br.gov.ufg.entity.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testConstructorAndGetters() {
        Item item = new Item(1, 2, 3, 5, 10.0f);
        assertEquals(1, item.getIditemPedido(), "O id do item do pedido deve ser 1.");
        assertEquals(2, item.getIdPedido(), "O id do pedido deve ser 2.");
        assertEquals(3, item.getIdProduto(), "O id do produto deve ser 3.");
        assertEquals(5, item.getQuantidade(), "A quantidade deve ser 5.");
        assertEquals(10.0f, item.getPrecoUnitario(), "O preço unitário deve ser 10.0.");
    }

    @Test
    void testSetters() {
        Item item = new Item(1, 2, 3, 5, 10.0f);
        item.setIditemPedido(2);
        item.setIdPedido(3);
        item.setIdProduto(4);
        item.setQuantidade(10);
        item.setPrecoUnitario(15.0f);
        assertEquals(2, item.getIditemPedido(), "O id do item do pedido deve ser 2.");
        assertEquals(3, item.getIdPedido(), "O id do pedido deve ser 3.");
        assertEquals(4, item.getIdProduto(), "O id do produto deve ser 4.");
        assertEquals(10, item.getQuantidade(), "A quantidade deve ser 10.");
        assertEquals(15.0f, item.getPrecoUnitario(), "O preço unitário deve ser 15.0.");
    }

    @Test
    void testCalcularSubtotal() {
        Item item = new Item(1, 2, 3, 5, 10.0f);
        assertEquals(50.0, item.calcularSubtotal(), 0.001, "O subtotal deve ser 50.0.");
    }
}
