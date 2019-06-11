package edu.skku.shinhyunjee.team9_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.*;

public class ReviewAdapter extends BaseAdapter{
    LayoutInflater inflater;
    public ArrayList<ReviewPost> items;

    public ReviewAdapter (Context context, ArrayList<ReviewPost> reviews) {
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = reviews;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ReviewPost getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if ( view == null ) {
            view = inflater.inflate(R.layout.reviewlist, viewGroup, false);
        }

        ReviewPost item = items.get(i);
        
        TextView name_tv = (TextView)view.findViewById(R.id.name_tv);
        TextView star_tv = (TextView)view.findViewById(R.id.star_tv);
        TextView content_tv = (TextView)view.findViewById(R.id.content_tv);

        String text = item.name; int len = item.name.length();//Log.d("reviewUserName","text: "+text+", len: "+len);
        if(len >= 1) {
            text = text.substring(0,len)+"*";
            name_tv.setText(text);
        }
        else name_tv.setText(item.name);
        star_tv.setText(item.star+"");
        content_tv.setText(item.content);

        Log.d("getReviewAdapter","name: "+item.name+" star: "+item.star+" content: "+item.content);

        return view;
    }
}
