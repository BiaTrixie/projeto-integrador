

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

    public static User buscarUsuario(String nome, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
        
        try (Connection connection = obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(resultSet.getString("nome"), resultSet.getString("senha"));
                } else {
                    return null; 
                }
            }
        }
    }
}
