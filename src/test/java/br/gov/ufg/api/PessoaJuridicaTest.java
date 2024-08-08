package br.gov.ufg.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaJuridicaTest {

    @Test
    void testConstructorAndGetters() {
        PessoaJuridica empresa = new PessoaJuridica(2, "Empresa XYZ", "contato@xyz.com", "Rua B, 456", "987654321",
                "empresaXYZ", "senha456", "12.345.678/0001-90", "XYZ Ltda", "123456789");

        assertEquals(2, empresa.getIdCliente(), "O ID do cliente deve ser 2.");
        assertEquals("Empresa XYZ", empresa.getNome(), "O nome deve ser Empresa XYZ.");
        assertEquals("contato@xyz.com", empresa.getEmail(), "O email deve ser contato@xyz.com.");
        assertEquals("Rua B, 456", empresa.getEndereco(), "O endereço deve ser Rua B, 456.");
        assertEquals("987654321", empresa.getTelefone(), "O telefone deve ser 987654321.");
        assertEquals("empresaXYZ", empresa.getUserName(), "O username deve ser empresaXYZ.");
        assertEquals("senha456", empresa.getPassword(), "A senha deve ser senha456.");
        assertEquals("12.345.678/0001-90", empresa.getCnpj(), "O CNPJ deve ser 12.345.678/0001-90.");
        assertEquals("XYZ Ltda", empresa.getRazaoSocial(), "A razão social deve ser XYZ Ltda.");
        assertEquals("123456789", empresa.getInscricaoEstadual(), "A inscrição estadual deve ser 123456789.");
    }

    @Test
    void testSetters() {
        PessoaJuridica empresa = new PessoaJuridica(2, "Empresa XYZ", "contato@xyz.com", "Rua B, 456", "987654321",
                "empresaXYZ", "senha456", "12.345.678/0001-90", "XYZ Ltda", "123456789");

        empresa.setCnpj("98.765.432/0001-01");
        empresa.setRazaoSocial("XYZ & Co");
        empresa.setInscricaoEstadual("987654321");

        assertEquals("98.765.432/0001-01", empresa.getCnpj(), "O CNPJ deve ser atualizado para 98.765.432/0001-01.");
        assertEquals("XYZ & Co", empresa.getRazaoSocial(), "A razão social deve ser atualizada para XYZ & Co.");
        assertEquals("987654321", empresa.getInscricaoEstadual(), "A inscrição estadual deve ser atualizada para 987654321.");
    }

    @Test
    void testToString() {
        PessoaJuridica empresa = new PessoaJuridica(2, "Empresa XYZ", "contato@xyz.com", "Rua B, 456", "987654321",
                "empresaXYZ", "senha456", "12.345.678/0001-90", "XYZ Ltda", "123456789");

        String expected = "PessoaJuridica{cnpj='12.345.678/0001-90', razaoSocial='XYZ Ltda', inscricaoEstadual='123456789'}";

        assertEquals(expected, empresa.toString(), "A representação em string deve corresponder.");
    }
}
