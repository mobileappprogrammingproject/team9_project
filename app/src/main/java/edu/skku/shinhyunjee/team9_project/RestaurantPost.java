package edu.skku.shinhyunjee.team9_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RestaurantPost {
    /*public String name;
    public double lat, lon; // 위치
    public String call;
    public HashMap<String,Integer> menu = new HashMap<String,Integer>();
    public double star;
    public ArrayList<String> review = new ArrayList<>();
    //public HashMap<String, String> review = new HashMap<String, String>();

    public RestaurantPost(){}
    // default constructor

    public RestaurantPost(String name, double lat, double lon, String call, HashMap<String,Integer> menu, double star, ArrayList<String> review){
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.call = call;
        this.menu.putAll(menu);
        this.star = star;
        this.review.addAll(review);
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        result.put("lat",lat);
        result.put("lon",lon);
        result.put("call",call);
        result.put("star",star);
        result.put("menu", menu);
        result.put("review",review);
        return result;
    }*/
    public String name;
    public String info;
    public String location;
    public String business_hours;
    public String number; // phone number
    public String kind;
    public double star;
//    public HashMap<String,Integer> menu = new HashMap<String,Integer>();


    public RestaurantPost(){
    }
    // default constructor
    public RestaurantPost(String name,  String info, String location, String business_hours, String number, String kind, double star){
        this.name = name;
        this.info = info;
        this.location = location;
        this.business_hours = business_hours;
        this.number = number;
        this.kind = kind;
        this.star = star;
    //    this.menu.putAll(menu);

    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        result.put("info",info);
        result.put("location",location);
        result.put("business_hours",business_hours);
        result.put("number",number);
        result.put("kind",kind);
    //    result.put("menu",menu);
        return result;
    }
}