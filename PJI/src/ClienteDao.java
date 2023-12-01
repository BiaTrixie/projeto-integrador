
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_integrador";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "2506";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static Cliente buscarCliente(String usuario, String senha) throws SQLException {
        String sql = "SELECT * FROM tabela_clientes WHERE usuario = ? AND senha = ?";
        
        try (Connection connection = obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Cliente(
                        resultSet.getString("cnpj"),
                        resultSet.getString("email"),
                        resultSet.getString("nome_completo"),
                        resultSet.getString("senha"),
                        resultSet.getString("usuario")
                    );
                } else {
                    return null; 
                }
            }
        }
    }
    
    public Cliente obterClientePorUsuario(String usuario) {
        String sql = "SELECT * FROM tabela_clientes WHERE usuario = ?";
        
        try (Connection connection = obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
            preparedStatement.setString(1, usuario);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Cliente(
                        resultSet.getString("cnpj"),
                        resultSet.getString("email"),
                        resultSet.getString("nome_completo"),
                        resultSet.getString("senha"),
                        resultSet.getString("usuario")
                    );
                } else {
                    System.out.println("Cliente não encontrado para o usuário: " + usuario);
                    return null; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    

    public boolean salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO tabela_clientes (cnpj, email, nome_completo, senha, usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, cliente.getCnpj());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getNomeCompleto());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getUsuario());

            int linhasAfetadas = statement.executeUpdate();

            return linhasAfetadas > 0; // Retorna verdadeiro se pelo menos uma linha foi afetada.

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna falso em caso de exceção.
        }
    }

    public boolean clienteExistente(String usuario) {
        String sql = "SELECT COUNT(*) FROM tabela_clientes WHERE usuario = ?";

        try (Connection conexao = obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, usuario);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Retorna true se o cliente já existe, false caso contrário.
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Em caso de exceção ou erro, retorna false.
    }
}