
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

class ClienteDTOTest {

    @Test
    void testLerClientesDoArquivo() throws IOException, URISyntaxException {
        List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();
        assertNotNull(clientes);
        // Adicione mais validações com base em seus dados de teste
    }
}
