package com.sid.vocabulary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created 2018/4/13.
 *
 * @author HongTao
 */
@Entity
public class SignDate {
    @NotNull
    private int year;
    @NotNull
    private int month;
    @NotNull
    private int day;
    @NotNull
    private boolean isSign;




    @Generated(hash = 1674040653)
    public SignDate(int year, int month, int day, boolean isSign) {
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

}
