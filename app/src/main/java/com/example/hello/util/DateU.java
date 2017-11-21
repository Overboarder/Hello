package com.example.hello.util;

import java.util.Calendar;

/**
 * Created by John on 2017/11/21.
 */

public class DateU {


    public static int dayType() {
        Calendar today = Calendar.getInstance();
        //2017-11-22小雪
        if (today.get(Calendar.YEAR) == 2017 && (today.get(Calendar.MONTH) + 1 == 11) && today.get(Calendar.DAY_OF_MONTH) == 22) {
            return 1;
        } else if (today.get(Calendar.YEAR) == 2017 && (today.get(Calendar.MONTH) + 1 == 11) && today.get(Calendar.DAY_OF_MONTH) == 23) {
            return 2;
        } else {
            return 0;
        }
    }

}
