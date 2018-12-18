import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField folderNameText;
    @FXML
    TextArea outputTextArea;



    public void SearchFolder(ActionEvent actionEvent) {
        Media m = new Media();
        String[] names = m.readMediaFolder(folderNameText.getText());

        for (String s: names) {
            outputTextArea.appendText(s + "\n");

        }
    }


}
