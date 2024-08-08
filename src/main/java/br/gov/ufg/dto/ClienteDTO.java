package br.gov.ufg.dto;

import br.gov.ufg.api.Main;
import br.gov.ufg.entity.Cliente;
import br.gov.ufg.entity.PessoaFisica;
import br.gov.ufg.entity.PessoaJuridica;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private static final String CAMINHO_ARQUIVO = "database/clientes.txt";

    public static List<Cliente> lerClientesDoArquivo() throws IOException, URISyntaxException {
        // Tentar obter o caminho do arquivo como um recurso
        java.net.URL resource = Main.class.getClassLoader().getResource(CAMINHO_ARQUIVO);

        // Verificar se a URL do recurso é nula antes de converter
        if (resource == null) {
            // Se o arquivo não for encontrado, retornar uma lista vazia
            return new ArrayList<Cliente>();
        }

        // Converter URL para URI e obter o caminho absoluto
        java.nio.file.Path caminhoArquivoAbsoluto = Paths.get(resource.toURI());

        // Ler linhas do arquivo e mapear para objetos Cliente
        return Files.lines(caminhoArquivoAbsoluto)
                .map(line -> {
                    String[] dadosCliente = line.split(",");

                    if (dadosCliente.length < 11) {
                        // Se a linha não contém o número esperado de campos, retorne null
                        return null;
                    }

                    String tipo = dadosCliente[0];
                    if ("PJ".equals(tipo)) {
                        return new PessoaJuridica(
                                Integer.parseInt(dadosCliente[1]),  // idCliente
                                dadosCliente[2],                    // nome
                                dadosCliente[3],                    // email
                                dadosCliente[4],                    // endereco
                                dadosCliente[5],                    // telefone
                                dadosCliente[6],                    // username
                                dadosCliente[7],                    // password
                                dadosCliente[8],                    // cnpj
                                dadosCliente[9],                    // razao
                                dadosCliente[10]                    // outro dado para PJ
                        );
                    } else if ("PF".equals(tipo)) {
                        // Certifique-se de que há pelo menos 12 campos para PF
                        if (dadosCliente.length >= 12) {
                            //String[] dadosData = dadosCliente[11].split(",");
                            return new PessoaFisica(
                                Integer.parseInt(dadosCliente[1]),  // idCliente
                                dadosCliente[2],                    // nome
                                dadosCliente[3],                    // email
                                dadosCliente[4],                    // endereco
                                dadosCliente[5],                    // telefone
                                dadosCliente[6],                    // username
                                dadosCliente[7],                    // password
                                dadosCliente[8],                    // cpf
                                dadosCliente[9],                 // rg
                                Integer.parseInt(dadosCliente[10]),
                                Integer.parseInt(dadosCliente[11]),
                                Integer.parseInt(dadosCliente[12])     // dia     // ano
                            );
                        }
                        else{
                            System.out.println("nao ha 12 parametros");
                        }
                    }
                    return null; // Retornar null para linhas inválidas
                })
                .filter(cliente -> cliente != null) // Filtrar clientes nulos
                .collect(Collectors.toList());
    }
}