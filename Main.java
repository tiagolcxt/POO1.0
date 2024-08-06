import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //SALVAR PJ
        // PessoaJuridica h = new  PessoaJuridica(1, "Hawryson", "teste@gmail.com", "rua irma celina",
        //  "6269696969", "hawry", "senha", "090109", "nao sei oque e", "tambem nao sei");

          //SALVAR CLIENTE PF
        // PessoaFisica v = new PessoaFisica(0030,"Cardosinho","email@cardosinhogameplays.com","Ruah","629999999","messi"
        // ,"margarida","00011122233","1234", 23, 8, 2004);

        // try{
        //     h.salvarCliente("clientes.txt");
        //     v.salvarCliente("clientes.txt");
        // }
        // catch(IOException e){
        //     System.out.println("erro ao salvar cliente");
        // }

        try {
            // Ler clientes do arquivo usando o DTO
            List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();

            // Exibir lista de clientes carregados (opcional)
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toFileString());
            }

            // Tentar fazer login com o usuário fornecido
            String emailParaLogin = "teste@gmail.com";
            String senhaParaLogin = "senha";

            boolean sucessoLogin = Cliente.login(emailParaLogin, senhaParaLogin);

            if (sucessoLogin) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Falha no login. Verifique seu email e senha.");
            }

        } catch (IOException | URISyntaxException e) {
            System.err.println("Erro ao ler o arquivo de clientes: " + e.getMessage());
        }

        try {
            // Ler clientes do arquivo usando o DTO
            List<Cliente> clientesPf = ClienteDTO.lerClientesDoArquivo();


            String emailParaLoginpf = "email@cardosinhogameplays.com";
            String senhaParaLoginpf = "margarida";

            boolean logpf = Cliente.login(emailParaLoginpf, senhaParaLoginpf);

            if (logpf) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Falha no login. Verifique seu email e senha HH.");
            }
        }
        catch(IOException | URISyntaxException a){
            System.err.println("Erro ao ler o arquivo de clientes: " + a.getMessage());
        }
    }
}
