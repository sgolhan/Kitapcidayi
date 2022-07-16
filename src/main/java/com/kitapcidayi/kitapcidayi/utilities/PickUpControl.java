package com.kitapcidayi.kitapcidayi.utilities;

import java.util.Calendar;

public class PickUpControl {

    public java.sql.Date today (){
        Calendar cal = Calendar.getInstance();
        int year  = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day   = cal.get(Calendar.DAY_OF_MONTH);
        cal.clear();
        cal.set(year, month, day);
        return new java.sql.Date(cal.getTimeInMillis());
    }
}
