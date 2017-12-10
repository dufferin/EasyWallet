package com.example.easywallet.model;

/**
 * Created by Dell on 10/12/2560.
 */

public class MoneyItem {
    public final int id;
    public final String picture;
    public final String detail;
    public final String money;

    public MoneyItem(int id,String detail,String money,String picture){
        this.id=id;
        this.picture=picture;
        this.detail=detail;
        this.money=money;

    }

}
