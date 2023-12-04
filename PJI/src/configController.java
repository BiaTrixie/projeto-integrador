import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class configController {

    @FXML
    private Button btnConta;

    @FXML
    private Button btnFaturamento;

    @FXML
    private Button btnPainel;

    @FXML
    private Button btnProd;

    @FXML
    private Label lbCadastroProd;

    @FXML
    private Label lbConfig;

    @FXML
    private Label lbConta;

    @FXML
    private Label lbFaturamento;

    @FXML
    private Label lbPainel;

    @FXML
    private Label lbPainel1;

    @FXML
    private Label lbemail;

    @FXML
    private Label lbnome;

    @FXML
    void telaConta(ActionEvent event) {
        abrirTelaConta(event);
    }

    @FXML
    void telaFaturamento(ActionEvent event) {
        abrirTelaFaturamento(event);
    }

    @FXML
    void telaPainel(ActionEvent event) {
         abrirTelaPainel(event);
    }

    @FXML
    void telaProduto(ActionEvent event) {
         abrirTelaProd(event);
    }

    private void abrirTelaFaturamento(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("faturamento.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnPainel.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Faturamento");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaConta(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("conta.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnPainel.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Conta");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaProd(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("produto.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnPainel.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Produto");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaPainel(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("painel.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnPainel.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Painel");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        String usuario = ApplicationContext.getUsuarioLogado();
    
        if (usuario != null) {
            lbnome.setText(usuario);
    
            // Agora pegamos o e-mail diretamente do ApplicationContext
            String email = ApplicationContext.getEmailLogado();
            lbemail.setText(email);
        }
    }
}
