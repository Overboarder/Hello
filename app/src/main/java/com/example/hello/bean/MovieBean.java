package com.example.hello.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by john on 2017/11/17.
 */

public class MovieBean {

    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"showInfo":"今天83家影院放映1521场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":278,"vd":"","dir":"扎克·施奈德","star":"本·阿弗莱克,亨利·卡维尔,盖尔·加朵","cat":"动作,冒险,科幻","wish":176293,"3d":true,"nm":"正义联盟","sc":8.8,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"本周五上映","dur":120,"snum":8841,"imax":true,"img":"http://p1.meituan.net/165.220/movie/b9395cd202a461303cf06cea89292071556090.png","src":"","showDate":"","time":"","id":341195},{"showInfo":"今天82家影院放映565场","late":false,"cnms":0,"sn":0,"scm":"剧情很玄乎，读起来很酷","preSale":0,"pn":132,"vd":"","dir":"王晶,钟少雄","star":"郑恺,张雨绮,谢依霖","cat":"喜剧,奇幻","wish":110683,"3d":true,"nm":"降魔传","sc":8.3,"ver":"2D/3D","rt":"本周五上映","dur":91,"snum":6870,"imax":false,"img":"http://p1.meituan.net/165.220/movie/9c80c528f3cd023472f2fec77671211b1021404.jpg","src":"","showDate":"","time":"","id":246019},{"showInfo":"今天79家影院放映394场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":137,"vd":"","dir":"董越","star":"段奕宏,江一燕,杜源","cat":"剧情,悬疑,犯罪","wish":15024,"3d":false,"nm":"暴雪将至","sc":7,"ver":"2D","rt":"本周五上映","dur":118,"snum":674,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c73c3b0511b40f083845445f1099a0a8958380.jpg","src":"","showDate":"","time":"","id":346511},{"showInfo":"今天77家影院放映230场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":99,"vd":"","dir":"吴宇森","star":"周润发,张国荣,狄龙","cat":"剧情,动作,犯罪","wish":30599,"3d":false,"nm":"英雄本色","sc":9.2,"ver":"2D/中国巨幕","rt":"本周五上映","dur":96,"snum":3138,"imax":false,"img":"http://p0.meituan.net/165.220/movie/5102b3f7261caa09c1c9b1212f09cc1f461902.png","src":"","showDate":"","time":"","id":313},{"showInfo":"今天64家影院放映161场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":76,"vd":"","dir":"彼得·博格","star":"马克·沃尔伯格,约翰·古德曼,J·K·西蒙斯","cat":"剧情,犯罪,灾难","wish":6226,"3d":false,"nm":"恐袭波士顿","sc":0,"ver":"2D","rt":"本周五上映","dur":131,"snum":560,"imax":false,"img":"http://p1.meituan.net/165.220/movie/61c672b7bfef63e41ca5796f3a36689f1048501.jpg","src":"","showDate":"","time":"","id":248268},{"showInfo":"今天50家影院放映114场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":264,"vd":"","dir":"塔伊加·维迪提","star":"克里斯·海姆斯沃斯,凯特·布兰切特,汤姆·希德勒斯顿","cat":"动作,冒险,奇幻","wish":218426,"3d":true,"nm":"雷神3：诸神黄昏","sc":8.9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2017-11-03上映","dur":130,"snum":222016,"imax":true,"img":"http://p1.meituan.net/165.220/movie/579a0919e926a80ad14c717c8d8a8394259181.jpg","src":"","showDate":"","time":"","id":249894},{"showInfo":"今天40家影院放映104场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":110,"vd":"","dir":"肯尼思·布拉纳","star":"肯尼思·布拉纳,刘风,约翰尼·德普","cat":"剧情,悬疑,犯罪","wish":71604,"3d":false,"nm":"东方快车谋杀案","sc":8.2,"ver":"2D","rt":"2017-11-10上映","dur":114,"snum":57265,"imax":false,"img":"http://p1.meituan.net/165.220/movie/ce979de334b1b6229ba125b4a31f5ce1650096.png","src":"","showDate":"","time":"","id":344422},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"吴导携白鸽，经典再重塑","preSale":1,"pn":195,"vd":"","dir":"吴宇森","star":"张涵予,福山雅治,戚薇","cat":"动作,犯罪","wish":51931,"3d":false,"nm":"追捕","sc":0,"ver":"2D","rt":"下周五上映","dur":107,"snum":530,"imax":false,"img":"http://p0.meituan.net/165.220/movie/7797d45caf40fcfcdc0f88378850e2441016690.jpg","src":"","showDate":"","time":"","id":248075},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"火线被引爆，自救逃亡道","preSale":1,"pn":75,"vd":"","dir":"常征","star":"段奕宏,余男,王景春","cat":"动作,犯罪","wish":31914,"3d":false,"nm":"引爆者","sc":0,"ver":"2D","rt":"下周五上映","dur":106,"snum":266,"imax":false,"img":"http://p1.meituan.net/165.220/movie/b0463d95e071532a4c5cd4eb4e8488631018469.jpg","src":"","showDate":"","time":"","id":1196171},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"心脏变利刃，抉择隐阴谋","preSale":1,"pn":43,"vd":"","dir":"张天辉","star":"陈都灵,林柏宏,汪铎","cat":"剧情,悬疑","wish":34845,"3d":false,"nm":"推理笔记","sc":0,"ver":"2D","rt":"下周五上映","dur":90,"snum":638,"imax":false,"img":"http://p0.meituan.net/165.220/movie/fe0224d3bde17520754f58f956232f68534526.png","src":"","showDate":"","time":"","id":1190680},{"showInfo":"今天18家影院放映21场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":73,"vd":"","dir":"汤山邦彦","star":"松本梨香,大谷育江,市川染五郎","cat":"动画,冒险,奇幻","wish":13958,"3d":false,"nm":"精灵宝可梦：波尔凯尼恩与机巧的玛机雅娜","sc":8.4,"ver":"2D","rt":"2017-11-11上映","dur":94,"snum":6593,"imax":false,"img":"http://p0.meituan.net/165.220/movie/b17171351fea5d297a21eaf15e50c476368269.jpg","src":"","showDate":"","time":"","id":617007},{"showInfo":"今天17家影院放映17场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":30,"vd":"","dir":"司徒永华","star":"凯蒂·萨瓦,克瑞姆·柏辛,凯瑟琳·希金斯","cat":"恐怖,惊悚,悬疑","wish":5465,"3d":false,"nm":"深宫怨灵","sc":0,"ver":"2D","rt":"本周五上映","dur":87,"snum":692,"imax":false,"img":"http://p1.meituan.net/165.220/movie/55d8dd7bc72dd37eb6a8278c3d01596c999560.jpg","src":"","showDate":"","time":"","id":635848},{"showInfo":"今天10家影院放映15场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":161,"vd":"","dir":"赵汉唐","star":"江一燕,赵汉唐","cat":"剧情,冒险","wish":12084,"3d":false,"nm":"七十七天","sc":8.7,"ver":"2D","rt":"2017-11-03上映","dur":115,"snum":29474,"imax":false,"img":"http://p0.meituan.net/165.220/movie/dd015fae6c6e85fb90adcd37af038a60382225.jpg","src":"","showDate":"","time":"","id":618704},{"showInfo":"今天10家影院放映14场","late":false,"cnms":0,"sn":0,"scm":"欲念比金重，难以辨奸忠","preSale":0,"pn":88,"vd":"","dir":"李子俊","star":"张晋,余文乐,文咏珊","cat":"剧情,动作,犯罪","wish":33394,"3d":true,"nm":"狂兽","sc":7.6,"ver":"2D/3D/中国巨幕","rt":"2017-11-10上映","dur":100,"snum":24493,"imax":false,"img":"http://p0.meituan.net/165.220/movie/fdf8d37852ddd13807fc3010546f86342371584.jpg","src":"","showDate":"","time":"","id":344500},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"","preSale":1,"pn":34,"vd":"","dir":"赛德里克·吉门内兹","star":"杰森·克拉克,裴淳华,杰克·奥康奈尔","cat":"剧情,战争,历史","wish":2894,"3d":false,"nm":"刺杀盖世太保","sc":0,"ver":"2D","rt":"下周五上映","dur":100,"snum":46,"imax":false,"img":"http://p1.meituan.net/165.220/movie/c66bef60115f204d1385d93027979c9e5057446.jpg","src":"","showDate":"","time":"","id":342276},{"showInfo":"今天6家影院放映7场","late":false,"cnms":0,"sn":0,"scm":"狂暴版后天，灾难满人间","preSale":0,"pn":55,"vd":"","dir":"迪安·德夫林","star":"杰拉德·巴特勒,吉姆·斯特吉斯,艾比·考尼什","cat":"动作,惊悚,灾难","wish":92251,"3d":true,"nm":"全球风暴","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2017-10-27上映","dur":109,"snum":170588,"imax":true,"img":"http://p1.meituan.net/165.220/movie/ceca5272db49154554f96829886f175a4555828.jpg","src":"","showDate":"","time":"","id":338402},{"showInfo":"2017-11-21 下周二上映","late":false,"cnms":0,"sn":0,"scm":"","preSale":1,"pn":101,"vd":"","dir":"梅峰","star":"范伟,殷桃,张超","cat":"剧情","wish":5595,"3d":false,"nm":"不成问题的问题","sc":0,"ver":"2D","rt":"下周二上映","dur":133,"snum":114,"imax":false,"img":"http://p1.meituan.net/165.220/movie/79bf2a025eee06a105d6a09376770e181364107.jpg","src":"","showDate":"","time":"","id":343476},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"神秘黑石头，肯定有来头","preSale":1,"pn":61,"vd":"","dir":"王良","star":"施景子,罗翔,苗青","cat":"恐怖,科幻","wish":6693,"3d":false,"nm":"七月半3：灵触第七感","sc":0,"ver":"2D","rt":"下周五上映","dur":83,"snum":139,"imax":false,"img":"http://p1.meituan.net/165.220/movie/42e7f9a363b6faa6a0240d37097b8f982813158.jpg","src":"","showDate":"","time":"","id":1133164},{"showInfo":"今天1家影院放映1场","late":false,"cnms":0,"sn":0,"scm":"成龙变老兵，复仇慰英灵","preSale":0,"pn":232,"vd":"","dir":"马丁·坎贝尔","star":"成龙,皮尔斯·布鲁斯南,刘涛","cat":"剧情,动作,犯罪","wish":114525,"3d":true,"nm":"英伦对决","sc":8.4,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2017-09-30上映","dur":116,"snum":175046,"imax":true,"img":"http://p1.meituan.net/165.220/movie/f7cbcd328a72b22c89a605c8c5197b40648862.jpg","src":"","showDate":"","time":"","id":345420},{"showInfo":"今天1家影院放映1场","late":false,"cnms":0,"sn":0,"scm":"一桩小恩怨，三代大和解","preSale":0,"pn":352,"vd":"","dir":"张艾嘉","star":"张艾嘉,田壮壮,郎月婷","cat":"剧情,爱情","wish":12428,"3d":false,"nm":"相爱相亲","sc":8.8,"ver":"2D","rt":"2017-11-03上映","dur":121,"snum":10462,"imax":false,"img":"http://p1.meituan.net/165.220/movie/8b8a04b3b3ccc8da05800574115178723211760.jpg","src":"","showDate":"","time":"","id":346641},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"","preSale":1,"pn":32,"vd":"","dir":"文晏","star":"文淇,周美君,史可","cat":"剧情,悬疑","wish":2824,"3d":false,"nm":"嘉年华","sc":0,"ver":"2D","rt":"下周五上映","dur":107,"snum":115,"imax":false,"img":"http://p1.meituan.net/165.220/movie/6dc90ebc7b3b740f6242c55ef0ee4961815296.png","src":"","showDate":"","time":"","id":1208113},{"showInfo":"今天暂无场次","late":false,"cnms":0,"sn":0,"scm":"科林叔回归，贱谍再起飞","preSale":0,"pn":416,"vd":"","dir":"马修·沃恩","star":"科林·费尔斯,塔伦·埃格顿,朱丽安·摩尔","cat":"动作,冒险,喜剧","wish":244337,"3d":true,"nm":"王牌特工2：黄金圈","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-10-20上映","dur":139,"snum":191018,"imax":true,"img":"http://p1.meituan.net/165.220/movie/8032e4157e1fb1f6cdb52fcc37698c074599808.jpg","src":"","showDate":"","time":"","id":341173},{"showInfo":"今天暂无场次","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":116,"vd":"","dir":"比利·奥古斯特","star":"刘亦菲,埃米尔·赫斯基,李芳淙","cat":"爱情,战争,历史","wish":25746,"3d":false,"nm":"烽火芳菲","sc":8,"ver":"2D","rt":"2017-11-10上映","dur":97,"snum":14792,"imax":false,"img":"http://p1.meituan.net/165.220/movie/0219e9a1d7bc29eaaf61bce9ba9de2f3470739.png","src":"","showDate":"","time":"","id":343985},{"showInfo":"今天暂无场次","late":false,"cnms":0,"sn":0,"scm":"浪子回头路，困难重重出","preSale":0,"pn":279,"vd":"","dir":"高晓攀,孙集斌","star":"高晓攀,尤宪超,于莎莎","cat":"剧情,喜剧","wish":16244,"3d":false,"nm":"兄弟，别闹！","sc":6.7,"ver":"2D","rt":"2017-11-10上映","dur":90,"snum":10429,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c67220e9e38f77dfcbe9931d35c85776544699.jpg","src":"","showDate":"","time":"","id":368034}]}
     */

    private ControlBean control;
    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        /**
         * expires : 1800
         */

        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * hasNext : false
         * movies : [{"showInfo":"今天83家影院放映1521场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":278,"vd":"","dir":"扎克·施奈德","star":"本·阿弗莱克,亨利·卡维尔,盖尔·加朵","cat":"动作,冒险,科幻","wish":176293,"3d":true,"nm":"正义联盟","sc":8.8,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"本周五上映","dur":120,"snum":8841,"imax":true,"img":"http://p1.meituan.net/165.220/movie/b9395cd202a461303cf06cea89292071556090.png","src":"","showDate":"","time":"","id":341195},{"showInfo":"今天82家影院放映565场","late":false,"cnms":0,"sn":0,"scm":"剧情很玄乎，读起来很酷","preSale":0,"pn":132,"vd":"","dir":"王晶,钟少雄","star":"郑恺,张雨绮,谢依霖","cat":"喜剧,奇幻","wish":110683,"3d":true,"nm":"降魔传","sc":8.3,"ver":"2D/3D","rt":"本周五上映","dur":91,"snum":6870,"imax":false,"img":"http://p1.meituan.net/165.220/movie/9c80c528f3cd023472f2fec77671211b1021404.jpg","src":"","showDate":"","time":"","id":246019},{"showInfo":"今天79家影院放映394场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":137,"vd":"","dir":"董越","star":"段奕宏,江一燕,杜源","cat":"剧情,悬疑,犯罪","wish":15024,"3d":false,"nm":"暴雪将至","sc":7,"ver":"2D","rt":"本周五上映","dur":118,"snum":674,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c73c3b0511b40f083845445f1099a0a8958380.jpg","src":"","showDate":"","time":"","id":346511},{"showInfo":"今天77家影院放映230场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":99,"vd":"","dir":"吴宇森","star":"周润发,张国荣,狄龙","cat":"剧情,动作,犯罪","wish":30599,"3d":false,"nm":"英雄本色","sc":9.2,"ver":"2D/中国巨幕","rt":"本周五上映","dur":96,"snum":3138,"imax":false,"img":"http://p0.meituan.net/165.220/movie/5102b3f7261caa09c1c9b1212f09cc1f461902.png","src":"","showDate":"","time":"","id":313},{"showInfo":"今天64家影院放映161场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":76,"vd":"","dir":"彼得·博格","star":"马克·沃尔伯格,约翰·古德曼,J·K·西蒙斯","cat":"剧情,犯罪,灾难","wish":6226,"3d":false,"nm":"恐袭波士顿","sc":0,"ver":"2D","rt":"本周五上映","dur":131,"snum":560,"imax":false,"img":"http://p1.meituan.net/165.220/movie/61c672b7bfef63e41ca5796f3a36689f1048501.jpg","src":"","showDate":"","time":"","id":248268},{"showInfo":"今天50家影院放映114场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":264,"vd":"","dir":"塔伊加·维迪提","star":"克里斯·海姆斯沃斯,凯特·布兰切特,汤姆·希德勒斯顿","cat":"动作,冒险,奇幻","wish":218426,"3d":true,"nm":"雷神3：诸神黄昏","sc":8.9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2017-11-03上映","dur":130,"snum":222016,"imax":true,"img":"http://p1.meituan.net/165.220/movie/579a0919e926a80ad14c717c8d8a8394259181.jpg","src":"","showDate":"","time":"","id":249894},{"showInfo":"今天40家影院放映104场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":110,"vd":"","dir":"肯尼思·布拉纳","star":"肯尼思·布拉纳,刘风,约翰尼·德普","cat":"剧情,悬疑,犯罪","wish":71604,"3d":false,"nm":"东方快车谋杀案","sc":8.2,"ver":"2D","rt":"2017-11-10上映","dur":114,"snum":57265,"imax":false,"img":"http://p1.meituan.net/165.220/movie/ce979de334b1b6229ba125b4a31f5ce1650096.png","src":"","showDate":"","time":"","id":344422},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"吴导携白鸽，经典再重塑","preSale":1,"pn":195,"vd":"","dir":"吴宇森","star":"张涵予,福山雅治,戚薇","cat":"动作,犯罪","wish":51931,"3d":false,"nm":"追捕","sc":0,"ver":"2D","rt":"下周五上映","dur":107,"snum":530,"imax":false,"img":"http://p0.meituan.net/165.220/movie/7797d45caf40fcfcdc0f88378850e2441016690.jpg","src":"","showDate":"","time":"","id":248075},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"火线被引爆，自救逃亡道","preSale":1,"pn":75,"vd":"","dir":"常征","star":"段奕宏,余男,王景春","cat":"动作,犯罪","wish":31914,"3d":false,"nm":"引爆者","sc":0,"ver":"2D","rt":"下周五上映","dur":106,"snum":266,"imax":false,"img":"http://p1.meituan.net/165.220/movie/b0463d95e071532a4c5cd4eb4e8488631018469.jpg","src":"","showDate":"","time":"","id":1196171},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"心脏变利刃，抉择隐阴谋","preSale":1,"pn":43,"vd":"","dir":"张天辉","star":"陈都灵,林柏宏,汪铎","cat":"剧情,悬疑","wish":34845,"3d":false,"nm":"推理笔记","sc":0,"ver":"2D","rt":"下周五上映","dur":90,"snum":638,"imax":false,"img":"http://p0.meituan.net/165.220/movie/fe0224d3bde17520754f58f956232f68534526.png","src":"","showDate":"","time":"","id":1190680},{"showInfo":"今天18家影院放映21场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":73,"vd":"","dir":"汤山邦彦","star":"松本梨香,大谷育江,市川染五郎","cat":"动画,冒险,奇幻","wish":13958,"3d":false,"nm":"精灵宝可梦：波尔凯尼恩与机巧的玛机雅娜","sc":8.4,"ver":"2D","rt":"2017-11-11上映","dur":94,"snum":6593,"imax":false,"img":"http://p0.meituan.net/165.220/movie/b17171351fea5d297a21eaf15e50c476368269.jpg","src":"","showDate":"","time":"","id":617007},{"showInfo":"今天17家影院放映17场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":30,"vd":"","dir":"司徒永华","star":"凯蒂·萨瓦,克瑞姆·柏辛,凯瑟琳·希金斯","cat":"恐怖,惊悚,悬疑","wish":5465,"3d":false,"nm":"深宫怨灵","sc":0,"ver":"2D","rt":"本周五上映","dur":87,"snum":692,"imax":false,"img":"http://p1.meituan.net/165.220/movie/55d8dd7bc72dd37eb6a8278c3d01596c999560.jpg","src":"","showDate":"","time":"","id":635848},{"showInfo":"今天10家影院放映15场","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":161,"vd":"","dir":"赵汉唐","star":"江一燕,赵汉唐","cat":"剧情,冒险","wish":12084,"3d":false,"nm":"七十七天","sc":8.7,"ver":"2D","rt":"2017-11-03上映","dur":115,"snum":29474,"imax":false,"img":"http://p0.meituan.net/165.220/movie/dd015fae6c6e85fb90adcd37af038a60382225.jpg","src":"","showDate":"","time":"","id":618704},{"showInfo":"今天10家影院放映14场","late":false,"cnms":0,"sn":0,"scm":"欲念比金重，难以辨奸忠","preSale":0,"pn":88,"vd":"","dir":"李子俊","star":"张晋,余文乐,文咏珊","cat":"剧情,动作,犯罪","wish":33394,"3d":true,"nm":"狂兽","sc":7.6,"ver":"2D/3D/中国巨幕","rt":"2017-11-10上映","dur":100,"snum":24493,"imax":false,"img":"http://p0.meituan.net/165.220/movie/fdf8d37852ddd13807fc3010546f86342371584.jpg","src":"","showDate":"","time":"","id":344500},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"","preSale":1,"pn":34,"vd":"","dir":"赛德里克·吉门内兹","star":"杰森·克拉克,裴淳华,杰克·奥康奈尔","cat":"剧情,战争,历史","wish":2894,"3d":false,"nm":"刺杀盖世太保","sc":0,"ver":"2D","rt":"下周五上映","dur":100,"snum":46,"imax":false,"img":"http://p1.meituan.net/165.220/movie/c66bef60115f204d1385d93027979c9e5057446.jpg","src":"","showDate":"","time":"","id":342276},{"showInfo":"今天6家影院放映7场","late":false,"cnms":0,"sn":0,"scm":"狂暴版后天，灾难满人间","preSale":0,"pn":55,"vd":"","dir":"迪安·德夫林","star":"杰拉德·巴特勒,吉姆·斯特吉斯,艾比·考尼什","cat":"动作,惊悚,灾难","wish":92251,"3d":true,"nm":"全球风暴","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2017-10-27上映","dur":109,"snum":170588,"imax":true,"img":"http://p1.meituan.net/165.220/movie/ceca5272db49154554f96829886f175a4555828.jpg","src":"","showDate":"","time":"","id":338402},{"showInfo":"2017-11-21 下周二上映","late":false,"cnms":0,"sn":0,"scm":"","preSale":1,"pn":101,"vd":"","dir":"梅峰","star":"范伟,殷桃,张超","cat":"剧情","wish":5595,"3d":false,"nm":"不成问题的问题","sc":0,"ver":"2D","rt":"下周二上映","dur":133,"snum":114,"imax":false,"img":"http://p1.meituan.net/165.220/movie/79bf2a025eee06a105d6a09376770e181364107.jpg","src":"","showDate":"","time":"","id":343476},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"神秘黑石头，肯定有来头","preSale":1,"pn":61,"vd":"","dir":"王良","star":"施景子,罗翔,苗青","cat":"恐怖,科幻","wish":6693,"3d":false,"nm":"七月半3：灵触第七感","sc":0,"ver":"2D","rt":"下周五上映","dur":83,"snum":139,"imax":false,"img":"http://p1.meituan.net/165.220/movie/42e7f9a363b6faa6a0240d37097b8f982813158.jpg","src":"","showDate":"","time":"","id":1133164},{"showInfo":"今天1家影院放映1场","late":false,"cnms":0,"sn":0,"scm":"成龙变老兵，复仇慰英灵","preSale":0,"pn":232,"vd":"","dir":"马丁·坎贝尔","star":"成龙,皮尔斯·布鲁斯南,刘涛","cat":"剧情,动作,犯罪","wish":114525,"3d":true,"nm":"英伦对决","sc":8.4,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2017-09-30上映","dur":116,"snum":175046,"imax":true,"img":"http://p1.meituan.net/165.220/movie/f7cbcd328a72b22c89a605c8c5197b40648862.jpg","src":"","showDate":"","time":"","id":345420},{"showInfo":"今天1家影院放映1场","late":false,"cnms":0,"sn":0,"scm":"一桩小恩怨，三代大和解","preSale":0,"pn":352,"vd":"","dir":"张艾嘉","star":"张艾嘉,田壮壮,郎月婷","cat":"剧情,爱情","wish":12428,"3d":false,"nm":"相爱相亲","sc":8.8,"ver":"2D","rt":"2017-11-03上映","dur":121,"snum":10462,"imax":false,"img":"http://p1.meituan.net/165.220/movie/8b8a04b3b3ccc8da05800574115178723211760.jpg","src":"","showDate":"","time":"","id":346641},{"showInfo":"2017-11-24 下周五上映","late":false,"cnms":0,"sn":0,"scm":"","preSale":1,"pn":32,"vd":"","dir":"文晏","star":"文淇,周美君,史可","cat":"剧情,悬疑","wish":2824,"3d":false,"nm":"嘉年华","sc":0,"ver":"2D","rt":"下周五上映","dur":107,"snum":115,"imax":false,"img":"http://p1.meituan.net/165.220/movie/6dc90ebc7b3b740f6242c55ef0ee4961815296.png","src":"","showDate":"","time":"","id":1208113},{"showInfo":"今天暂无场次","late":false,"cnms":0,"sn":0,"scm":"科林叔回归，贱谍再起飞","preSale":0,"pn":416,"vd":"","dir":"马修·沃恩","star":"科林·费尔斯,塔伦·埃格顿,朱丽安·摩尔","cat":"动作,冒险,喜剧","wish":244337,"3d":true,"nm":"王牌特工2：黄金圈","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-10-20上映","dur":139,"snum":191018,"imax":true,"img":"http://p1.meituan.net/165.220/movie/8032e4157e1fb1f6cdb52fcc37698c074599808.jpg","src":"","showDate":"","time":"","id":341173},{"showInfo":"今天暂无场次","late":false,"cnms":0,"sn":0,"scm":"","preSale":0,"pn":116,"vd":"","dir":"比利·奥古斯特","star":"刘亦菲,埃米尔·赫斯基,李芳淙","cat":"爱情,战争,历史","wish":25746,"3d":false,"nm":"烽火芳菲","sc":8,"ver":"2D","rt":"2017-11-10上映","dur":97,"snum":14792,"imax":false,"img":"http://p1.meituan.net/165.220/movie/0219e9a1d7bc29eaaf61bce9ba9de2f3470739.png","src":"","showDate":"","time":"","id":343985},{"showInfo":"今天暂无场次","late":false,"cnms":0,"sn":0,"scm":"浪子回头路，困难重重出","preSale":0,"pn":279,"vd":"","dir":"高晓攀,孙集斌","star":"高晓攀,尤宪超,于莎莎","cat":"剧情,喜剧","wish":16244,"3d":false,"nm":"兄弟，别闹！","sc":6.7,"ver":"2D","rt":"2017-11-10上映","dur":90,"snum":10429,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c67220e9e38f77dfcbe9931d35c85776544699.jpg","src":"","showDate":"","time":"","id":368034}]
         */

        private boolean hasNext;
        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            /**
             * showInfo : 今天83家影院放映1521场
             * late : false
             * cnms : 0
             * sn : 0
             * scm :
             * preSale : 0
             * pn : 278
             * vd :
             * dir : 扎克·施奈德
             * star : 本·阿弗莱克,亨利·卡维尔,盖尔·加朵
             * cat : 动作,冒险,科幻
             * wish : 176293
             * 3d : true
             * nm : 正义联盟
             * sc : 8.8
             * ver : 3D/IMAX 3D/中国巨幕/全景声
             * rt : 本周五上映
             * dur : 120
             * snum : 8841
             * imax : true
             * img : http://p1.meituan.net/165.220/movie/b9395cd202a461303cf06cea89292071556090.png
             * src :
             * showDate :
             * time :
             * id : 341195
             */

            private String showInfo;
            private boolean late;
            private int cnms;
            private int sn;
            private String scm;
            private int preSale;
            private int pn;
            private String vd;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            @SerializedName("3d")
            private boolean _$3d;
            private String nm;
            private double sc;
            private String ver;
            private String rt;
            private int dur;
            private int snum;
            private boolean imax;
            private String img;
            private String src;
            private String showDate;
            private String time;
            private int id;

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean is_$3d() {
                return _$3d;
            }

            public void set_$3d(boolean _$3d) {
                this._$3d = _$3d;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
