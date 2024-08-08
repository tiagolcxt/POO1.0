package br.gov.ufg.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testPessoaJuridica() {
		PessoaJuridica empresa = new PessoaJuridica(2, "Empresa XYZ", "contato@xyz.com", "Rua B, 456", "987654321",
				"empresaXYZ", "senha456", "12.345.678/0001-90", "XYZ Ltda", "123456789");

		assertEquals("Empresa XYZ", empresa.getNome());
		assertEquals("contato@xyz.com", empresa.getEmail());
		assertEquals("12.345.678/0001-90", empresa.getCnpj());
	}
}
