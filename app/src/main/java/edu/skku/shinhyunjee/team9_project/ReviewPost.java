package edu.skku.shinhyunjee.team9_project;

import java.util.HashMap;
import java.util.Map;

public class ReviewPost {
    public String content;
    public String name;
    public double star;

    ReviewPost(){}

    ReviewPost(String c, String n, double s){
        content=c; name = n; star = s;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("content",content);
        result.put("name",name);
        result.put("star",star);
        return result;
    }
}
