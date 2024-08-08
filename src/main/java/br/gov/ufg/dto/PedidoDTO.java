package br.gov.ufg.dto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import br.gov.ufg.entity.Item;
import br.gov.ufg.entity.Pedido;

public class PedidoDTO {

    private static final String CAMINHO_ARQUIVO = "database/pedidos.txt";

    public static List<Pedido> lerPedidosDoArquivo() throws IOException, URISyntaxException {
        java.net.URL resource = PedidoDTO.class.getClassLoader().getResource(CAMINHO_ARQUIVO);

        if (resource == null) {
            return new ArrayList<>();
        }

        java.nio.file.Path caminhoArquivoAbsoluto = Paths.get(resource.toURI());

        return Files.lines(caminhoArquivoAbsoluto)
                .map(line -> {
                    try {
                        String[] dadosPedido = line.split(",");

                        int idPedido = Integer.parseInt(dadosPedido[0]);
                        int dia = Integer.parseInt(dadosPedido[1]);
                        int mes = Integer.parseInt(dadosPedido[2]);
                        int ano = Integer.parseInt(dadosPedido[3]);
                        String status = dadosPedido[4];
                        int idCliente = Integer.parseInt(dadosPedido[5]);

                        Pedido pedido = new Pedido(idPedido, dia, mes, ano, status, idCliente);

                        List<Item> itens = new ArrayList<>();
                        for (int i = 6; i < dadosPedido.length; i += 3) {
                            int idProduto = Integer.parseInt(dadosPedido[i]);
                            int quantidade = Integer.parseInt(dadosPedido[i + 1]);
                            float precoUnitario = Float.parseFloat(dadosPedido[i + 2]);

                            Item item = new Item(idProduto, quantidade, precoUnitario);
                            itens.add(item);
                        }

                        pedido.setItens(itens);

                        return pedido;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(pedido -> pedido != null)
                .collect(Collectors.toList());
    }
}
