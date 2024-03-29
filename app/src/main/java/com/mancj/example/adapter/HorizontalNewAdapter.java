package com.mancj.example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mancj.example.R;

import java.util.List;

public class HorizontalNewAdapter extends RecyclerView.Adapter<HorizontalNewAdapter.ViewHolder> {

    private List<HorizontalScrollModel> horizontalScrollModelList;

    public HorizontalNewAdapter(List<HorizontalScrollModel> horizontalScrollModelList) {
        this.horizontalScrollModelList = horizontalScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalNewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalNewAdapter.ViewHolder viewHolder, int position) {
        int resource= horizontalScrollModelList.get(position).getProductImage();
        String title= horizontalScrollModelList.get(position).getProductTitle();
        String description= horizontalScrollModelList.get(position).getProductDescription();
        String price= horizontalScrollModelList.get(position).getProductPrice();

        viewHolder.setProductImage(resource);
        viewHolder.setProductTitle(title);
        viewHolder.setProductDescription(description);
        viewHolder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {

        return horizontalScrollModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.h_s_product_image);
            productTitle=itemView.findViewById(R.id.h_s_product_title);
            productDescription=itemView.findViewById(R.id.h_s_product_description);
            productPrice=itemView.findViewById(R.id.h_s_product_price);
        }

        private void setProductImage(int resource){

            productImage.setImageResource(resource);
        }

        private void setProductTitle(String title){

            productTitle.setText(title);
        }

        private void setProductDescription(String description){

            productDescription.setText(description);
        }

        private void setProductPrice(String price) {

            productPrice.setText(price);
        }
    }
}
