package com.example.hello.bean;

import java.util.List;

/**
 * Created by John on 2017/11/16.
 */

public class WallBean {

    /**
     * status : 1
     * message : wallpaper
     * data : {"hand":[{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/1.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/2.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/3.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/4.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/5.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/6.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/7.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/8.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/wallpaper/hand/9.jpg","summary":"","message":"","info":""}]}
     */

    private String status;
    private String message;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        private List<HandBean> hand;

        public List<HandBean> getHand() {
            return hand;
        }

        public void setHand(List<HandBean> hand) {
            this.hand = hand;
        }

        public static class HandBean {
            /**
             * id :
             * name :
             * imageurl : /hello/file/images/wallpaper/hand/1.jpg
             * summary :
             * message :
             * info :
             */

            private String id;
            private String name;
            private String imageurl;
            private String summary;
            private String message;
            private String info;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }
        }
    }
}
