package app.comradehadi.mlabsapp.presenters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.comradehadi.mlabsapp.R;
import app.comradehadi.mlabsapp.models.Analysis;
import app.comradehadi.mlabsapp.models.BaseModel;

import static app.comradehadi.mlabsapp.models.BaseModel.ONE_LAYER;
import static app.comradehadi.mlabsapp.models.BaseModel.THREE_LAYERS;
import static app.comradehadi.mlabsapp.models.BaseModel.TWO_LAYERS;

public class BrandAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<BaseModel> list;

    public BrandAdapter(List<BaseModel> list) {

        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        BaseModel baseModel = list.get(position);

        if(baseModel != null){
           return baseModel.getNumber_of_layers();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        switch (i){
            case ONE_LAYER :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brand_data_page_one, viewGroup, false);

                return new BrandAnalysisViewHolder(view);


            case TWO_LAYERS :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brand_data_page_two, viewGroup, false);


                return new BrandReachViewHolder(view);

            case THREE_LAYERS :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brand_data_page_three, viewGroup, false);

                return new BrandAnalysisReachViewHolder(view);


        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        Log.e("MODEL BASE", list.get(i).toString());

        BaseModel baseModel = list.get(i);

        switch (baseModel.getNumber_of_layers()){
            case ONE_LAYER:
                Analysis baseModelAnalysis = baseModel.getAnalysis();
                ( (BrandAnalysisViewHolder)viewHolder).title.setText(baseModelAnalysis.getSubTitle()
               );
                break;

            case TWO_LAYERS:
               // ( (BrandReachViewHolder)viewHolder).title.setText(baseModel.getTitle());
                break;

            case THREE_LAYERS:
              //  ( (BrandAnalysisReachViewHolder)viewHolder).title.setText(baseModel.getTitle());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BrandAnalysisViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public BrandAnalysisViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.brand_analysis_text);
        }
    }



    class BrandReachViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public BrandReachViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.brand_analysis_text);
        }
    }

    class BrandAnalysisReachViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public BrandAnalysisReachViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.brand_analysis_text);
        }
    }
}
