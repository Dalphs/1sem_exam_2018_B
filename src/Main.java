import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * This class has two constant classvariables that are public, SOFTWARE_VERSION and MEDIA_MAPPE
     */
    public static final String SOFTWARE_VERSION = "0.1.0";
    public static final String MEDIA_MAPPE = "media/";

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {


        launch(args);



    }

    //This method will start the Gui.FXML which contains the GUI
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
        primaryStage.setTitle("Files in folder");
        primaryStage.setScene(new Scene(root, 250, 400));
        primaryStage.show();

        Stage stage2 = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("DBGui.fxml"));
        stage2.setTitle("Database GUI");
        stage2.setScene(new Scene(root2, 310, 337));
        stage2.show();

        Stage stage3 = new Stage();
        Parent root3 = FXMLLoader.load(getClass().getResource("PictureGUI.fxml"));
        stage3.setTitle("Picture shower");
        stage3.setScene(new Scene(root3, 336, 400));
        stage3.show();



    }
}

