package com.example.simplelanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CountriesActivity extends AppCompatActivity {

    Integer[] Countries = {
            R.drawable.spain,
            R.drawable.mexico,
            R.drawable.argentina,
            R.drawable.colombia,
            R.drawable.peru,
            R.drawable.venezuela
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        GridView grid = findViewById(R.id.gvCountries);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] countryLinks = {
                        "https://en.wikipedia.org/wiki/Spain",
                        "https://en.wikipedia.org/wiki/Mexico",
                        "https://en.wikipedia.org/wiki/Argentina",
                        "https://en.wikipedia.org/wiki/Colombia",
                        "https://en.wikipedia.org/wiki/Peru",
                        "https://en.wikipedia.org/wiki/Venezuela"
                };
                String selectedLink = countryLinks[position];

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedLink));
                startActivity(browserIntent);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return Countries.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View counterView, ViewGroup parent) {
            ImageView pic = new ImageView(context);
            pic.setImageResource(Countries[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new ViewGroup.LayoutParams(330, 300));
            return pic;
        }
    }
}