package com.example.easywallet.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easywallet.model.MoneyItem;
import com.example.easywallet.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
/**
 * Created by Dell on 10/12/2560.
 */

public class MoneyAdapter extends ArrayAdapter<MoneyItem> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<MoneyItem> moneyItemArrayList;

    public MoneyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MoneyItem> object) {
        super(context, resource, object);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.moneyItemArrayList= object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        MoneyItem item = moneyItemArrayList.get(position);

        final ImageView MoneyImageView = itemLayout.findViewById(R.id.money_imageView);
        final TextView DetailTextView = itemLayout.findViewById(R.id.detail_textview);
        final TextView MoneyTextView = itemLayout.findViewById(R.id.money_textview);

        DetailTextView.setText(item.detail);
        MoneyTextView.setText(item.money);

        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            MoneyImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemLayout;
    }
}
