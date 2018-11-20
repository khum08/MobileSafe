package com.kotlin.khum.mobilesafe.ui.mvvm;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/8
 *     desc   :
 * </pre>
 */
public class User {

    private String username;
    private String nickname;
    private int age;
    private String hobby;

    public User(String username, String nickname, int age) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
