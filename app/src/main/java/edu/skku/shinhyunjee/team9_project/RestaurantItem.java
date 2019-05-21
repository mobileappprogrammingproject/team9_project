package edu.skku.shinhyunjee.team9_project;

import android.media.Image;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class RestaurantItem {
    private ImageView image;
    private ImageView star_image;
    private String name;
    private double star;
    private String content;
    private double dis;

    public RestaurantItem () { }

    public RestaurantItem(String name,  double star, String content, double dis) {
        this.name = name;
        this.star = star;
        this.content = content;
        this.dis=dis;
    }

    public ImageView getImage(){return image;}

    public String getName() {
        return name;
    }

    public ImageView getStar_image(){
        return star_image;
    }

    public double getStar() {
        return star;
    }

    public String getContent() {
        return content;
    }

    public double getDis(){return dis;}
}
