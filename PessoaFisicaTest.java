

class PessoaFisicaTest {

    @Test
    void testPessoaFisicaCreation() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "John Doe", "john@example.com", "Rua A", "123456789", "johndoe", "senha123", "00011122233", "123456", 1, 1, 1990);
        assertEquals("00011122233", pessoaFisica.getCpf());
        assertEquals("123456", pessoaFisica.getRg());
        assertEquals(1, pessoaFisica.getData().getDia());
        assertEquals(1, pessoaFisica.getData().getMes());
        assertEquals(1990, pessoaFisica.getData().getAno());
    }

    @Test
    void testToFileString() {
        PessoaFisica pessoaFisica = new PessoaFisica(1, "John Doe", "john@example.com", "Rua A", "123456789", "johndoe", "senha123", "00011122233", "123456", 1, 1, 1990);
        String expected = "PF,1,John Doe,john@example.com,Rua A,123456789,johndoe,senha123,00011122233,123456,1,1,1990";
        assertEquals(expected, pessoaFisica.toFileString());
    }
}
