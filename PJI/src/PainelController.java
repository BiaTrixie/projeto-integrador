import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PainelController {

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
    private Label lbemail;

    @FXML
    private Label lbnome;

    @FXML
    void GetEmail(MouseEvent event) {

    }

    @FXML
    void GetNome(MouseEvent event) {

    }

    @FXML
    void cadastroProduto(MouseEvent event) {
        clickprod(event);
        abrirCadastroProduto(event);
    }

    @FXML
    void configuracao(MouseEvent event) {

    }

    @FXML
    void conta(MouseEvent event) {

    }

    @FXML
    void clickprod(MouseEvent event)  {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("produto.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) lbCadastroProd.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Cadastro de Produto");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void faturamento(MouseEvent event) {

    }

      private void abrirCadastroProduto(MouseEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("produto.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) lbCadastroProd.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Cadastro de Produto");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
