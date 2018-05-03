package com.example.dell.tt_readartist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.tt_readartist.Entites.Feed;
import com.example.dell.tt_readartist.Entites.FeedItem;
import com.example.dell.tt_readartist.Retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParserException;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    ArrayList<FeedItem> items;
    ItemAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.lvList);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        String name=intent.getStringExtra("name");
        setTitle(name);

        try {
            Call<Feed> caller= RetrofitClient.api().getNewsByCategory(url);
            caller.enqueue(new Callback<Feed>() {
                @Override
                public void onResponse(Call<Feed> call, Response<Feed> response) {
                    items= (ArrayList<FeedItem>) response.body().getmChannel().getFeedItems();
                    adapter=new ItemAdapter(items,getLayoutInflater(),Main2Activity.this);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent=new Intent(Main2Activity.this,DisplayDetailActivity.class);
                            intent.putExtra("url",items.get(i).getMlink()+"");
                            startActivity(intent);
                        }
                    });

                }

                @Override
                public void onFailure(Call<Feed> call, Throwable t) {

                }
            });

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
