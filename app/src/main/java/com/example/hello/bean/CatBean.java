package com.example.hello.bean;

import java.util.List;

/**
 * Created by john on 2017/11/16.
 */

public class CatBean {


    /**
     * status : 1
     * message : cat
     * data : {"ragdoll":[{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/1.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/2.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/3.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/4.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/5.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/6.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/7.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/8.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/9.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/10.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/11.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/12.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/13.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/14.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/15.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/16.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/17.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/18.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/19.jpg","summary":"","message":"","info":""},{"id":"","name":"","imageurl":"/hello/file/images/cat/ragdoll/20.jpg","summary":"","message":"","info":""}]}
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
        private List<RagdollBean> ragdoll;

        public List<RagdollBean> getRagdoll() {
            return ragdoll;
        }

        public void setRagdoll(List<RagdollBean> ragdoll) {
            this.ragdoll = ragdoll;
        }

        public static class RagdollBean {
            /**
             * id :
             * name :
             * imageurl : /hello/file/images/cat/ragdoll/1.jpg
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
