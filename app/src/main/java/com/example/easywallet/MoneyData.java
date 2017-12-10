package com.example.easywallet;

import com.example.easywallet.model.MoneyItem;

import java.util.ArrayList;

/**
 * Created by Dell on 10/12/2560.
 */

public class MoneyData {
    private static MoneyData sInstance;

    public ArrayList<MoneyItem> moneyItemArrayList;
    public static MoneyData getsInstance(){
        if(sInstance == null){
            sInstance = new MoneyData();
        }

        return  sInstance;
    }
}
