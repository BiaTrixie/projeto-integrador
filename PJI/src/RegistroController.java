
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txCNPJ;

    @FXML
    private TextField txEmail;

    @FXML
    private TextField txNomeCompleto;

    @FXML
    private TextField txSenha;

    @FXML
    private TextField txUsuario;

    private ClienteDao clienteDao = new ClienteDao();

    @FXML
    void fazerLogin(ActionEvent event) {
        abrirTelaLogin(event);
    }

    @FXML
    void fazerRegistro(ActionEvent event) {
        String cnpj = txCNPJ.getText();
        String email = txEmail.getText();
        String nomeCompleto = txNomeCompleto.getText();
        String senha = txSenha.getText();
        String usuario = txUsuario.getText();

        if (cnpj.isEmpty() || email.isEmpty() || nomeCompleto.isEmpty() || senha.isEmpty() || usuario.isEmpty()) {
            exibirAlerta("Preencha todos os campos", "Por favor, preencha todos os campos antes de registrar.");
            return;
        }

        if (clienteDao.clienteExistente(usuario)) {
            exibirAlerta("Usuário já registrado", "O usuário já está registrado. Escolha outro nome de usuário.");
            return;
        }

        Cliente cliente = new Cliente(cnpj, email, nomeCompleto, senha, usuario);
        boolean sucesso = clienteDao.salvarCliente(cliente);

        if (sucesso) {
            exibirAlerta("Registro bem-sucedido", "O registro foi salvo com sucesso no banco de dados!");
            abrirTelaLogin(event);
        } else {
            exibirAlerta("Erro no registro", "Erro ao salvar o registro no banco de dados.");
        }
    }

    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void abrirTelaLogin(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Login");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
