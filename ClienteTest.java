import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.net.URISyntaxException;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(1, "John Doe", "john.doe@example.com", "123 Street", "123456789", "johndoe", "password123") {
            @Override
            protected String getTipo() {
                return "PF"; // ou "PJ", dependendo do tipo de cliente
            }
        };
    }

    @Test
    void testGetIdCliente() {
        assertEquals(1, cliente.getIdCliente());
    }

    @Test
    void testGetNome() {
        assertEquals("John Doe", cliente.getNome());
    }

    @Test
    void testSetNome() {
        cliente.setNome("Jane Doe");
        assertEquals("Jane Doe", cliente.getNome());
    }

    @Test
    void testLogin() throws IOException, URISyntaxException {
        // Configure o mock de leitura de arquivo para testes
        // Exemplo: crie um arquivo temporário com dados de login de teste

        // Teste de login bem-sucedido
        assertTrue(Cliente.login("john.doe@example.com", "password123"));

        // Teste de login com falha
        assertFalse(Cliente.login("john.doe@example.com", "wrongpassword"));
    }

    // Adicione mais testes conforme necessário para outros métodos
}
