package br.gov.ufg.api;

class PessoaJuridica extends Cliente {
    //atributos
    String cnpj;
    String razaoSocial;
    String inscricaoEstadual;

    //construtor

    public PessoaJuridica(int idCliente, String nome, String email, String endereco, String telefone, String userName, String password, String cnpj, String razaoSocial, String inscricaoEstadual) {
        super(idCliente, nome, email, endereco, telefone, userName, password);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

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

    //métodos
    private boolean validarCNPJ(String cnpj) {
        //remover caractéres não numéricos
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14) {
            return false;
        }
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        int[] pesos = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            for (int j = 0; j < 12 + i; j++) {
                sum += (cnpj.charAt(j) - '0') * pesos[j + 1 - i];
            }
            int digit = (sum % 11 < 2) ? 0 : 11 - (sum % 11);
            if (digit != (cnpj.charAt(12 + i) - '0')) {
                return false;
            }
        }
        return false;
    }

        @Override
        public String toString(){
            return "PessoaJuridica{" +
                    "cnpj='" + cnpj + '\'' +
                    ", razaoSocial='" + razaoSocial + '\'' +
                    ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                    '}';
        }

    @Override
    protected String getTipo() {
        return "";
    }
}