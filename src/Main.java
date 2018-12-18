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

        //The static method test is called from the Test class
        Media media = new Media();
        for (String s: media.readMediaFolder("media")) {
            System.out.println(s);
        }
        launch(args);



    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
        primaryStage.setTitle("Files in folder");
        primaryStage.setScene(new Scene(root, 250, 400));
        primaryStage.show();


    }
}

