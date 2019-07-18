package com.mancj.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.pojo.Aplikasi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WishlistAdapter extends BaseAdapter {

    private List<Aplikasi> aplikasiList;
    private Context context;

    public WishlistAdapter(List<Aplikasi> aplikasiList, Context context) {
        this.aplikasiList = aplikasiList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return aplikasiList.size();
    }

    @Override
    public Object getItem(int position) {
        return aplikasiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.wishlist_model_listview, parent, false);
        }
        TextView appNameTextView = convertView.findViewById(R.id.appNameTextView);
        TextView appSizeTextView = convertView.findViewById(R.id.appSizeTextView);
        ImageView appImageView = convertView.findViewById(R.id.appImageView);
        final Aplikasi aplikasi = aplikasiList.get(position);
        appNameTextView.setText(aplikasi.getApp_name());
        appSizeTextView.setText(aplikasi.getApp_price());
        if (aplikasi.getApp_poster() != null && aplikasi.getApp_poster().length() > 0) {
            Picasso.get().load(aplikasi.getApp_poster()).placeholder(R.drawable.basket).into(appImageView);
        } else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_SHORT).show();
            Picasso.get().load(R.drawable.basket).into(appImageView);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, aplikasi.getApp_name(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
