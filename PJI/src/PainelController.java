
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PainelController {

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnConta;

    @FXML
    private Button btnFaturamento;

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
    private Label lbemail;

    @FXML
    private Label lbnome;

    @FXML
    private Cliente clienteLogado;  

    

    @FXML
    void telaConta(ActionEvent event) {
        abrirTelaConta(event);
    }

    @FXML
    void telaFaturamento(ActionEvent event) {
        abrirTelaFaturamento(event); 
    }

    @FXML
    void telaProduto(ActionEvent event) {
        abrirTelaProduto(event);
    }

    @FXML
    void telaConfig(ActionEvent event) {
        abrirConfigurações(event);
    }

     private void abrirConfigurações(ActionEvent event) {
             try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("configurções.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnProd.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Configuração");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 private void abrirTelaFaturamento(ActionEvent event) {
             try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("faturamento.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnProd.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Faturamento");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaProduto(ActionEvent event) {
             try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("produto.fxml"));
            Parent root = fxmloader.load();
            Scene telaInicial = new Scene(root);

            Stage stage = (Stage) btnProd.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Tela de Cadastro de produto");
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

                

            Stage stage = (Stage) btnProd.getScene().getWindow();
            stage.close();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Conta");
            novaJanela.setScene(telaInicial);
            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setClienteLogado(Cliente cliente) {
        this.clienteLogado = cliente;
        lbnome.setText(cliente.getUsuario());
        String email = ApplicationContext.getEmailLogado();
        lbemail.setText(email);
    }

    @FXML
    void initialize() {
        String usuario = ApplicationContext.getUsuarioLogado();
    
        if (usuario != null) {
            lbnome.setText(usuario);
    
            String email = ApplicationContext.getEmailLogado();
            lbemail.setText(email);
        }
    }

    public void setUsuarioLogado(String usuario) {
    }
}