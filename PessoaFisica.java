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


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    //métodos
    /*private boolean validarCNPJ(String cnpj){
    }*/
 
    public String toFileString() {
        return "PF," + getIdCliente() + "," + getNome() + "," + getEmail() + "," + getEndereco() + "," + getTelefone() +
        ","  + getUserName() + "," + getPassword() + "," + getCpf() + "," + getRg() + "," + data.getDia() + '/' + data.getMes() + '/' + data.getAno();
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
