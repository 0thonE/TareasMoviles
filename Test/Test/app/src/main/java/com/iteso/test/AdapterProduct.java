package com.iteso.test;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.test.beans.ItemProduct;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;


public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{
    private Context context;
    private ArrayList<ItemProduct> itemProductSet;


    public AdapterProduct(Context context, ArrayList<ItemProduct> itemProductSet) {
        this.context = context;
        this.itemProductSet = itemProductSet;

    }

    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, final int position) {
        holder.productTitle.setText(itemProductSet.get(position).getTitle());
        holder.productStore.setText(itemProductSet.get(position).getStore());
        holder.productLocation.setText(itemProductSet.get(position).getLocation());
        holder.productPhone.setText(itemProductSet.get(position).getPhone());

        holder.productPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + itemProductSet.get(position).getPhone()));
                context.startActivity(intent);
            }
        });

        holder.productDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, itemProductSet.get(position).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

//        holder.productShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT,  itemProductSet.get(position).getDescription());
//                sendIntent.setType("text/plain");
//                // Verify that the intent will resolve to an activity
////                if (sendIntent.resolveActivity(getPackageManager()) != null) {
////                    startActivity(sendIntent);
////                }
//            }
//        });

        switch (itemProductSet.get(position).getImage()){
            case 0:
                holder.productImage.setImageResource(R.drawable.mac);
                break;
            case 1:
                holder.productImage.setImageResource(R.drawable.alienware);
                break;
            case 2:
                holder.productImage.setImageResource(R.drawable.asador);
                break;
            case 3:
                holder.productImage.setImageResource(R.drawable.sillon);
                break;
            case 4:
                holder.productImage.setImageResource(R.drawable.microondas);
                break;
            case 5:
                holder.productImage.setImageResource(R.drawable.lavadora);
                break;
        }

        Bitmap bitmap = ((BitmapDrawable) holder.productThumbnail.getDrawable()).getBitmap();
//        bitmap = getRoundedBitmap(bitmap, 25);
        holder.productThumbnail.setImageBitmap( bitmap);


    }


    @Override
    public int getItemCount() {
        return itemProductSet.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button productDetail, productShare;
        public TextView productTitle, productStore,
                        productLocation, productPhone;
        public ImageView productImage, productThumbnail;
        public RelativeLayout eventLayout;

        public ViewHolder(View v) {
            super(v);
            eventLayout = v.findViewById(R.id.item_product_layout);
            productDetail =  v.findViewById(R.id.item_product_detail);
            productTitle =  v.findViewById(R.id.item_product_title);
            productStore =  v.findViewById(R.id.item_product_store);
            productLocation =  v.findViewById(R.id.item_product_location);
            productPhone = v.findViewById(R.id.item_product_phone);
            productImage =  v.findViewById(R.id.item_product_image);
            productThumbnail =  v.findViewById(R.id.item_product_thumbnail);
        }

    }

}
