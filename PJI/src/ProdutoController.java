
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProdutoController {

    @FXML
    private Button btnPainel;

    @FXML
    private Label lbnome;

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
    private TextField txCodigo;

    @FXML
    private TextField txDescricao;

    @FXML
    private TextField txEnviar;

    @FXML
    private TextField txNomeProd;

    @FXML
    private TextField txUpload;

    @FXML
    private TextField txValorProd;

    @FXML
    private TextField txValorRev;

    @FXML
    private Cliente clienteLogado;  

    @FXML
    void telaPainel(ActionEvent event) {
         abrirTelaPainel(event);
    }

    @FXML
    void telaproduto(ActionEvent event) {

    }

       private void abrirTelaPainel(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("painel.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnPainel.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Login");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setClienteLogado(Cliente cliente) {
        this.clienteLogado = cliente;
        lbnome.setText(cliente.getUsuario());
    }

}
