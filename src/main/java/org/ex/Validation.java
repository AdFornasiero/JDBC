package org.ex;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class Validation {

    public TextField tf_city, tf_contact, tf_zip, tf_adress, tf_name;
    public Button btn_add, btn_clear;


    public void clear(ActionEvent actionEvent) {
        tf_adress.clear();
        tf_city.clear();
        tf_contact.clear();
        tf_name.clear();
        tf_zip.clear();
    }

    public void add(ActionEvent actionEvent) {
        String[] rules = {"email"};
        List<String> errors;
        errors = FormValidation.validField(tf_adress.getText(),rules);
        System.out.println(errors.toString());
    }
}
