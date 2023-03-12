package com.example.einzelbeispielse2;

public class Calculate {
    String MNr;

    public Calculate(String MNr) {
        this.MNr = MNr;
    }

    public String calculateASCII(String input) {
        String newString ="";
        for (int i = 1; i < input.length(); i += 2) {
            char ch = input.charAt(i);
            int n = (int)ch + 48;
            newString += String.valueOf((char)(n));
        }
        return newString;
    }
}
