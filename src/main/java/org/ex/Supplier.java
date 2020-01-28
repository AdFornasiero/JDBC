package org.ex;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Supplier {

    public Label lbl_code;
    public TextField tf_code;
    public Button btn_search;
    public TextField lbl_name;
    public TextField lbl_adress;
    public TextField lbl_zip;
    public TextField lbl_city;
    public TextField lbl_contact;

    String dburl = "jdbc:mysql://localhost:3306/jarditou?serverTimezone=UTC";

    public void search(ActionEvent actionEvent) {

        String code = tf_code.getText();
        if(code.length() < 3 || code.length() > 6){
            lbl_code.setTextFill(Color.RED);
        }
        else{
            try{
                Connection db = DriverManager.getConnection(dburl, "root", "");
                PreparedStatement stmt = db.prepareStatement("select * from fournis where numfou = ?");
                stmt.setInt(1, Integer.parseInt(code));
                ResultSet result = stmt.executeQuery();

                if(!result.next()){
                    lbl_code.setTextFill(Color.RED);
                }
                else{
                    lbl_code.setTextFill(Color.BLACK);
                    lbl_name.setText(result.getString("nomfou"));
                    lbl_adress.setText(result.getString("ruefou"));
                    lbl_zip.setText(result.getString("posfou"));
                    lbl_city.setText(result.getString("vilfou"));
                    lbl_contact.setText(result.getString("confou"));
                }

            }
            catch(Exception e){
                System.out.println("erreur");
                System.out.println(e);
            }
        }

    }
}
