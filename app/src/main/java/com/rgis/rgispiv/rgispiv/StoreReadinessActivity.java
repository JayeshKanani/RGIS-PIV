package com.rgis.rgispiv.rgispiv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class StoreReadinessActivity extends Activity implements View.OnClickListener {

    private RadioGroup radioInstGroup;
    private RadioButton radioInstButton;
    ImageButton backbutton;
    Button btnStoreNext;
    EditText edtComments;
    RadioButton rdbFirst,rdbSecond,rdbThird,rdbFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_readiness);
        
        
        initialize();

    }

    private void initialize() {
        radioInstGroup=(RadioGroup)findViewById(R.id.radioGroup1);
        backbutton=(ImageButton)findViewById(R.id.imgbtnBack);
        btnStoreNext = (Button)findViewById(R.id.btnStoreNext);
        edtComments = (EditText)findViewById(R.id.edtComments);
        rdbFirst = (RadioButton)findViewById(R.id.rdbFirst);
        rdbSecond = (RadioButton)findViewById(R.id.rdbSecond);
        rdbThird = (RadioButton)findViewById(R.id.rdbThird);
        rdbFourth = (RadioButton)findViewById(R.id.rdbFourth);

        backbutton.setOnClickListener(this);
        btnStoreNext.setOnClickListener(this);

        //int selectedId=radioSexGroup.getCheckedRadioButtonId();
       // radioSexButton=(RadioButton)findViewById(selectedId);
    }


    @Override
    public void onClick(View v) {
        if(v == backbutton)
        {
            finish();
        }
        else if(v == btnStoreNext)
        {

            if(radioInstGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(StoreReadinessActivity.this,"Please Select any one Option.",Toast.LENGTH_LONG).show();
            }
            else
            {
                String option ="";
                int selectedId = radioInstGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);
                option = selectedRadioButton.getText().toString();

               /* if(rdbFirst.isSelected())
                {
                    option = rdbFirst.getText().toString();
                }
                else if(rdbSecond.isSelected())
                {
                    option = rdbSecond.getText().toString();
                }
                else if(rdbThird.isSelected())
                {
                    option = rdbThird.getText().toString();
                }
                else if(rdbFourth.isSelected())
                {
                    option = rdbFourth.getText().toString();
                }*/

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
                putbundle.putString("Store Readiness Option",option);
                putbundle.putString("Store Comments",edtComments.getText().toString());

                Intent intent = new Intent(StoreReadinessActivity.this,BackRoomActivity.class);
                intent.putExtras(putbundle);
                startActivity(intent);
            }

        }
    }
}
