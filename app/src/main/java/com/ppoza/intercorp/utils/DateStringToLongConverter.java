package com.ppoza.intercorp.utils;

import androidx.databinding.InverseMethod;

import com.ppoza.intercorp.config.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateStringToLongConverter {

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());

    public static long convertDateStringToLong(String text) {
        try {
            return simpleDateFormat.parse(text).getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    @InverseMethod(value="convertDateStringToLong")
    public static String convertLongToDateString(long value) {
        if(value == 0) {
            return "";
        }

        Date date = new Date(value);
        return simpleDateFormat.format(date);
    }
}
