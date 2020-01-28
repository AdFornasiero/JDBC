package org.ex;

public class FormValidation {

    private String[] errors;
    public String[] validField(String value, String[] rules){

        for (String rule: rules) {


            switch(rule){
                case "required":
                    required(rule);
                    break;
                case "integer":
                    integer(rule);
                    break;

            }

        }
        return errors;
    }

    private void required(String value){

    }

    private void integer(String value){

    }

    private void min(String value, int min){

    }

    private void max(String value, int max){

    }



}
