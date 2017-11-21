package com.example.hello.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by john on 2017/11/21.
 */

public class DayBean {


    /**
     * status : 200
     * message : success
     * data : {"year":2017,"month":11,"day":23,"lunarYear":2017,"lunarMonth":10,"lunarDay":6,"cnyear":"贰零壹柒 ","cnmonth":"十","cnday":"初六","hyear":"丁酉","cyclicalYear":"丁酉","cyclicalMonth":"辛亥","cyclicalDay":"甲寅","suit":"纳采,移徙,纳财,开市,交易,立券,纳财,入宅,修造,动土,竖柱,起基,定磉,造庙,安香,出火,修饰垣墙,平治道涂,会亲友,出行,开池,开厕","taboo":"开仓,盖屋,造桥,祭祀","animal":"鸡","week":"Thursday","festivalList":["感恩节"],"jieqi":{"7":"立冬","22":"小雪"},"maxDayInMonth":30,"leap":false,"lunarYearString":"丁酉","bigMonth":true}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * year : 2017
         * month : 11
         * day : 23
         * lunarYear : 2017
         * lunarMonth : 10
         * lunarDay : 6
         * cnyear : 贰零壹柒
         * cnmonth : 十
         * cnday : 初六
         * hyear : 丁酉
         * cyclicalYear : 丁酉
         * cyclicalMonth : 辛亥
         * cyclicalDay : 甲寅
         * suit : 纳采,移徙,纳财,开市,交易,立券,纳财,入宅,修造,动土,竖柱,起基,定磉,造庙,安香,出火,修饰垣墙,平治道涂,会亲友,出行,开池,开厕
         * taboo : 开仓,盖屋,造桥,祭祀
         * animal : 鸡
         * week : Thursday
         * festivalList : ["感恩节"]
         * jieqi : {"7":"立冬","22":"小雪"}
         * maxDayInMonth : 30
         * leap : false
         * lunarYearString : 丁酉
         * bigMonth : true
         */

        private int year;
        private int month;
        private int day;
        private int lunarYear;
        private int lunarMonth;
        private int lunarDay;
        private String cnyear;
        private String cnmonth;
        private String cnday;
        private String hyear;
        private String cyclicalYear;
        private String cyclicalMonth;
        private String cyclicalDay;
        private String suit;
        private String taboo;
        private String animal;
        private String week;
        private Map<String, String> jieqi;
        private int maxDayInMonth;
        private boolean leap;
        private String lunarYearString;
        private boolean bigMonth;
        private List<String> festivalList;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getLunarYear() {
            return lunarYear;
        }

        public void setLunarYear(int lunarYear) {
            this.lunarYear = lunarYear;
        }

        public int getLunarMonth() {
            return lunarMonth;
        }

        public void setLunarMonth(int lunarMonth) {
            this.lunarMonth = lunarMonth;
        }

        public int getLunarDay() {
            return lunarDay;
        }

        public void setLunarDay(int lunarDay) {
            this.lunarDay = lunarDay;
        }

        public String getCnyear() {
            return cnyear;
        }

        public void setCnyear(String cnyear) {
            this.cnyear = cnyear;
        }

        public String getCnmonth() {
            return cnmonth;
        }

        public void setCnmonth(String cnmonth) {
            this.cnmonth = cnmonth;
        }

        public String getCnday() {
            return cnday;
        }

        public void setCnday(String cnday) {
            this.cnday = cnday;
        }

        public String getHyear() {
            return hyear;
        }

        public void setHyear(String hyear) {
            this.hyear = hyear;
        }

        public String getCyclicalYear() {
            return cyclicalYear;
        }

        public void setCyclicalYear(String cyclicalYear) {
            this.cyclicalYear = cyclicalYear;
        }

        public String getCyclicalMonth() {
            return cyclicalMonth;
        }

        public void setCyclicalMonth(String cyclicalMonth) {
            this.cyclicalMonth = cyclicalMonth;
        }

        public String getCyclicalDay() {
            return cyclicalDay;
        }

        public void setCyclicalDay(String cyclicalDay) {
            this.cyclicalDay = cyclicalDay;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public String getTaboo() {
            return taboo;
        }

        public void setTaboo(String taboo) {
            this.taboo = taboo;
        }

        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public Map<String, String> getJieqi() {
            return jieqi;
        }

        public void setJieqi(Map<String, String> jieqi) {
            this.jieqi = jieqi;
        }

        public int getMaxDayInMonth() {
            return maxDayInMonth;
        }

        public void setMaxDayInMonth(int maxDayInMonth) {
            this.maxDayInMonth = maxDayInMonth;
        }

        public boolean isLeap() {
            return leap;
        }

        public void setLeap(boolean leap) {
            this.leap = leap;
        }

        public String getLunarYearString() {
            return lunarYearString;
        }

        public void setLunarYearString(String lunarYearString) {
            this.lunarYearString = lunarYearString;
        }

        public boolean isBigMonth() {
            return bigMonth;
        }

        public void setBigMonth(boolean bigMonth) {
            this.bigMonth = bigMonth;
        }

        public List<String> getFestivalList() {
            return festivalList;
        }

        public void setFestivalList(List<String> festivalList) {
            this.festivalList = festivalList;
        }

    }
}
