import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

public class DBGuiController {
    Connection con;
    Statement st;
    ResultSet rs;

    @FXML
    TextField assetIDText;
    @FXML
    TextField nameText;
    @FXML
    TextField dateText;
    @FXML
    TextField fileNameText;

    public void viewRecord(ActionEvent actionEvent) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/tv2dk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM mediadata WHERE assetid = " + Integer.parseInt(assetIDText.getText()) + ";");

            rs.next();
            nameText.setText(rs.getString("name"));
            dateText.setText(rs.getString("date"));
            fileNameText.setText(rs.getString("filename"));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertRecord(ActionEvent actionEvent) {
        try {
            Media temp = new Media();
            String name = nameText.getText();
            String fileName = fileNameText.getText();
            con = DriverManager.getConnection("jdbc:mysql://localhost/tv2dk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            st = con.createStatement();
            String query = "INSERT INTO mediadata (assetid, name, date, filename) VALUES (" + temp.getAssetId()
            + ", '" + name + "', '" + temp.getCreated().toString() + "', '" + fileName + "');";

            st.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateRecord(ActionEvent actionEvent) {
        int assetID = Integer.parseInt(assetIDText.getText());
        String name = nameText.getText();
        String date = dateText.getText();
        String fileName = fileNameText.getText();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/tv2dk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            st = con.createStatement();
            String query = "UPDATE mediadata SET name = '" + name + "', date = '" + date + "', filename = '"
                    + fileName + "' WHERE assetID = " + assetID + ";";
            System.out.println(query);
            st.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(ActionEvent actionEvent) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/tv2dk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            st = con.createStatement();
            String query = "DELETE FROM mediadata WHERE assetid = " + Integer.parseInt(assetIDText.getText()) + ";";
            System.out.println(query);
            st.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
