package com.rgis.rgispiv.rgispiv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class BackRoomActivity extends Activity implements View.OnClickListener{

    Button btnBackRoomNext;
    ImageButton imgbtnBack;
    EditText actionAgree1,actionAgree2,actionAgree3,actionAgree4,actionAgree5,actionAgree6,actionAgree7,actionAgree8,actionAgree9,actionAgree10,actionAgree11;
    EditText agreeBy1,agreeBy2,agreeBy3,agreeBy4,agreeBy5,agreeBy6,agreeBy7,agreeBy8,agreeBy9,agreeBy10,agreeBy11;
    EditText review1,review2,review3,review4,review5,review6,review7,review8,review9,review10,review11;
    CheckBox chkQue1,chkQue2,chkQue3,chkQue4,chkQue5,chkQue6,chkQue7,chkQue8,chkQue9,chkQue10,chkQue11;
    EditText edtQue1,edtQue2;
    String queChecked1="",queChecked2="",queChecked3="",queChecked4="",queChecked5="",queChecked6="",queChecked7="",queChecked8="",queChecked9="",queChecked10="",queChecked11="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_room);

        initialize();
       
    }

    private void initialize() {
        btnBackRoomNext = (Button)findViewById(R.id.btnBackRoomNext);
        btnBackRoomNext.setOnClickListener(this);

        imgbtnBack = (ImageButton)findViewById(R.id.imgbtnBack);
        imgbtnBack.setOnClickListener(this);

        actionAgree1 = (EditText)findViewById(R.id.actionAgree1);
        actionAgree2 = (EditText)findViewById(R.id.actionAgree2);
        actionAgree3 = (EditText)findViewById(R.id.actionAgree3);
        actionAgree4 = (EditText)findViewById(R.id.actionAgree4);
        actionAgree5 = (EditText)findViewById(R.id.actionAgree5);
        actionAgree6 = (EditText)findViewById(R.id.actionAgree6);
        actionAgree7 = (EditText)findViewById(R.id.actionAgree7);
        actionAgree8 = (EditText)findViewById(R.id.actionAgree8);
        actionAgree9 = (EditText)findViewById(R.id.actionAgree9);
        actionAgree10 = (EditText)findViewById(R.id.actionAgree10);
        actionAgree11 = (EditText)findViewById(R.id.actionAgree11);

        agreeBy1 = (EditText)findViewById(R.id.agreeBy1);
        agreeBy2 = (EditText)findViewById(R.id.agreeBy2);
        agreeBy3 = (EditText)findViewById(R.id.agreeBy3);
        agreeBy4 = (EditText)findViewById(R.id.agreeBy4);
        agreeBy5 = (EditText)findViewById(R.id.agreeBy5);
        agreeBy6 = (EditText)findViewById(R.id.agreeBy6);
        agreeBy7 = (EditText)findViewById(R.id.agreeBy7);
        agreeBy8 = (EditText)findViewById(R.id.agreeBy8);
        agreeBy9 = (EditText)findViewById(R.id.agreeBy9);
        agreeBy10 = (EditText)findViewById(R.id.agreeBy10);
        agreeBy11 = (EditText)findViewById(R.id.agreeBy11);

        review1 = (EditText)findViewById(R.id.review1);
        review2 = (EditText)findViewById(R.id.review2);
        review3 = (EditText)findViewById(R.id.review3);
        review4 = (EditText)findViewById(R.id.review4);
        review5 = (EditText)findViewById(R.id.review5);
        review6 = (EditText)findViewById(R.id.review6);
        review7 = (EditText)findViewById(R.id.review7);
        review8 = (EditText)findViewById(R.id.review8);
        review9 = (EditText)findViewById(R.id.review9);
        review10 = (EditText)findViewById(R.id.review10);
        review11 = (EditText)findViewById(R.id.review11);

        edtQue1 = (EditText)findViewById(R.id.edtQue1);
        edtQue2 = (EditText)findViewById(R.id.edtQue2);

        chkQue1 = (CheckBox)findViewById(R.id.chkQue1);
        chkQue2 = (CheckBox)findViewById(R.id.chkQue2);
        chkQue3 = (CheckBox)findViewById(R.id.chkQue3);
        chkQue4 = (CheckBox)findViewById(R.id.chkQue4);
        chkQue5 = (CheckBox)findViewById(R.id.chkQue5);
        chkQue6 = (CheckBox)findViewById(R.id.chkQue6);
        chkQue7 = (CheckBox)findViewById(R.id.chkQue7);
        chkQue8 = (CheckBox)findViewById(R.id.chkQue8);
        chkQue9 = (CheckBox)findViewById(R.id.chkQue9);
        chkQue10 = (CheckBox)findViewById(R.id.chkQue10);
        chkQue11 = (CheckBox)findViewById(R.id.chkQue11);
    }

    @Override
    public void onClick(View v) {

        if(v == btnBackRoomNext)
        {

           checkboxSelection();

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
            putbundle.putString("Store Readiness Option",getbundle.getString("Store Readiness Option"));
            putbundle.putString("Store Comments",getbundle.getString("Store Comments"));

            putbundle.putString("QuestionSelection1",queChecked1);
            putbundle.putString("Question1",getResources().getString(R.string.backroom_point1));
            putbundle.putString("Answer1",edtQue1.getText().toString());
            putbundle.putString("QuestionSelection2",queChecked2);
            putbundle.putString("Question2",getResources().getString(R.string.backroom_point2));
            putbundle.putString("Answer2",edtQue2.getText().toString());
            putbundle.putString("QuestionSelection3",queChecked3);
            putbundle.putString("Question3",getResources().getString(R.string.backroom_point3));
            putbundle.putString("QuestionSelection4",queChecked4);
            putbundle.putString("Question4",getResources().getString(R.string.backroom_point4));
            putbundle.putString("QuestionSelection5",queChecked5);
            putbundle.putString("Question5",getResources().getString(R.string.backroom_point5));
            putbundle.putString("QuestionSelection6",queChecked6);
            putbundle.putString("Question6",getResources().getString(R.string.backroom_point6));
            putbundle.putString("QuestionSelection7",queChecked7);
            putbundle.putString("Question7",getResources().getString(R.string.backroom_point7));
            putbundle.putString("QuestionSelection8",queChecked8);
            putbundle.putString("Question8",getResources().getString(R.string.backroom_point8));
            putbundle.putString("QuestionSelection9",queChecked9);
            putbundle.putString("Question9",getResources().getString(R.string.backroom_point9));
            putbundle.putString("QuestionSelection10",queChecked10);
            putbundle.putString("Question10",getResources().getString(R.string.backroom_point10));
            putbundle.putString("QuestionSelection11",queChecked11);
            putbundle.putString("Question11",getResources().getString(R.string.backroom_point11));

            putbundle.putString("actionAgree1",actionAgree1.getText().toString());
            putbundle.putString("actionAgree2",actionAgree2.getText().toString());
            putbundle.putString("actionAgree3",actionAgree3.getText().toString());
            putbundle.putString("actionAgree4",actionAgree4.getText().toString());
            putbundle.putString("actionAgree5",actionAgree5.getText().toString());
            putbundle.putString("actionAgree6",actionAgree6.getText().toString());
            putbundle.putString("actionAgree7",actionAgree7.getText().toString());
            putbundle.putString("actionAgree8",actionAgree8.getText().toString());
            putbundle.putString("actionAgree9",actionAgree9.getText().toString());
            putbundle.putString("actionAgree10",actionAgree10.getText().toString());
            putbundle.putString("actionAgree11",actionAgree11.getText().toString());

            putbundle.putString("agreeBy1",agreeBy1.getText().toString());
            putbundle.putString("agreeBy2",agreeBy2.getText().toString());
            putbundle.putString("agreeBy3",agreeBy3.getText().toString());
            putbundle.putString("agreeBy4",agreeBy4.getText().toString());
            putbundle.putString("agreeBy5",agreeBy5.getText().toString());
            putbundle.putString("agreeBy6",agreeBy6.getText().toString());
            putbundle.putString("agreeBy7",agreeBy7.getText().toString());
            putbundle.putString("agreeBy8",agreeBy8.getText().toString());
            putbundle.putString("agreeBy9",agreeBy9.getText().toString());
            putbundle.putString("agreeBy10",agreeBy10.getText().toString());
            putbundle.putString("agreeBy11",agreeBy11.getText().toString());

            putbundle.putString("review1",review1.getText().toString());
            putbundle.putString("review2",review2.getText().toString());
            putbundle.putString("review3",review3.getText().toString());
            putbundle.putString("review4",review4.getText().toString());
            putbundle.putString("review5",review5.getText().toString());
            putbundle.putString("review6",review6.getText().toString());
            putbundle.putString("review7",review7.getText().toString());
            putbundle.putString("review8",review8.getText().toString());
            putbundle.putString("review9",review9.getText().toString());
            putbundle.putString("review10",review10.getText().toString());
            putbundle.putString("review11",review11.getText().toString());


            Intent intent = new Intent(BackRoomActivity.this,CommentsActivity.class);
            intent.putExtras(putbundle);
            startActivity(intent);

        }
        else if(v == imgbtnBack)
        {
            finish();
        }

    }

    public void checkboxSelection()
    {
        if(chkQue1.isChecked())
        {
            queChecked1 = "Selected";
        }
        else
        {
            queChecked1 = "Unselected";
        }

        if(chkQue2.isChecked())
        {
            queChecked2 = "Selected";
        }
        else
        {
            queChecked2 = "Unselected";
        }

        if(chkQue3.isChecked())
        {
            queChecked3 = "Selected";
        }
        else
        {
            queChecked3 = "Unselected";
        }

        if(chkQue4.isChecked())
        {
            queChecked4 = "Selected";
        }
        else
        {
            queChecked4 = "Unselected";
        }

        if(chkQue5.isChecked())
        {
            queChecked5 = "Selected";
        }
        else
        {
            queChecked5 = "Unselected";
        }

        if(chkQue6.isChecked())
        {
            queChecked6 = "Selected";
        }
        else
        {
            queChecked6 = "Unselected";
        }

        if(chkQue7.isChecked())
        {
            queChecked7 = "Selected";
        }
        else
        {
            queChecked7 = "Unselected";
        }

        if(chkQue8.isChecked())
        {
            queChecked8 = "Selected";
        }
        else
        {
            queChecked8 = "Unselected";
        }

        if(chkQue9.isChecked())
        {
            queChecked9 = "Selected";
        }
        else
        {
            queChecked9 = "Unselected";
        }

        if(chkQue10.isChecked())
        {
            queChecked10 = "Selected";
        }
        else
        {
            queChecked10 = "Unselected";
        }

        if(chkQue11.isChecked())
        {
            queChecked11 = "Selected";
        }
        else
        {
            queChecked11 = "Unselected";
        }
    }
}
