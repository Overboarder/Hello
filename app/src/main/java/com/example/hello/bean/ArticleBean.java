package com.example.hello.bean;

/**
 * Created by John on 2017/11/16.
 */

public class ArticleBean {

    /**
     * data : {"date":{"curr":"20171116","prev":"20171115","next":"20171117"},"author":"梁文道","title":"奢华与教养","digest":"今天的中国，无论你走到哪里，几乎都能看见\u201c奢华\u201d这两个字。每一本时尚生活杂志都在不厌其烦地告诉你有关奢华的故事，每一个商品广告都试图让你感到","content":"<p>今天的中国，无论你走到哪里，几乎都能看见\u201c奢华\u201d这两个字。每一本时尚生活杂志都在不厌其烦地告诉你有关奢华的故事，每一个商品广告都试图让你感到它要卖的商品有多奢华。于是房子是奢华的，车子是奢华的，大衣是奢华的，手表是奢华的，皮鞋也是奢华的，就连内裤也可以很奢华，乃至于我刚刚吃过的涮羊肉也标榜自己的用料十分奢华。<\/p><p>本来这种东西是可以见怪不怪的，正所谓奢华见惯亦平常。可是有一天，我在杂志上看到一篇介绍英国手工定制鞋的文章，作者先是不断渲染英国绅士的低调含蓄，一两千字之后笔锋忽然一转，他还是未能免俗地要大谈这鞋子有多奢华，并将其定位为\u201c低调的奢华\u201d。然后把绅士等同于品位，再将品位等同于奢华。<\/p><p>许多媒体早就在\u201c奢华\u201d和\u201c品位\u201d之间画上等号了，但现在有人进一步连\u201c绅士\u201d也挂了上去，这就让我觉得有些刺眼了。<\/p><p>我的生活奢华不起，我的言行也离绅士甚远，可我总算读过不少传说中的英国绅士写的东西，在我的印象中，绅士和奢华根本是两个完全不同的概念。且看19世纪英国绅士之间的通信，关于绅士的品位，他们是这么说的：\u201c×××的家朴实无华，真是难得的好品位。\u201d\u201c他是那种老派的绅士，一件大衣穿了20年。\u201d他们会称赞一个人的朴实和惜物，低调而不张扬，却绝对不会把看得见的奢华当作品位，尤其不会把它视为绅士的品位。<\/p><p>就以一双手工制作的顶级皮鞋来说吧，它是很贵，但它可以穿上一二十年，这里头的学问不只是它自身的质量，更是你穿它、用它的态度。首先，你会珍惜它，所以走路的姿势是端正的，不会在街上看见什么都随便踢一脚。其次，你愿意花点时间和心思去护理它，平常回家脱下来不忘为它拂尘拭灰，周末则悠悠闲闲地替它抹油补色，权当一种调剂身心的休息活动（就算他有佣人，他也宁愿自己动手）。所以这双鞋能够穿得久，10年之后，它略显老态，但不腐旧，看得出是经过了不错的照料，也看得出其主人对它的爱惜。这叫作绅士。不一定喜欢昂贵的身外物，但一定不随便花钱，朝秦暮楚。他的品位不在于他买了什么，而在于他的生活风格甚至为人；他拥有的物质不能说明他，他拥有物质的方式才能道出他是个怎么样的人。<\/p><p>当然，一个人不能做物质的奴隶，但他的人格、性情或许可以借着物质偶尔散发出来。简单地讲，这就是教养。\u201c教养\u201d是一个何其古老、于今天何其陌生的词啊。这个词本来才是品位的绝配，不过，由于教养困难，奢华容易，我们今天才会把品位许给了奢华，让空洞的、无止境的消费去遮掩教养的匮乏。久而久之，甚至开始有人以为，英国的传统绅士皆以奢华为人生第一目标。<\/p><p>如果你觉得\u201c教养\u201d太过抽象，我可以为你举一些没有教养的好例子。开着一部奔驰车在街上横冲直撞，觉得行人全是活该被吓死的贱民，这是没有教养的。手上戴着伯爵表，然后借醉酒臭骂上错菜的服务员小妹妹，这也是没有教养的。教养不必来自家教，更不是贵族的专利，上进的绅士更看重后天的自我养成。然而，如今有力奢华地招摇过市之辈多如过江之鲫，甘于谦逊、力求品格善美的人却几不可闻，岂不可叹？<\/p><p>我只不过是在北京一家火锅店见着它用\u201c奢华\u201d二字形容自己的材料，便忍不住发出这一大堆牢骚，这自然也是没有教养的表现。<\/p>","wc":1277}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * date : {"curr":"20171116","prev":"20171115","next":"20171117"}
         * author : 梁文道
         * title : 奢华与教养
         * digest : 今天的中国，无论你走到哪里，几乎都能看见“奢华”这两个字。每一本时尚生活杂志都在不厌其烦地告诉你有关奢华的故事，每一个商品广告都试图让你感到
         * content : <p>今天的中国，无论你走到哪里，几乎都能看见“奢华”这两个字。每一本时尚生活杂志都在不厌其烦地告诉你有关奢华的故事，每一个商品广告都试图让你感到它要卖的商品有多奢华。于是房子是奢华的，车子是奢华的，大衣是奢华的，手表是奢华的，皮鞋也是奢华的，就连内裤也可以很奢华，乃至于我刚刚吃过的涮羊肉也标榜自己的用料十分奢华。</p><p>本来这种东西是可以见怪不怪的，正所谓奢华见惯亦平常。可是有一天，我在杂志上看到一篇介绍英国手工定制鞋的文章，作者先是不断渲染英国绅士的低调含蓄，一两千字之后笔锋忽然一转，他还是未能免俗地要大谈这鞋子有多奢华，并将其定位为“低调的奢华”。然后把绅士等同于品位，再将品位等同于奢华。</p><p>许多媒体早就在“奢华”和“品位”之间画上等号了，但现在有人进一步连“绅士”也挂了上去，这就让我觉得有些刺眼了。</p><p>我的生活奢华不起，我的言行也离绅士甚远，可我总算读过不少传说中的英国绅士写的东西，在我的印象中，绅士和奢华根本是两个完全不同的概念。且看19世纪英国绅士之间的通信，关于绅士的品位，他们是这么说的：“×××的家朴实无华，真是难得的好品位。”“他是那种老派的绅士，一件大衣穿了20年。”他们会称赞一个人的朴实和惜物，低调而不张扬，却绝对不会把看得见的奢华当作品位，尤其不会把它视为绅士的品位。</p><p>就以一双手工制作的顶级皮鞋来说吧，它是很贵，但它可以穿上一二十年，这里头的学问不只是它自身的质量，更是你穿它、用它的态度。首先，你会珍惜它，所以走路的姿势是端正的，不会在街上看见什么都随便踢一脚。其次，你愿意花点时间和心思去护理它，平常回家脱下来不忘为它拂尘拭灰，周末则悠悠闲闲地替它抹油补色，权当一种调剂身心的休息活动（就算他有佣人，他也宁愿自己动手）。所以这双鞋能够穿得久，10年之后，它略显老态，但不腐旧，看得出是经过了不错的照料，也看得出其主人对它的爱惜。这叫作绅士。不一定喜欢昂贵的身外物，但一定不随便花钱，朝秦暮楚。他的品位不在于他买了什么，而在于他的生活风格甚至为人；他拥有的物质不能说明他，他拥有物质的方式才能道出他是个怎么样的人。</p><p>当然，一个人不能做物质的奴隶，但他的人格、性情或许可以借着物质偶尔散发出来。简单地讲，这就是教养。“教养”是一个何其古老、于今天何其陌生的词啊。这个词本来才是品位的绝配，不过，由于教养困难，奢华容易，我们今天才会把品位许给了奢华，让空洞的、无止境的消费去遮掩教养的匮乏。久而久之，甚至开始有人以为，英国的传统绅士皆以奢华为人生第一目标。</p><p>如果你觉得“教养”太过抽象，我可以为你举一些没有教养的好例子。开着一部奔驰车在街上横冲直撞，觉得行人全是活该被吓死的贱民，这是没有教养的。手上戴着伯爵表，然后借醉酒臭骂上错菜的服务员小妹妹，这也是没有教养的。教养不必来自家教，更不是贵族的专利，上进的绅士更看重后天的自我养成。然而，如今有力奢华地招摇过市之辈多如过江之鲫，甘于谦逊、力求品格善美的人却几不可闻，岂不可叹？</p><p>我只不过是在北京一家火锅店见着它用“奢华”二字形容自己的材料，便忍不住发出这一大堆牢骚，这自然也是没有教养的表现。</p>
         * wc : 1277
         */

        private DateBean date;
        private String author;
        private String title;
        private String digest;
        private String content;
        private int wc;

        public DateBean getDate() {
            return date;
        }

        public void setDate(DateBean date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getWc() {
            return wc;
        }

        public void setWc(int wc) {
            this.wc = wc;
        }

        public static class DateBean {
            /**
             * curr : 20171116
             * prev : 20171115
             * next : 20171117
             */

            private String curr;
            private String prev;
            private String next;

            public String getCurr() {
                return curr;
            }

            public void setCurr(String curr) {
                this.curr = curr;
            }

            public String getPrev() {
                return prev;
            }

            public void setPrev(String prev) {
                this.prev = prev;
            }

            public String getNext() {
                return next;
            }

            public void setNext(String next) {
                this.next = next;
            }
        }
    }
}
