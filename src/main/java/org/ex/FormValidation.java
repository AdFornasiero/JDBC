package org.ex;

/*
RULES LIST
    required
    integer
    email
    minlength(int)
    maxlength(int)
    regex(string)
    matches(string)
    exists(table.field) // if exists in db
    unique(table.field) // if not exists in db
    // NUMERICAL VALUES
    equals(int)
    min(int)
    max(int)
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormValidation {

    private static List<String> errors = new ArrayList<>();
    private final static String[] numericalArgs = {"equals", "min", "max", "min_length", "max_length"};
    private final static String[] numericalRules = {"equals", "min", "max"};


    public static List<String> validField(String value, String[] rules){
        errors.clear();
        int intArg = 0, intValue = 0;
        String arg = "";

        for(String rule: rules) {
            // Check if an argument has been provided
            if(rule.lastIndexOf('(') != -1 && rule.lastIndexOf(')') != -1){
                arg = rule.substring(rule.lastIndexOf("(") + 1, rule.lastIndexOf(")"));
                rule = rule.substring(0,rule.length()-arg.length()-2);

                // Search for rules that need numerical arg to parse it
                for(String numericalArg: numericalArgs) {
                    if(rule.equals(numericalArg)){
                        try{
                            intArg = Integer.parseInt(arg);
                        }
                        catch(Exception e){
                            System.out.println(e.toString());

                        }
                    }
                }
            }

            // Search for rules that need numerical value and parse it
            for(String numericalRule: numericalRules) {
                if(rule.equals(numericalRule)){
                    try{
                        intValue = Integer.parseInt(value);
                    }
                    catch(Exception e){
                        System.out.println(intValue + " parsed");
                    }
                }
            }

            switch(rule){
                case "required":
                    if(value.isBlank()) errors.add("Champs obligatoire");
                    break;
                case "integer":
                    integer(value);
                    break;
                case "min_length":
                    min_length(value, intArg);
                    break;
                case "max_length":
                    max_length(value, intArg);
                    break;
                case "min":
                    min(intValue, intArg);
                    break;
                case "max":
                    max(intValue, intArg);
                    break;
                case "equals":
                    equal(intValue, intArg);
                    break;
                case "email":
                    email(value);
                    break;
                case "matches":
                    matches(value, arg);
                    break;
                case "regex":
                    regex(value, arg);
                    break;
                default:
                    System.out.println("ERREUR");

            }

        }
        return errors;
    }



    private static void regex(String value, String arg) {
    }

    private static void email(String value) {
    }

    private static void integer(String value){
 
    }

    private static void matches(String value, String arg) {
        if(value.equals(arg)) errors.add("pas matché");
    }

    private static void min(int value, int min){
        if(value < min) errors.add("Valeur minimale requise");
    }

    private static void max(int value, int max){
        if(value > max) errors.add("Valeur maximale requise");
    }

    private static void equal(int value, int arg) {
        if(value != arg) errors.add("Valeur exact requise");
    }

    private static void min_length(String value, int min){
        if(value.length() < min) errors.add("Longueur min req");

    }

    private static void max_length(String value, int max){
        if(value.length() > max) errors.add("Longueur max req");
    }



}
