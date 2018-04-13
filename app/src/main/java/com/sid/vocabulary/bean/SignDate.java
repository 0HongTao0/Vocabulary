package com.sid.vocabulary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created 2018/4/13.
 *
 * @author HongTao
 */
@Entity
public class SignDate {
    @Id(autoincrement = true)
    private long _id;
    @NotNull
    private int year;
    @NotNull
    private int month;
    @NotNull
    private int day;
    @NotNull
    private boolean isSign;


    @Generated(hash = 601500230)
    public SignDate(long _id, int year, int month, int day, boolean isSign) {
        this._id = _id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.isSign = isSign;
    }

    @Generated(hash = 349017852)
    public SignDate() {
    }
    

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

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

    public boolean getIsSign() {
        return this.isSign;
    }

    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}
