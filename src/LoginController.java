import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

        if(usuario.equals("beatriz") && senha.equals("1234")){
            System.out.println("Login realizado com sucesso!");
        
        }
        else{
            System.out.println("Usuario ou senha invalidos!");
        }
    }

}
