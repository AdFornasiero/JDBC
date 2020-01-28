package org.ex;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Orders implements Initializable {


    public ComboBox cb_supplier;
    public TextArea ta_orders;
    String dburl = "jdbc:mysql://localhost:3306/jarditou?serverTimezone=UTC";
    ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.add("Tous");
        try{
            Connection db = DriverManager.getConnection(dburl, "root", "");
            Statement stmt = db.createStatement();
            ResultSet result = stmt.executeQuery("select * from fournis");

            while(result.next()){
                list.add(result.getString("nomfou"));
            }
            cb_supplier.setItems(list);
        }
        catch(Exception e){

        }


    }

    public void getOrders(ActionEvent actionEvent) {

        String selected = cb_supplier.getValue().toString();
        String displayedText = "";
        ResultSet result = null;
        try{
            Connection db = DriverManager.getConnection(dburl, "root", "");
            if(selected.equals("Tous")){
                Statement stmt = db.createStatement();
                result = stmt.executeQuery("Select * from entcom");
            }
            else{
                PreparedStatement stmt = db.prepareStatement("Select * from entcom,fournis where entcom.numfou = fournis.numfou && nomfou = ? order by datcom");
                stmt.setString(1, selected);
                result = stmt.executeQuery();
            }

            if(!result.next()){
                displayedText = "\n\tAucune commande trouvée";
            }
            else{
                result.beforeFirst();
                while(result.next()){
                    displayedText = displayedText + result.getInt("numcom") + "   " + result.getString("datcom") + "  " + result.getString("obscom") + "\n";
                }
            }
            ta_orders.setText(displayedText);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
