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
import java.util.HashMap;
import java.util.List;

public class FormValidation {

    private static List<String> errors = new ArrayList<>();
    private static HashMap<String, String> messages = new HashMap<>();
    private final static String[] numericalArgs = {"equals", "min", "max", "min_length", "max_length"};
    private final static String[] numericalRules = {"equals", "min", "max"};

    // CREER GETTER POUR RECUP LE HASHMAP DE MSGS D'ERREURS

    public static List<String> validField(String value, String[] rules){
        errors.clear();
        int intArg = 0;
        long intValue = 0;
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

            // Search if rule needs numerical value and parse it
            for(String numericalRule: numericalRules) {
                if(rule.equals(numericalRule)){
                    try{
                        intValue = Long.parseLong(value);
                    }
                    catch(Exception e){
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

                case "email":
                    email(value);
                    break;

                case "min_length":
                    if(value.length() < intArg) errors.add("Longueur min req");
                    break;

                case "max_length":
                    if(value.length() > intArg) errors.add("Longueur max req");
                    break;

                case "min":
                    if(intValue < intArg) errors.add("Valeur minimale requise");
                    break;

                case "max":
                    if(intValue > intArg) errors.add("Valeur maximale requise");
                    break;

                case "equals":
                    if(intValue != intArg) errors.add("Valeur exact requise");
                    break;
                case "matches":
                    if(!value.equals(arg)) errors.add("pas pareil");
                    break;
                case "regex":
                    if(!value.matches(arg)) errors.add("pas matché");
                    break;
                default:
                    System.out.println("Validation error: \'" + rule + "\' rule does not exist");
            }

        }
        return errors;
    }


    private static void regex(String value, String arg) {

    }

    private static void email(String value) {
        String emailRegex = "";
        if(!value.matches(emailRegex))
            errors.add("pas bon email");
    }

    private static void integer(String value){
        try{
            Long.parseLong(value);
        }
        catch(Exception e){
            errors.add("Pas entier");
        }
    }



}
