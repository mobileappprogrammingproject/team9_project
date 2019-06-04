package edu.skku.shinhyunjee.team9_project;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantAdapter extends BaseAdapter {
    LayoutInflater inflater;
    private ArrayList<RestaurantItem> items;

    public RestaurantAdapter (Context context, ArrayList<RestaurantItem> memos) {
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = memos;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public RestaurantItem getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if ( view == null ) {
            view = inflater.inflate(R.layout.restaurantlist, viewGroup, false);
        }

        RestaurantItem item = items.get(i);
        ImageView iv1=(ImageView)view.findViewById(R.id.image);
        TextView tv1 = (TextView)view.findViewById(R.id.restaurant_tv);
        TextView tv2 = (TextView)view.findViewById(R.id.star_tv);
        TextView tv3 = (TextView)view.findViewById(R.id.info_tv);
        TextView tv4=(TextView)view.findViewById(R.id.dis);

        tv1.setText(item.getName());
        tv2.setText(""+item.getStar());
        tv3.setText(item.getInfo());
        tv4.setText(item.getDis()+"km");
        return view;
    }
}

