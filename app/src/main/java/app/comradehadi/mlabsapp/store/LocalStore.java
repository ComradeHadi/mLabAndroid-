package app.comradehadi.mlabsapp.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LocalStore {
    Context context;

    public LocalStore(Context context) {
        this.context = context;
    }

    public void saveAnalysis(JsonObject results){

        SharedPreferences sharedPreferences = context.getSharedPreferences("Analysis", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("data", results.toString());
        editor.commit();

        Log.e("SAVED", results.toString());

    }

    public JsonObject readAnalysis(){
        JsonObject analysisObject ;
        SharedPreferences sharedPreferences = context.getSharedPreferences("Analysis", 0);
        analysisObject = (JsonObject) new JsonParser().parse(
                sharedPreferences.getString("data",null)
        );

        Log.e("SAVED II", analysisObject.toString());
        return analysisObject;
    }
}
