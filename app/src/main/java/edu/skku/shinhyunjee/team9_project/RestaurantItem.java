package edu.skku.shinhyunjee.team9_project;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RestaurantItem {
    /*private ImageView image;
    private ImageView star_image;
    private String name;
    private double star;
    private String content;
    private double dis; // distance

    private double lat, lon;
    private String call;
    private HashMap<String,Integer> menu = new HashMap<String,Integer>();
    private ArrayList<String> review = new ArrayList<>();

    public RestaurantItem () { } // default constructor

    public RestaurantItem(String name,  double star, String content, double dis, double lat, double lon, String call, HashMap<String,Integer> menu, ArrayList<String> review) {
        this.name = name;
        this.star = star;
        this.content = content;
        this.dis=dis;
        this.lat=lat; this.lon=lon;
        this.call=call;
        this.menu.putAll(menu);
        this.review.addAll(review);
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

    public double getLat(){return lat;}

    public double getLon(){return lon;}

    public String getCall(){return call;}

    public HashMap<String, Integer> getMenu(){return menu;}

    public ArrayList<String> getReview(){return review;}

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
    */
    private ImageView image;
    private ImageView star_image;
    private String name;
    private String info;
    private String location;
    private String business_hours;
    private String number; // phone number
    private String kind;
    private double star;
    private int dis;
    private HashMap<String,Integer> menu = new HashMap<String,Integer>();
//    private Kind[] kind_list;
//    private Menu[] menu_list;
//    public Evaluation[] evaluation;

    public RestaurantItem () {
        name = info = location = business_hours = number = "";
    } // default constructor

    public RestaurantItem(String name,  String info, String location, String business_hours, String number, String kind, double star) {
        this.name = name;
        this.info = info;
        this.location = location;
        this.business_hours = business_hours;
        this.number = number;
        this.kind = kind;
        this.star = star;
        this.menu.putAll(menu);
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
    public int getDis(){return dis;}

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        /*result.put("lat",lat);
        result.put("lon",lon);
        result.put("call",call);
        result.put("star",star);
        result.put("menu", menu);
        result.put("review",review);*/
        return result;
    }
    public class Evaluation{
        public int cnt;
        public double sum;
        public double star;
        public Review[] review;
        public double getStar(){
            return star;
        }
        public Evaluation(){
        }
        public Evaluation(int cnt, double sum, double star, Review[] review){
            this.cnt = cnt;
            this.sum = sum;
            this.star = star;
            this.review = review;
        }
    }
    public class Review{
        public String content;
        public String name;
        public double star;
        public Review(){
        }
        public Review(String name, double star, String content){
            this.name = name;
            this.star = star;
            this.content = content;
        }
    }
}
