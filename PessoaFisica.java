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

    public static boolean ValidaCPF(String Scpf) {

        // Remove caracteres não numéricos
        Scpf = Scpf.replaceAll("\\D", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (Scpf.length() != 11) {
            return false;
        }

        // Converte a string em um array de inteiros
        int[] cpf = new int[11];
        for (int i = 0; i < 11; i++) {
            cpf[i] = Character.getNumericValue(Scpf.charAt(i));
        }

        // Valida o primeiro dígito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += cpf[i] * (10 - i);
        }
        int resto1 = soma1 % 11;
        int digito1 = (resto1 < 2) ? 0 : 11 - resto1;

        // Valida o segundo dígito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += cpf[i] * (11 - i);
        }
        int resto2 = soma2 % 11;
        int digito2 = (resto2 < 2) ? 0 : 11 - resto2;

        // Compara os digitos
        return (digito1 == cpf[9]) && (digito2 == cpf[10]);
    }
 
    public String toFileString() {
        return "PF" + ","+ getIdCliente() + "," + getNome() + "," + getEmail() + "," + getEndereco() + "," + getTelefone() +
        ","  + getUserName() + "," + getPassword() + "," + getCpf() + "," + getRg() + "," + this.data.getDia() + ","+this.data.getMes() + "," + this.data.getAno();
    }

    @Override
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
