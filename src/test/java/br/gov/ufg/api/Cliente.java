package br.gov.ufg.api;

import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    //atributos
    private int IdCliente;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private String userName;
    private String password;

    //construtor
    public Cliente(int IdCliente, String nome, String email, String endereco, String telefone, String userName, String password) {
        this.IdCliente = IdCliente;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.userName = userName;
        this.password = password;
    }

    //contrutorGenerico

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método de login
    public static boolean login(String email, String password) {
        try {
            List<br.gov.ufg.entity.Cliente> clientes = ClienteDTO.lerClientesDoArquivo();
            for (br.gov.ufg.entity.Cliente cliente : clientes) {
                System.out.println(cliente.getEmail());
                System.out.println(cliente.getPassword());
                if (cliente.getEmail().equals(email) && cliente.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String toFileString() {
        return IdCliente + "," + nome + "," + email + "," + endereco + "," + telefone + "," + userName + "," + password;
    }

    public void salvarCliente(String caminhoArquivo) throws IOException {
        List<String> linhas = new ArrayList<>();
        linhas.add(toFileString());
        FileUtils.atualizarArquivo(caminhoArquivo, linhas);
    }

    public void atualizaDados(Cliente clienteAtt){
        this.nome = clienteAtt.getNome();
        this.email = clienteAtt.getEmail();
        this.endereco = clienteAtt.getEndereco();
        this.telefone = clienteAtt.getTelefone();
        this.userName = clienteAtt.getUserName();
        this.password = clienteAtt.getPassword();
    }

    // Implementação de método abstrato para permitir instânciação
    protected abstract String getTipo();
}