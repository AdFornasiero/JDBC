package org.ex;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        String[] rules = {"required","min_length(250)","max_length(8)"};
        FormValidation.validField(tf_adress.getText(),rules);
        
    }
}
