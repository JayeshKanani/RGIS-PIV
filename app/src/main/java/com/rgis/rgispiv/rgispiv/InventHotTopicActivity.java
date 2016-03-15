package com.rgis.rgispiv.rgispiv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InventHotTopicActivity extends Activity implements View.OnClickListener {

    ImageButton imgbtnBack;
    Button btnInventHotNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invent_hot_topic);

        initialize();
    }

    private void initialize() {

        imgbtnBack = (ImageButton)findViewById(R.id.imgbtnBack);
        imgbtnBack.setOnClickListener(this);

        btnInventHotNext = (Button)findViewById(R.id.btnInventHotNext);
        btnInventHotNext.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == imgbtnBack)
        {
            finish();
        }
        else if(v == btnInventHotNext)
        {
            Bundle getbundle = getIntent().getExtras();

            Bundle putbundle = new Bundle();
            putbundle.putString("Store Name", getbundle.getString("Store Name"));
            putbundle.putString("Store Number", getbundle.getString("Store Number"));
            putbundle.putString("Inventory Date", getbundle.getString("Inventory Date"));
            putbundle.putString("Sales Floor Count Length", getbundle.getString("Sales Floor Count Length"));
            putbundle.putString("RGIS Arrival Time BR", getbundle.getString("RGIS Arrival Time BR"));
            putbundle.putString("RGIS Arrival Time SF", getbundle.getString("RGIS Arrival Time SF"));
            putbundle.putString("NL Count Manager", getbundle.getString("NL Count Manager"));
            putbundle.putString("NL Count Manager Contact Number", getbundle.getString("NL Count Manager Contact Number"));
            putbundle.putString("RGIS Supervisor", getbundle.getString("RGIS Supervisor"));
            putbundle.putString("RGIS Supervisor Contact Number", getbundle.getString("RGIS Supervisor Contact Number"));

            Intent intent = new Intent(InventHotTopicActivity.this,StoreReadinessActivity.class);
            intent.putExtras(putbundle);
            startActivity(intent);
        }
    }
}
