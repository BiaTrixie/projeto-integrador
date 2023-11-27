import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txSenha;

    @FXML
    private TextField txUsuario;

    @FXML
    void fazerLogin(ActionEvent event) {
        String usuario = txUsuario.getText();
        String senha = txSenha.getText();

        String url = "jdbc:postgresql://localhost:5432/projeto_integrador";
        String user = "postgres";
        String password = "2506";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, senha);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Usuário existe no banco de dados
                        System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario + "!");
                        // Adicione aqui o código para levar o usuário para a tela inicial
                    } else {
                        // Usuário não encontrado
                        System.out.println("Você não possui um registro.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
