package com.example.easywallet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.easywallet.db.MoneyDB;
import com.example.easywallet.adapter.MoneyAdapter;
import com.example.easywallet.model.MoneyItem;

import com.example.easywallet.R;

import java.util.ArrayList;

/**
 * Created by Dell on 10/12/2560.
 */

public class IncomeActivity extends AppCompatActivity {
    private SQLiteDatabase mDb;
    private ArrayList<MoneyItem> moneyItemArrayList = new ArrayList<>();
    private MoneyAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_layout);

        Intent intent = getIntent();

        final Button insert = findViewById(R.id.button);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText detail = findViewById(R.id.editText);
                EditText money = findViewById(R.id.editText2);

                String de = detail.getText().toString();
                String mo = money.getText().toString();
                Intent intent = new Intent(IncomeActivity.this,MainActivity.class);
                ContentValues cv = new ContentValues();
                intent.putExtra(MoneyDB.COL_PICTURE, "ic_income.png");
                intent.putExtra(MoneyDB.COL_DETAIL, de);
                intent.putExtra(MoneyDB.COL_MONEY, mo);

                mDb.insert(MoneyDB.TABLE_NAME, null, cv);
                loadDataFromDb();
                mAdapter.notifyDataSetChanged();

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
        mAdapter = new MoneyAdapter(
                this,
                R.layout.item,
                moneyItemArrayList
        );
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
