package com.example.hello.constant;

/**
 * Created by john on 2017/11/16.
 */

public class Constant {

    public static final String TOKEN = "https://curiousbaby.github.io";
    //私有api
    public static final String BG = TOKEN + "/hello/file/images/bg/";
    public static final int BG_AMOUNT = 10;
    public static final String BG_TYPE = ".jpg";
    public static final String CAT = TOKEN + "/hello/api/cat.json";
    public static final String WALLPAPER = TOKEN + "/hello/api/wallpaper.json";

    //公共api
    public static final String PUBLIC = "https://github.com/jokermonn/-Api";

    //天气
    public static final String WEATHER = "http://tj.nineton.cn/Heart/index/all";
    //无锡
    public static final String WUXI = "CHJS010000";
    //盐城
    public static final String YANCHENG = "CHJS060000";


    //每日一文,暂有问题返回400
    public static final String TODAYARTICLE = "https://interface.meiriyiwen.com/article/today?dev=1";
    public static final String RANDOMARTICLE = "https://interface.meiriyiwen.com/article/random?dev=1";
    //指定天,带参
    public static final String SPECIFICARTICLE = "https://interface.meiriyiwen.com/article/day?dev=1&date=20170216";

    //猫眼电影
    public static final String MOVIE = "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";


}
