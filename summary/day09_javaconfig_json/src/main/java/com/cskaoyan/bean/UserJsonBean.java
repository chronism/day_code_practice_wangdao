package com.cskaoyan.bean;

public class UserJsonBean {
    /**
     * username : heidashuai
     * password : zhenshuai
     * age : 30
     * userDetail : {"email":"heidashuai@cskaoyan.com","gender":"male"}
     */

    private String username;
    private String password;
    private int age;
    private UserDetailBean userDetail;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDetailBean getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailBean userDetail) {
        this.userDetail = userDetail;
    }

    public static class UserDetailBean {
        /**
         * email : heidashuai@cskaoyan.com
         * gender : male
         */

        private String email;
        private String gender;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
