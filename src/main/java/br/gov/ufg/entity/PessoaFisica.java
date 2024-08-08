package br.gov.ufg.entity;

import lombok.Getter;

@Getter
public class PessoaFisica extends Cliente{
    //atributos
    String cpf;
    String rg;
    Data data;

    //construtor


    public PessoaFisica(int IdCliente, String nome, String email, String endereco,
                        String telefone, String userName, String password, String cpf, String rg, int dia, int mes, int ano) {
        super(IdCliente, nome, email, endereco, telefone, userName, password);
        this.cpf = cpf;
        this.rg = rg;
        this.data = new Data(dia, mes, ano);
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setData(Data data) {
        this.data = data;
    }

    //métodos
    /*private boolean validarCNPJ(String cnpj){
    }*/
 
    public String toFileString() {
        return "PF" + ","+ getIdCliente() + "," + getNome() + "," + getEmail() + "," + getEndereco() + "," + getTelefone() +
        ","  + getUserName() + "," + getPassword() + "," + getCpf() + "," + getRg() + "," + this.data.getDia() + ","+this.data.getMes() + "," + this.data.getAno();
    }

    protected String getTipo() {
        return "PF";
    }

    @Override
    public String toString() {
        return "PF," +
                "IdCliente=" + getIdCliente() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", password='" + getPassword() + '\'' +
                "cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", data=" + data.getDia() + '/' + data.getMes() + '/' + data.getAno();
    }
}