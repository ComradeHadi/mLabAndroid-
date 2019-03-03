package app.comradehadi.mlabsapp.models;

import com.google.gson.JsonArray;

public class Data {

    int id;
    String company_id;
    String value;
    String change;


    public Data(int id, String company_id, String value, String change, JsonArray data) {
        this.id = id;
        this.company_id = company_id;
        this.value = value;
        this.change = change;

    }


    public int getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getValue() {
        return value;
    }

    public String getChange() {
        return change;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setChange(String change) {
        this.change = change;
    }


}
