package br.gov.ufg.entity;

import br.gov.ufg.entity.Cliente;
import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.utils.FileUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ClientService {

    private static final String CAMINHO_ARQUIVO = "database/clientes.txt";

    // Método para salvar um cliente no arquivo
    public void salvarCliente(Cliente cliente) throws IOException, URISyntaxException {
        List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();

        // Adicionar o cliente à lista
        clientes.add(cliente);

        // Escrever a lista de clientes de volta no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Cliente c : clientes) {
                writer.write(c.toString()); // Assumindo que Cliente tem um método toString adequado
                writer.newLine();
            }
        }
    }
}
