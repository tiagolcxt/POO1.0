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

    private static final String CAMINHO_ARQUIVO = "C:/Users/TIAGO/Desktop/POO1.0/src/main/resources/database/clientes.txt";

    @CrossOrigin
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCliente(@RequestBody ClienteRegister request) {
        try {
            // Obter a string no formato apropriado para o cliente
            String clienteString = request.toFileString();

            // Log para depuração
            System.out.println("Registrando cliente: " + clienteString);

            // Salvar no arquivo
            FileUtils.atualizarArquivo(CAMINHO_ARQUIVO, List.of(clienteString));
            return ResponseEntity.ok("Cliente registrado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao registrar cliente: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro inesperado ao registrar cliente: " + e.getMessage());
        }
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
}