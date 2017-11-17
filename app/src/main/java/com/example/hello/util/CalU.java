package com.example.hello.util;

/**
 * Created by john on 2017/11/17.
 */

public class CalU {

    public static int calWea(int code) {
        switch (code) {
            case 0:
            case 1:
            case 2:
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
            case 11:
            case 12:
                return 3;
            case 13:
                return 4;
            case 14:
                return 5;
            case 15:
                return 6;
            case 16:
            case 17:
            case 18:
            case 19:
                return 7;
            case 20:
                return 8;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                return 9;
            case 26:
            case 27:
            case 28:
            case 29:
                return 10;
            case 30:
                return 11;
            case 31:
                return 12;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
                return 13;
            case 37:
                return 14;
            case 38:
                return 15;
            case 99:
                return 16;//未知
            default:
                break;
        }
        return 0;//default 晴
    }
}
