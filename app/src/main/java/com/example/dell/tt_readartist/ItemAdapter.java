package com.example.dell.tt_readartist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.tt_readartist.Entites.FeedItem;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Dell on 4/23/2018.
 */

public class ItemAdapter extends BaseAdapter {
    ArrayList<FeedItem> items=new ArrayList<>();
    LayoutInflater inflater;
    Context context;

    public ItemAdapter(ArrayList<FeedItem> items, LayoutInflater inflater, Context context) {
        this.items = items;
        this.inflater = inflater;
        this.context= context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public FeedItem getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=inflater.inflate(R.layout.item_layout,null);
        }

        FeedItem item=getItem(i);

//        TextView mlink=view.findViewById(R.id.mlink);
        TextView mtitle=view.findViewById(R.id.mtitle);
//        TextView mpubDate=view.findViewById(R.id.mpubDate);
        ImageView imageView=view.findViewById(R.id.image);
        String description= item.getMdescription();
        TextView mdes=view.findViewById(R.id.mdes);
        mdes.setText(description.substring(description.indexOf("</br>")+5));

        if (description.startsWith("<a ")) {
            try {
                String cleanUrl = description.substring(description.indexOf("src=") + 5, description.indexOf("></a") - 2).trim();
                Glide.with(context).load(cleanUrl).into(imageView);

//                Glide.with(context).load(cleanUrl).apply(new RequestOptions().placeholder(R.drawable.ao1)).into(imageView);
            } catch (Exception e){

            }

        } else {

        }

//        mlink.setText(item.getMlink());
        mtitle.setText(item.getMtitle());
//        mpubDate.setText(item.getMpubDate());


        return view;
    }

}
