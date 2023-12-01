import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ContaController {

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnConta;

    @FXML
    private Button btnFaturamento;

    @FXML
    private Button btnProd;

    @FXML
    private Button btnProd1;

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
    void telaConfig(ActionEvent event) {

    }

    @FXML
    void telaConta(ActionEvent event) {

    }

    @FXML
    void telaFaturamento(ActionEvent event) {

    }

    @FXML
    void telaPainel(ActionEvent event) {
        abrirTelaPainel(event);
    }

    @FXML
    void telaProduto(ActionEvent event) {

    }

    @FXML
    private Cliente clienteLogado;

    private Cliente cliente;  

      private void abrirTelaPainel(ActionEvent event) {
             try {
                FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("seuArquivoFXML.fxml"));
                Parent root = fxmloader.load();
                Scene cena = new Scene(root);
                
                Stage stage = (Stage) btnProd.getScene().getWindow();
                stage.close();
                
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Painel");
                novaJanela.setScene(cena);
                novaJanela.show();
                
                // Agora chame setClienteLogado
                ContaController contaController = fxmloader.getController();
                contaController.setClienteLogado(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setClienteLogado(Cliente cliente) {
        this.clienteLogado = cliente;
        lbnome.setText(cliente.getUsuario());
    }
}
