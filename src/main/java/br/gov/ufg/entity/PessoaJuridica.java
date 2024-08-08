package br.gov.ufg.entity;

public class PessoaJuridica extends Cliente {
    // atributos
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;

    // construtor
    public PessoaJuridica(int idCliente, String nome, String email, String endereco, String telefone,
                          String userName, String password, String cnpj, String razaoSocial, String inscricaoEstadual) {
        super(idCliente, nome, email, endereco, telefone, userName, password);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public PessoaJuridica(Object nome, String email, String senha, String dataNascimento, String documento, String endereco, String inscricaoEstadual, String razaoSocial, String telefone) {
    }

    // getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String toFileString() {
        return "PJ" + "," + getIdCliente() + "," + getNome() + "," + getEmail() + "," + getEndereco() + "," + getTelefone() + "," +
                getUserName() + "," + getPassword() + "," + getCnpj() + "," + getRazaoSocial() + "," + getInscricaoEstadual();
    }
}