package br.gov.ufg.api;

import br.gov.ufg.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() throws IOException {
        // Criar um arquivo clientes.txt temporário para testes
        try (FileWriter writer = new FileWriter("clientes.txt")) {
            writer.write("1,Nome Teste,email@teste.com,Rua Teste,12345678,username,password;\n");
        }

        // Inicializa um cliente com dados de teste
        cliente = new Cliente(1, "Nome Teste", "email@teste.com", "Rua Teste", "12345678", "username", "password") {
            @Override
            public String toFileString() {
                return "";
            }

            // Implementação de método abstrato para permitir instânciação
            @Override
            protected String getTipo() {
                return "Teste";
            }
        };
    }

    @Test
    void testLoginComCredenciaisCorretas() {
        assertTrue(Cliente.login("username", "password"), "O login deve ser bem-sucedido com credenciais corretas.");
    }

    @Test
    void testLoginComNomeDeUsuarioIncorreto() {
        assertFalse(Cliente.login("usuario_errado", "password"), "O login não deve ser bem-sucedido com nome de usuário incorreto.");
    }

    @Test
    void testLoginComSenhaIncorreta() {
        assertFalse(Cliente.login("username", "senha_errada"), "O login não deve ser bem-sucedido com senha incorreta.");
    }
}
