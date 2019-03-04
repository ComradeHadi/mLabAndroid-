package app.comradehadi.mlabsapp.models;

import android.util.Log;

public class BaseModel {

    private Analysis analysis;
    private int number_of_layers;

    public static final  int ONE_LAYER = 1;
    public static final  int TWO_LAYERS = 2;
    public static final  int THREE_LAYERS = 3;


    public BaseModel(Analysis analysis, int number_of_layers) {
        this.analysis = analysis;
        this.number_of_layers = number_of_layers;
    }


    public Analysis getAnalysis() {
        if(this.analysis == null ){
            return new Analysis("1","ne ", "hghg", "jhgjjh", new Phrase("","","",""));
        }
        return this.analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public int getNumber_of_layers() {
        return number_of_layers;
    }

    public void setNumber_of_layers(int number_of_layers) {
        this.number_of_layers = number_of_layers;
    }


}
