package edu.skku.shinhyunjee.team9_project;

import java.util.HashMap;
import java.util.Map;

public class RestaurantPost {
    public String name;
    public double lat, lon; // 위치
    public String call;
    public HashMap<String,Double> menu = new HashMap<String,Double>();
    public double star;
    public HashMap<Integer, String> review = new HashMap<Integer, String>();

    public RestaurantPost(){}
    // default constructor

    public RestaurantPost(String name, double lat, double lon, String call, HashMap<String,Double> menu, double star, HashMap<Integer, String> review){
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.call = call;
        this.menu.putAll(menu);
        this.star = star;
        this.review.putAll(review);
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
    }
}
