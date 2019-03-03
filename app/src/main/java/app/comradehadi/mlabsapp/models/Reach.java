package app.comradehadi.mlabsapp.models;

import com.google.gson.JsonArray;

public class Reach {

    String id;
    String title;
    String sub_title;
    JsonArray data;

    public Reach(String id, String title, String sub_title, JsonArray data) {
        this.id = id;
        this.title = title;
        this.sub_title = sub_title;
        this.data = data;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public JsonArray getData() {
        return data;
    }

    public void setData(JsonArray data) {
        this.data = data;
    }
}
