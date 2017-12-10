package com.example.easywallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.easywallet.R;

/**
 * Created by Dell on 10/12/2560.
 */

public class ExpenseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_layout);

        Intent intent = getIntent();
    }
}
