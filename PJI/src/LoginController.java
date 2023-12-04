
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
            Cliente cliente = ClienteDao.buscarCliente(usuario, senha);

            if (cliente != null && cliente.validarCredenciais(usuario, senha)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Login bem-sucedido", "Bem-vindo, " + usuario + "!");
                String email = cliente.getEmail();
                ApplicationContext.setUsuarioLogado(usuario, email);
                abrirTelaInicial(cliente);
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro de login",
                        "Cliente não encontrado. Verifique suas credenciais.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaInicial(Cliente cliente) throws IOException {
        String usuario = ApplicationContext.getUsuarioLogado();
    
        if (usuario != null) {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("painel.fxml"));
            Parent root = fxmloader.load();
    
            PainelController painelController = fxmloader.getController();
            painelController.setUsuarioLogado(usuario);
    
            Scene telaInicial = new Scene(root);
    
            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            stage.close();
    
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela Inicial");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        }
    }
    

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}