package com.example.orangestatus.ui.others;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.orangestatus.R;

public class photo extends AppCompatActivity {

    public int[] imageId = new int[]{R.drawable.photo1, R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview;
                if(convertView ==null){
                    imageview =new ImageView(photo.this);
                    imageview.setAdjustViewBounds(true);
                    imageview.setMaxHeight(158);
                    imageview.setPadding(5,5,5,5);
                }
                else{
                    imageview = (ImageView)convertView;
                }
                imageview.setImageResource(imageId[position]);
                return imageview;
            }
        };
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId",imageId[position]);
                intent.putExtras(bundle);
                setResult(0x11,intent);
                finish();

            }
        });
    }
}
