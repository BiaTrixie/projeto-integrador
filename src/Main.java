import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    // private stactic Stage tela;
    // private stactic Scene inicial;

    public void start(Stage primaryStage) throws Exception {
       System.out.println(getClass().getResource("tela.fxml"));
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("tela.fxml"));
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
