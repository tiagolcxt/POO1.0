package br.gov.ufg.controller;

import br.gov.ufg.dto.PedidoDTO;
import br.gov.ufg.entity.Pedido;
import br.gov.ufg.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private static final String CAMINHO_ARQUIVO = "database/pedidos.txt";

    @CrossOrigin
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPedido(@RequestBody Pedido pedido) {
        try {
            // Salvar pedido
            pedido.salvarPedido(CAMINHO_ARQUIVO);
            return ResponseEntity.ok("Pedido registrado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao registrar pedido.");
        }
    }

    @CrossOrigin
    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        System.out.println("teste");
        try {
            List<Pedido> pedidos = PedidoDTO.lerPedidosDoArquivo();
            return ResponseEntity.ok(pedidos);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
