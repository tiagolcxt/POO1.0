package br.gov.ufg.api;

import br.gov.ufg.api.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaFisicaTest {

    @Test
    void testConstructorAndGetters() {
        PessoaFisica pessoa = new PessoaFisica(1, "João Silva", "joao@example.com", "Rua A, 123", "123456789",
                "joaosilva", "senha123", "123.456.789-00", "MG-12.345.678", 7, 8, 1990);

        assertEquals(1, pessoa.getIdCliente(), "O ID do cliente deve ser 1.");
        assertEquals("João Silva", pessoa.getNome(), "O nome deve ser João Silva.");
        assertEquals("joao@example.com", pessoa.getEmail(), "O email deve ser joao@example.com.");
        assertEquals("Rua A, 123", pessoa.getEndereco(), "O endereço deve ser Rua A, 123.");
        assertEquals("123456789", pessoa.getTelefone(), "O telefone deve ser 123456789.");
        assertEquals("joaosilva", pessoa.getUserName(), "O username deve ser joaosilva.");
        assertEquals("senha123", pessoa.getPassword(), "A senha deve ser senha123.");
        assertEquals("123.456.789-00", pessoa.getCpf(), "O CPF deve ser 123.456.789-00.");
        assertEquals("MG-12.345.678", pessoa.getRg(), "O RG deve ser MG-12.345.678.");
        assertEquals(7, pessoa.getData().getDia(), "O dia de nascimento deve ser 7.");
        assertEquals(8, pessoa.getData().getMes(), "O mês de nascimento deve ser 8.");
        assertEquals(1990, pessoa.getData().getAno(), "O ano de nascimento deve ser 1990.");
    }

    @Test
    void testSetters() {
        PessoaFisica pessoa = new PessoaFisica(1, "João Silva", "joao@example.com", "Rua A, 123", "123456789",
                "joaosilva", "senha123", "123.456.789-00", "MG-12.345.678", 7, 8, 1990);

        pessoa.setCpf("987.654.321-00");
        pessoa.setRg("SP-98.765.432");
        pessoa.setData(new Data(1, 1, 2000));

        assertEquals("987.654.321-00", pessoa.getCpf(), "O CPF deve ser atualizado para 987.654.321-00.");
        assertEquals("SP-98.765.432", pessoa.getRg(), "O RG deve ser atualizado para SP-98.765.432.");
        assertEquals(1, pessoa.getData().getDia(), "O dia de nascimento deve ser atualizado para 1.");
        assertEquals(1, pessoa.getData().getMes(), "O mês de nascimento deve ser atualizado para 1.");
        assertEquals(2000, pessoa.getData().getAno(), "O ano de nascimento deve ser atualizado para 2000.");
    }

    @Test
    void testToString() {
        PessoaFisica pessoa = new PessoaFisica(1, "João Silva", "joao@example.com", "Rua A, 123", "123456789",
                "joaosilva", "senha123", "123.456.789-00", "MG-12.345.678", 7, 8, 1990);

        String expected = "PessoaFisica{IdCliente=1, nome='João Silva', email='joao@example.com', " +
                "endereco='Rua A, 123', telefone='123456789', userName='joaosilva', password='senha123'" +
                "cpf='123.456.789-00', rg='MG-12.345.678', data=7/8/1990}";

        assertEquals(expected, pessoa.toString(), "A representação em string deve corresponder.");
    }
}
