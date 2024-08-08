import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

class ProdutoTest {

    @Test
    void testProdutoCreation() {
        Produto produto = new Produto(1, "Produto A", "Descrição A", new BigDecimal("99.99"), 10, "imagem.jpg");
        assertEquals(1, produto.getId());
        assertEquals("Produto A", produto.getNome());
        assertEquals("Descrição A", produto.getDescricao());
        assertEquals(new BigDecimal("99.99"), produto.getPreco());
        assertEquals(10, produto.getEstoque());
        assertEquals("imagem.jpg", produto.getImagem());
    }

    @Test
    void testSetPreco() {
        Produto produto = new Produto(1, "Produto A", "Descrição A", new BigDecimal("99.99"), 10, "imagem.jpg");
        produto.setPreco(new BigDecimal("109.99"));
        assertEquals(new BigDecimal("109.99"), produto.getPreco());
    }

    @Test
    void testToString() {
        Produto produto = new Produto(1, "Produto A", "Descrição A", new BigDecimal("99.99"), 10, "imagem.jpg");
        String expected = "Produto{id=1, nome='Produto A', descricao='Descrição A', preco=99.99, estoque=10, imagem='imagem.jpg'}";
        assertEquals(expected, produto.toString());
    }
}
