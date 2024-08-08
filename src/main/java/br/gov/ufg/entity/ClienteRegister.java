package br.gov.ufg.entity;

import br.gov.ufg.utils.FileUtils;

import java.io.IOException;
import java.util.Collections;

public class ClienteRegister {

    private String nome;
    private String email;
    private String senha;
    private String dataNascimento;
    private String documento;
    private String endereco;
    private String inscricaoEstadual;
    private String username;
    private String razaoSocial;
    private String rg;
    private String telefone;
    private String tipoDocumento;


    // Getters e Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Object getNome() {
        return nome;
    }

    private static int contador = 1;

    public static int gerarClienteId() {
        return contador++;
    }

    public String toFileString() {
        // Separando a data em ano, mês e dia
        String[] dataParts = dataNascimento.split("-");
        String dataFormatada = dataParts[2] + "," + dataParts[1] + "," + dataParts[0];


        if ("CPF".equals(tipoDocumento)) {
            // Montando a string para Pessoa Física (CPF)
            return "PF," +
                    gerarClienteId() + "," +
                    nome + "," +
                    email + "," +
                    endereco + "," +
                    telefone + "," +
                    email + "," +
                    senha + "," +
                    documento + "," +
                    rg + "," +
                    dataFormatada;
        } else if ("CNPJ".equals(tipoDocumento)) {
            // Montando a string para Pessoa Jurídica (CNPJ)
            return "PJ," +
                    gerarClienteId() + "," +
                    nome + "," +
                    email + "," +
                    endereco + "," +
                    telefone + "," +
                    email + "," +
                    senha + "," +
                    documento + "," +
                    inscricaoEstadual + "," +
                    razaoSocial;
        } else {
            throw new IllegalArgumentException("Tipo de documento inválido.");
        }
    }


    public void salvarNoArquivo(String caminhoArquivo) {
        try {
            String linha = toFileString();
            FileUtils.atualizarArquivo(caminhoArquivo, Collections.singletonList(linha));
        } catch (IOException e) {
            e.printStackTrace();
            // Adicione o tratamento de erro apropriado
        }
    }
}
