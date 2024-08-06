import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Ler clientes do arquivo usando o DTO
            List<Cliente> clientes = ClienteDTO.lerClientesDoArquivo();

            // Exibir lista de clientes carregados (opcional)
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toFileString());
            }

            // Tentar fazer login com o usuário fornecido
            String emailParaLogin = "email@exemplo.com";
            String senhaParaLogin = "senhaForte";

            boolean sucessoLogin = Cliente.login(emailParaLogin, senhaParaLogin);

            if (sucessoLogin) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Falha no login. Verifique seu email e senha.");
            }

        } catch (IOException | URISyntaxException e) {
            System.err.println("Erro ao ler o arquivo de clientes: " + e.getMessage());
        }
    }
}
