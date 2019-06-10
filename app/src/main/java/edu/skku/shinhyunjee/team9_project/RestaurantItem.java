package edu.skku.shinhyunjee.team9_project;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RestaurantItem {
    private ImageView image;
    private ImageView star_image;
    private String name;
    private String info;
    private String location;
    private String business_hours;
    private String number; // phone number
    private String kind;
    private double star;
    private long review_num;
    private HashMap<String,Integer> menu = new HashMap<String,Integer>();
//    private Kind[] kind_list;
//    private Menu[] menu_list;

    public RestaurantItem () {
        name = info = location = business_hours = number = "";
    } // default constructor

    public RestaurantItem(String name,  String info, String location, String business_hours, String number, String kind, double star, long review_num) {
        this.name = name;
        this.info = info;
        this.location = location;
        this.business_hours = business_hours;
        this.number = number;
        this.kind = kind;
        this.star = star;
        this.menu.putAll(menu);
        this.review_num = review_num;
    }

    public ImageView getImage(){return image;}
    public String getName(){return name;}
    public String getInfo(){return info;}
    public String getLocation(){return location;}
    public String getBusiness_hours(){return business_hours;}
    public String getNumber(){return number;}
    public String getKind(){return kind;}
    public double getStar(){return star;}
    public HashMap<String, Integer> getMenu(){return menu;}
    public long getReview_num(){return review_num;}

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        return result;
    }
}
