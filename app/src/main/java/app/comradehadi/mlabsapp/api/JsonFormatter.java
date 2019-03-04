package app.comradehadi.mlabsapp.api;

import com.google.gson.JsonObject;

import app.comradehadi.mlabsapp.models.Analysis;
import app.comradehadi.mlabsapp.models.Phrase;

public class JsonFormatter {

    public JsonFormatter() {
    }

    public Analysis fetchAnalysisFromData(JsonObject jsonObject){
        Analysis analysis ;
        Phrase phrase;

        JsonObject analysisObject = jsonObject.get("analysis").getAsJsonObject();
        JsonObject phrasesObject = analysisObject.get("phrases").getAsJsonObject();

        phrase = new Phrase(phrasesObject.get("summary").getAsString(), phrasesObject.get("performance").getAsString(),
                phrasesObject.get("winner").getAsString(), phrasesObject.get("delta").getAsString());

        analysis = new Analysis(
                analysisObject.get("id").getAsString(),
                analysisObject.get("title").getAsString(),
                analysisObject.get("sub_title").getAsString(),
                analysisObject.get("text").getAsString(),
                phrase
        );

        return analysis;

    }
}
