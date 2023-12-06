import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_integrador";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "2506";

    public void salvarProduto(Produto produto) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO produtos (codigo, descricao, nome, valor_produto, valor_revenda) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, produto.getCodigo());
                preparedStatement.setString(2, produto.getDescricao());
                preparedStatement.setString(3, produto.getNome());
                preparedStatement.setDouble(4, produto.getValorProduto());
                preparedStatement.setDouble(5, produto.getValorRevenda());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
