package br.gov.ufg.controller;
import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.entity.*;
import br.gov.ufg.utils.FileUtils;
import ch.qos.logback.core.net.server.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final String CAMINHO_ARQUIVO = "database/clientes.txt";

    @CrossOrigin
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.badRequest().body("Email já cadastrado.");

       /* try {
            // Verificar se o cliente já existe no arquivo
            List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();
            for (Cliente c : clientes) {
                if (c.getEmail().equals(cliente.getEmail())) {
                    return ResponseEntity.badRequest().body("Email já cadastrado.");
                }
            }
            // Salvar cliente
            ClientService cs = new ClientService();
            cs.salvarCliente(cliente);
            return ResponseEntity.ok("Cliente registrado com sucesso.");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao registrar cliente.");
        }*/
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest login) {
        try {
            List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(login.getEmail()) && cliente.getPassword().equals(login.getPassword())) {
                    return ResponseEntity.ok("Login bem-sucedido!");
                }
            }
            return ResponseEntity.status(401).body("Email ou senha incorretos.");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao verificar login.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        try {
            List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();
            return ResponseEntity.ok(clientes);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
