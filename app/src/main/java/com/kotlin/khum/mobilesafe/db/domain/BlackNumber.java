package com.kotlin.khum.mobilesafe.db.domain;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   :
 * </pre>
 */
public class BlackNumber {

    private String phone;
    private int intercept;

    public BlackNumber(String phone, int intercept) {
        this.phone = phone;
        this.intercept = intercept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIntercept() {
        return intercept;
    }

    public void setIntercept(int intercept) {
        this.intercept = intercept;
    }
}
