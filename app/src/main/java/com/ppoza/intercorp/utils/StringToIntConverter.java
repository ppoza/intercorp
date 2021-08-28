package com.ppoza.intercorp.utils;

import androidx.databinding.InverseMethod;

public class StringToIntConverter {

    public static int convertStringToInt(String text) {
        return Integer.parseInt(text);
    }

    @InverseMethod(value="convertStringToInt")
    public static String convertIntToString(int value) {
        if(value == 0) {
            return "";
        }
        return Integer.toString(value);
    }
}
