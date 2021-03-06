package edu.skku.shinhyunjee.team9_project;


import android.content.Context;
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
        TextView rk = (TextView) view.findViewById(R.id.rank);
        TextView tv1 = (TextView)view.findViewById(R.id.name_tv);
        TextView tv2 = (TextView)view.findViewById(R.id.star_tv);
        TextView tv3 = (TextView)view.findViewById(R.id.content_tv);
        TextView tv4=(TextView)view.findViewById(R.id.dis);

        rk.setText((i+1)+"");
        tv1.setText(item.getName());
        tv2.setText(""+item.getStar());
        tv3.setText(item.getInfo());
        tv4.setText("리뷰: "+item.getReview_num()+"개");
        return view;
    }
}

