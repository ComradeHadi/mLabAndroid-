package app.comradehadi.mlabsapp.views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import app.comradehadi.mlabsapp.R;
import app.comradehadi.mlabsapp.api.JsonFormatter;
import app.comradehadi.mlabsapp.api.ServerCallClass;
import app.comradehadi.mlabsapp.models.Analysis;
import app.comradehadi.mlabsapp.models.BaseModel;
import app.comradehadi.mlabsapp.presenters.BrandAdapter;
import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;

import static app.comradehadi.mlabsapp.models.BaseModel.ONE_LAYER;

public class MainActivity extends AppCompatActivity {

    ServerCallClass serverCallClass;
    List<BaseModel> arrayList;
    JsonObject serverObject;
    Analysis analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serverCallClass = new ServerCallClass(MainActivity.this);

        analysis = serverCallClass.getBrandData();

      //  Log.e("OUTPUT ANANAL", analysis.toString());



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        setBrandData();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.brandDataRecyclerView) ;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        BrandAdapter brandAdapter = new BrandAdapter(arrayList);
        recyclerView.setAdapter(brandAdapter);

        //initialiseGraph();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void initialiseGraph(){
        BarChart barChart = (BarChart) findViewById(R.id.bar_chart_vertical);
        barChart.setBarMaxValue(100);

        //Add single bar
        BarChartModel barChartModel = new BarChartModel();
        barChartModel.setBarValue(50);
        barChartModel.setBarColor(Color.parseColor("#9C27B0"));
        barChartModel.setBarTag(null); //You can set your own tag to bar model
        barChartModel.setBarText("50");

        barChart.addBar(barChartModel);

//Add mutliple bar at once as list;
        List<BarChartModel> barChartModelList = new ArrayList<>();

//populate bar array list and add to barchart as a list.
        barChart.addBar(barChartModelList);
    }

    private void setBrandData(){
        arrayList = new ArrayList<>();
        arrayList.add(new BaseModel(analysis, BaseModel.ONE_LAYER));
//        arrayList.add(new BaseModel("two", BaseModel.TWO_LAYERS));
//        arrayList.add(new BaseModel("three", BaseModel.THREE_LAYERS));
//        arrayList.add(new BaseModel("one", BaseModel.ONE_LAYER));
    }
}
