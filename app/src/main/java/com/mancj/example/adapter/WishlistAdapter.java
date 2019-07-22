package com.mancj.example.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.pojo.Wishlist;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class WishlistAdapter extends BaseAdapter {

    private List<Wishlist> wishlist;
    private Context context;

    public WishlistAdapter(List<Wishlist> wishlist, Context context) {
        this.wishlist = wishlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return wishlist.size();
    }

    @Override
    public Object getItem(int position) {
        return wishlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.wishlist_model_listview, parent, false);
        }
        TextView appNameTextView = convertView.findViewById(R.id.appNameTextView);
        TextView appSizeTextView = convertView.findViewById(R.id.appSizeTextView);
        ImageView appImageView = convertView.findViewById(R.id.appImageView);
        final Wishlist wishlistData = wishlist.get(position);

        // For the price of the app
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        // For the view
        appNameTextView.setText(wishlistData.getApp_name());
        appSizeTextView.setText("Price : " + kursIndonesia.format(wishlistData.getApp_price()));
        if (wishlistData.getApp_poster() != null && wishlistData.getApp_poster().length() > 0) {
            Picasso.get().load(wishlistData.getApp_poster()).placeholder(R.drawable.basket).into(appImageView);
        } else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_SHORT).show();
            Picasso.get().load(R.drawable.basket).into(appImageView);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, wishlistData.getApp_name(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
