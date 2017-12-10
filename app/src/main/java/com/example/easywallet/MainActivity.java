package com.example.easywallet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.easywallet.adapter.MoneyAdapter;
import com.example.easywallet.db.MoneyDB;
import com.example.easywallet.model.MoneyItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button Income, Expense;
    private MoneyDB mHelper;
    private SQLiteDatabase mDb;
    private ArrayList<MoneyItem> moneyItemArrayList = new ArrayList<>();
    private MoneyAdapter moneyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new MoneyDB(this);
        mDb = mHelper.getReadableDatabase();

        loadDataFromDb();
        Intent intent = getIntent();
        moneyAdapter = new MoneyAdapter(
                this,
                R.layout.item,
                moneyItemArrayList
        );



        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(moneyAdapter);

        Income = (Button) findViewById(R.id.income);
        Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,IncomeActivity.class);
            startActivity(intent);
            }
        });
        Expense = (Button) findViewById(R.id.expense);
        Expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExpenseActivity.class);
                startActivity(intent);
            }
        });


    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                MoneyDB.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        moneyItemArrayList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(MoneyDB.COL_ID));
            String picture = cursor.getString(cursor.getColumnIndex(MoneyDB.COL_PICTURE));
            String detail = cursor.getString(cursor.getColumnIndex(MoneyDB.COL_DETAIL));
            String money = cursor.getString(cursor.getColumnIndex(MoneyDB.COL_MONEY));

            MoneyItem item = new MoneyItem(id, picture, detail, money);
            moneyItemArrayList.add(item);
        }
    }

}