


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.SQLException;



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

        try {
            User user = ClienteDao.buscarUsuario(usuario, senha);

            if (user != null && user.validarCredenciais(usuario, senha)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Login bem-sucedido", "Bem-vindo, " + usuario + "!");
                abrirTelaInicial(event);
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro de login", "Usuário não encontrado. Verifique suas credenciais.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaInicial(ActionEvent event) throws IOException {
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("inicial.fxml"));
        Parent root = fxmloader.load();
        Scene telaInicial = new Scene(root);

        Stage stage = (Stage) btnEntrar.getScene().getWindow();
        stage.close();

        Stage novaJanela = new Stage();
        novaJanela.setTitle("Tela Inicial");
        novaJanela.setScene(telaInicial);
        novaJanela.show();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
