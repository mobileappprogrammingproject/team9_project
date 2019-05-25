package edu.skku.shinhyunjee.team9_project;

import java.util.HashMap;
import java.util.Map;

public class RestaurantPost {
    public String name;
    public double lat, lon; // 위치
    public String call;
    public HashMap<String,Double> menu = new HashMap<String,Double>();
    public float score;
    public String[] review;

    public RestaurantPost(){}
    // default constructor

    public RestaurantPost(String name, double lat, double lon, String call, HashMap<String,Double> menu, float score, String[] review){
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.call = call;
        this.menu.putAll(menu);
        this.score = score;
        this.review = (String[])review.clone();
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        result.put("lat",lat);
        result.put("lon",lon);
        result.put("call",call);
        result.put("score",score);
        return result;
    }
}
