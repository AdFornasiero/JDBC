package org.ex;

public class FormValidation {

    private static String[] errors;
    public static String[] validField(String value, String[] rules){

        int start, end;
        String arg;
        for (String rule: rules) {
            if(rule.lastIndexOf('(') != -1 && rule.lastIndexOf(')') != -1){
                arg = rule.substring(rule.lastIndexOf("(") + 1, rule.lastIndexOf(")"));
                rule = rule.substring(0,rule.length()-arg.length()-2);
            }

            switch(rule){
                case "required":
                    required(value);
                    break;
                case "integer":
                    integer(value);
                    break;
                case "min_length":
                    min_length(value, arg);
                    break;
                case "max_length":
                    max_length(value, arg);
                    break;
                case "min":
                    min(value, arg);
                    break;
                case "max":
                    max(value, arg);
                    break;
                default:
                    System.out.println("ERREUR");

            }

        }
        return errors;
    }

    private static void required(String value){

    }

    private static void integer(String value){

    }

    private static void min(String value, int min){

    }

    private static void max(String value, int max){

    }

    private static void min_length(String value, int min){

    }

    private static void max_length(String value, int max){

    }



}
