package edu.skku.shinhyunjee.team9_project;

import java.util.HashMap;
import java.util.Map;

public class Firebase {
    public String name;
    public String pw;
    public String birth;

    public Firebase(){
    }
    public Firebase(String birth, String name, String pw){
        this.name=name;
        this.pw=pw;
        this.birth=birth;
    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("pw", pw);
        result.put("birth", birth);
        return result;
    }

    public String getPw() {
        return pw;
    }
}
