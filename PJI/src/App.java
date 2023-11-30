import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public void start(Stage primaryStage) throws Exception {
        String caminhoFXML = "tela.fxml";
        System.out.println(getClass().getResource(caminhoFXML));

        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource(caminhoFXML));
        Parent root = fxmloader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Telinha");
        primaryStage.setScene(tela);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
