package com.example.dell.tt_readartist;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    ImageView imageView;
    ArrayList<String> links=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        links.add("thoi-su");
        links.add("the-gioi");
        links.add("kinh-doanh");

        links.add("startup");
        links.add("giai-tri");
        links.add("the-thao");
        links.add("phap-luat");
        links.add("giao-duc");
        links.add("suc-khoe");
        links.add("gia-dinh");
        links.add("du-lich");
        links.add("khoa-hoc");
        links.add("so-hoa");
        links.add("oto-xe-may");
        links.add("cong-dong");
        links.add("cong-dong");
        links.add("tam-su");
        links.add("cuoi");

    }

    private void addControl(){
        lv=findViewById(R.id.lv);
        String [] list=new String[]{"Trang chủ","Thời sự","Thế giới","Kinh doanh","Start up","Giải trí",
        "Thể thao","Pháp luật","Giáo dục","Sức khỏe","Gia đình","Du lịch","Khoa học",
        "Số hóa","Xe","Cộng đồng","Tâm sự","Cười"};
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("url",links.get(i));
                startActivity(intent);

            }
        });



    }
}
