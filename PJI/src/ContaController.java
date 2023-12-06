import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class ContaController {

    @FXML
    private Button btnPainel;

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
    private Label cnpjID;

    @FXML
    private Label emailID;

    @FXML
    private Label nameID;

    @FXML
    private Label userID;

    @FXML
    void telaConfig(ActionEvent event) {
        abrirTelaConfig(event);
    }

    @FXML
    void telaConta(ActionEvent event) {

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

    private Cliente clienteLogado;

    private ClienteDao clienteDao;

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

    private void abrirTelaConfig(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("config.fxml"));
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

    public ContaController() {
        this.clienteDao = new ClienteDao();
    }

    public void setClienteLogado(Cliente cliente) {
        this.clienteLogado = cliente;

        if (clienteLogado != null) {
            lbnome.setText(clienteLogado.getUsuario());

            // Use o ClienteDao para obter o e-mail
            String email = obterEmailPorUsuario(clienteLogado.getUsuario());

            if (email != null) {
                lbemail.setText(email);
            } else {
                System.out.println("E-mail não encontrado para o usuário: " + clienteLogado.getUsuario());
            }
        } else {
            System.out.println("Cliente não encontrado para o usuário: usuarioLogado");
        }
    }

    // Método para obter o e-mail por usuário usando o ClienteDao
    private String obterEmailPorUsuario(String usuario) {
        try {
            return clienteDao.obterEmailPorUsuario(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    void initialize() {
        String usuario = ApplicationContext.getUsuarioLogado();
    
        if (usuario != null) {
            lbnome.setText(usuario);
    
            try {
                Cliente cliente = clienteDao.obterClienteCompletoPorUsuario(usuario);
    
                if (cliente != null) {
                    String email = cliente.getEmail();
                    String nome = cliente.getNomeCompleto();
                    String cnpj = cliente.getCnpj();
                    String user = cliente.getUsuario();
    
                    userID.setText(user);
                    emailID.setText(email);
                    lbemail.setText(email);
                    nameID.setText(nome);
                    cnpjID.setText(cnpj);
                } else {
                    System.out.println("Cliente não encontrado para o usuário: " + usuario);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    

}
