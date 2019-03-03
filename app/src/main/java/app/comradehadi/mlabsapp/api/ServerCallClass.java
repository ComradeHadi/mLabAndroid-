package app.comradehadi.mlabsapp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import com.mmstq.progressbargifdialog.ProgressBarGIFDialog;

public class ServerCallClass {
    Context context;
    ProgressBarGIFDialog.Builder progressBarGIFDialog;

    public ServerCallClass(Context context) {
        this.context = context;
    }


    public JsonObject getBrandData(){

        progressBarGIFDialog= new ProgressBarGIFDialog.Builder((Activity)this.context);
        JsonObject serverResults = null;

        Ion.with(this.context)
                .load(URLs.GET_BRAND_DATA)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        if(result != null){

                            Log.e("success", result.toString());
//                            progressBarGIFDialog.clear();

//                            if (result.get("status").getAsString().equalsIgnoreCase("Success")){
//
//                                new LocalStore(context).saveTaxBracketObjectAsString(result.get("data").getAsJsonObject(
//
//                                ).get("district").getAsJsonObject().toString());
//                            }


                           }


                        else {

                            Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG).show();

                        }
                    }
                });
        return serverResults;
    }


   
}
