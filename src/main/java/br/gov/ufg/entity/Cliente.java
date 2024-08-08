package br.gov.ufg.entity;

import br.gov.ufg.dto.ClienteDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class Cliente {
    // atributos
    private int idCliente;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private String userName;
    private String senha;
    private String dataNascimento;
    private String documento;
    private String inscricaoEstadual;
    private String razaoSocial;
    private String rg;
    private String tipoDocumento;

    // Construtor padrão
    public Cliente() {
    }

    // Construtor completo
    public Cliente(String dataNascimento, String documento, String inscricaoEstadual, String razaoSocial, String rg, String tipoDocumento, String email, String senha, String endereco, String telefone, String userName, String nome, int idCliente) {
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
        this.rg = rg;
        this.tipoDocumento = tipoDocumento;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.userName = userName;
        this.nome = nome;
        this.idCliente = idCliente;
    }

    // Construtor básico
    public Cliente(int idCliente, String nome, String email, String endereco, String telefone, String userName, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.userName = userName;
        this.senha = senha;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        return senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }

    // Método de login
    public static boolean login(String email, String password) {
        try {
            ClienteDTO ClienteDTO = null;
            List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();
            for (Cliente cliente : clientes) {
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

    public abstract String toFileString();

    public void atualizaDados(Cliente clienteAtt) {
        this.nome = clienteAtt.getNome();
        this.email = clienteAtt.getEmail();
        this.endereco = clienteAtt.getEndereco();
        this.telefone = clienteAtt.getTelefone();
        this.userName = clienteAtt.getUserName();
        this.senha = clienteAtt.getPassword();
    }
}
