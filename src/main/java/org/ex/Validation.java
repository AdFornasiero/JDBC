package org.ex;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Validation implements Initializable {

    public TextField tf_city, tf_contact, tf_zip, tf_adress, tf_name;
    public Button btn_add, btn_clear;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //FormValidation.setDatabase("jdbc:mysql://localhost:3306/jarditou?serverTimezone=UTC", "root", "");
    }

    public void clear(ActionEvent actionEvent) {
        tf_adress.clear();
        tf_city.clear();
        tf_contact.clear();
        tf_name.clear();
        tf_zip.clear();
    }

    public void add(ActionEvent actionEvent) {

    }

    public void contactChanged(ActionEvent actionEvent) {

    }

    public void cityChanged(ActionEvent actionEvent) {
    }

    public void zipChanged(ActionEvent actionEvent) {
    }

    public void adressChanged(ActionEvent actionEvent) {
    }

    public void nameChanged(ActionEvent actionEvent) {

        FormValidation.setMessage("required", "Ce champs est obligatoire");
        FormValidation.setMessage("email", "Entrez une adresse email valide");

        String[] nameRules = {"required", "min_length(5)", "unique(fournis.nomfou)", "email"};
        FormValidation.validField(tf_name.getText(),nameRules);

        System.out.println(FormValidation.getMessages());
    }


}
