import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

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

    private Cliente clienteLogado;  // Adicione esta linha

    @FXML
    void GetEmail(MouseEvent event) {

    }

    @FXML
    void GetNome(MouseEvent event) {

    }

    @FXML
    void configuracao(MouseEvent event) {

    }

    @FXML
    void conta(MouseEvent event) {

    }

    @FXML
    void faturamento(MouseEvent event) {

    }

    @FXML
    void telaConfig(MouseEvent event) {

    }

    @FXML
    void telaConta(MouseEvent event) {

    }

    @FXML
    void telaFaturamento(MouseEvent event) {

    }

    @FXML
    void telaProduto(MouseEvent event) {
        abrirTelaProduto(event);
    }

    private void abrirTelaProduto(MouseEvent event) {
    }

    public void setClienteLogado(Cliente cliente) {
        this.clienteLogado = cliente;
        lbnome.setText(cliente.getUsuario());
    }
}
