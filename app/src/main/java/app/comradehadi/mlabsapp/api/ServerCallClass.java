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

import app.comradehadi.mlabsapp.models.Analysis;
import app.comradehadi.mlabsapp.store.LocalStore;

public class ServerCallClass {
    Context context;
    ProgressBarGIFDialog.Builder progressBarGIFDialog;
      Analysis serverResults;
     JsonObject modifiedResults;
     LocalStore localStore;



    public ServerCallClass(Context context) {
        this.context = context;
    }


    public Analysis getBrandData(){
        localStore = new LocalStore(context);

        progressBarGIFDialog= new ProgressBarGIFDialog.Builder((Activity)this.context);



        Ion.with(this.context)
                .load(URLs.GET_BRAND_DATA)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        if(result != null){


                           // modifiedResults = result;
                            localStore.saveAnalysis(result);





                           }


                        else {

                            Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG).show();

                        }
                          Log.e("RESULTS ANALYSIS", serverResults.toString());


                    }


                });


        serverResults = new JsonFormatter().fetchAnalysisFromData(localStore.readAnalysis());
        return serverResults;
    }


   
}
