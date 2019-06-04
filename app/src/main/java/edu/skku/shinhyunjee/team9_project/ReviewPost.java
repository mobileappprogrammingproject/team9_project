package edu.skku.shinhyunjee.team9_project;

public class ReviewPost {
    public String content;
    public String name;
    public double star;

    ReviewPost(){}

    ReviewPost(String c, String n, double s){
        content=c; name = n; star = s;
    }
}
