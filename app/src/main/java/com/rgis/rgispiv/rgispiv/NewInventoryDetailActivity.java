package com.rgis.rgispiv.rgispiv;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewInventoryDetailActivity extends Activity implements View.OnClickListener {

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    ImageButton imgbtnCalendar,imgbtnTimeBR,imgbtnTimeSF,imgbtnBack;
    EditText edtInventoryDate,edtArrivalTImeBR,edtArrivalTImeSF,edtStoreName,edtStoreNumber,edtSalesFLoor,edtCountManager,edtCountManagerContactNo,edtRGISSupervisor,edtRGISSupervisorContactNo;
    static final int TIME_DIALOG_ID = 1111;
    private int hour;
    private int minute;
    String timeIndicate="";
    Button btnNewInventNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_inventory_detail);
        
        initialize();

    }

    private void initialize() {
        imgbtnCalendar = (ImageButton)findViewById(R.id.imgbtnCalendar);
        imgbtnCalendar.setOnClickListener(this);

        imgbtnTimeBR = (ImageButton)findViewById(R.id.imgbtnTimeBR);
        imgbtnTimeBR.setOnClickListener(this);

        imgbtnTimeSF = (ImageButton)findViewById(R.id.imgbtnTimeSF);
        imgbtnTimeSF.setOnClickListener(this);

        btnNewInventNext = (Button)findViewById(R.id.btnNewInventNext);
        btnNewInventNext.setOnClickListener(this);

        imgbtnBack = (ImageButton)findViewById(R.id.imgbtnBack);
        imgbtnBack.setOnClickListener(this);

        edtInventoryDate = (EditText)findViewById(R.id.edtInventoryDate);
        edtArrivalTImeBR = (EditText)findViewById(R.id.edtArrivalTImeBR);
        edtArrivalTImeSF = (EditText)findViewById(R.id.edtArrivalTImeSF);
        edtStoreName = (EditText)findViewById(R.id.edtStoreName);
        edtStoreNumber = (EditText)findViewById(R.id.edtStoreNumber);
        edtSalesFLoor = (EditText)findViewById(R.id.edtSalesFLoor);
        edtCountManager = (EditText)findViewById(R.id.edtCountManager);
        edtCountManagerContactNo = (EditText)findViewById(R.id.edtCountManagerContactNo);
        edtRGISSupervisor = (EditText)findViewById(R.id.edtRGISSupervisor);
        edtRGISSupervisorContactNo = (EditText)findViewById(R.id.edtRGISSupervisorContactNo);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onClick(View v) {
        if(v == imgbtnCalendar)
        {
            showDialog(999);
        }
        else if(v == imgbtnTimeBR)
        {
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            // Current Minute
            minute = calendar.get(Calendar.MINUTE);
            timeIndicate = "RGIS Arrival Time BR";
            showDialog(TIME_DIALOG_ID);
        }
        else if(v == imgbtnTimeSF)
        {
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            // Current Minute
            minute = calendar.get(Calendar.MINUTE);
            timeIndicate = "RGIS Arrival Time SF";
            showDialog(TIME_DIALOG_ID);
        }
        else if(v == btnNewInventNext)
        {
            fieldValidation();
        }
        else if(v == imgbtnBack)
        {
            finish();
        }

    }

    String storeName="",storeNumber="",inventoryDate="",salesFLoor="",arrivalTImeBR="",arrivalTImeSF="",countManager="",countManagerContactNo="",rgisSupervisor="",rgisSupervisorContactNo="";


    private void fieldValidation() {
        pattern = Pattern.compile(DATE_VALIDATION_PATTERN);

        timeBRpattern = Pattern.compile(TIME24HOURS_PATTERN);
        timeSFpattern = Pattern.compile(TIME24HOURS_PATTERN);

        storeName = edtStoreName.getText().toString();
        storeNumber = edtStoreNumber.getText().toString();
        inventoryDate = edtInventoryDate.getText().toString();
        salesFLoor = edtSalesFLoor.getText().toString();
        arrivalTImeBR = edtArrivalTImeBR.getText().toString();
        arrivalTImeSF = edtArrivalTImeSF.getText().toString();
        countManager = edtCountManager.getText().toString();
        countManagerContactNo = edtCountManagerContactNo.getText().toString();
        rgisSupervisor = edtRGISSupervisor.getText().toString();
        rgisSupervisorContactNo = edtRGISSupervisorContactNo.getText().toString();

        if(storeName.equals(""))
        {
            edtStoreName.setError("Store Name Empty!");
        }
        else if(storeNumber.equals(""))
        {
            edtStoreNumber.setError("Store Number Empty!");
        }
        else if(inventoryDate.equals(""))
        {
            edtInventoryDate.setError("Inventory Date Empty!");
        }
        else if (!dateValidate(inventoryDate)) {
            edtInventoryDate.setError("Inventory Date Invalid!");
        }
        else if(salesFLoor.equals(""))
        {
            edtSalesFLoor.setError("Sales Floor Count Length Empty!");
        }
        else if(arrivalTImeBR.equals(""))
        {
            edtArrivalTImeBR.setError("RGIS Arrival Time (BR) Empty!");
        }
        else if(!timeBRvalidate(arrivalTImeBR))
        {
            edtArrivalTImeBR.setError("RGIS Arrival Time (BR) Invalid!");
        }
        else if(arrivalTImeSF.equals(""))
        {
            edtArrivalTImeSF.setError("RGIS Arrival Time (SF) Empty!");
        }
        else if(!timeSFvalidate(arrivalTImeSF))
        {
            edtArrivalTImeSF.setError("RGIS Arrival Time (SF) Invalid!");
        }
        else if(countManager.equals(""))
        {
            edtCountManager.setError("NL Count Manager Empty!");
        }
        else if(countManagerContactNo.equals(""))
        {
            edtCountManagerContactNo.setError("NL Count Manager Contact Number Empty!");
        }
        else if(!isValidNLCountManagerPhoneNumber(countManagerContactNo))
        {
            edtCountManagerContactNo.setError("NL Count Manager Contact Number Invalid!");
        }
        else if(rgisSupervisor.equals(""))
        {
            edtRGISSupervisor.setError("RGIS Supervisor Empty!");
        }
        else if(!isValidRGISSupervisorPhoneNumber(rgisSupervisorContactNo))
        {
            edtRGISSupervisorContactNo.setError("RGIS Supervisor Contact Number Invalid!");
        }
        else
        {
            Bundle bundle = new Bundle();
            bundle.putString("Store Name", storeName);
            bundle.putString("Store Number", storeNumber);
            bundle.putString("Inventory Date", inventoryDate);
            bundle.putString("Sales Floor Count Length", salesFLoor);
            bundle.putString("RGIS Arrival Time BR", arrivalTImeBR);
            bundle.putString("RGIS Arrival Time SF", arrivalTImeSF);
            bundle.putString("NL Count Manager", countManager);
            bundle.putString("NL Count Manager Contact Number", countManagerContactNo);
            bundle.putString("RGIS Supervisor", rgisSupervisor);
            bundle.putString("RGIS Supervisor Contact Number", rgisSupervisorContactNo);

            Intent intent = new Intent(NewInventoryDetailActivity.this,InventHotTopicActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    private Pattern pattern;
    private Matcher matcher;

    private static final String DATE_VALIDATION_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    private Pattern timeBRpattern,timeSFpattern;
    private Matcher timeBRmatcher,timeSFmatcher;

    private static final String TIME24HOURS_PATTERN =
            "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";

    /**
     * Validate date format with regular expression
     * @param date date address for validation
     * @return true valid date format, false invalid date format
     */
    public boolean dateValidate(final String date){

        matcher = pattern.matcher(date);

        if(matcher.matches()){
            matcher.reset();

            if(matcher.find()){
                String day = matcher.group(1);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(3));

                if (day.equals("31") &&
                        (month.equals("4") || month .equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month .equals("06") ||
                                month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                }

                else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if(year % 4==0){
                        if(day.equals("30") || day.equals("31")){
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                    else{
                        if(day.equals("29")||day.equals("30")||day.equals("31")){
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                }

                else{
                    return true;
                }
            }

            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        else if(id == TIME_DIALOG_ID)
        {
            return new TimePickerDialog(this, timePickerListener, hour, minute,
                    false);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        edtInventoryDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {


        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
            // TODO Auto-generated method stub
            hour   = hourOfDay;
            minute = minutes;

            updateTime(hour, minute);

        }

    };

    private static String utilTime(int value) {

        if (value < 10)
            return "0" + String.valueOf(value);
        else
            return String.valueOf(value);
    }

    // Used to convert 24hr format to 12hr format with AM/PM values
    private void updateTime(int hours, int mins) {

        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";


        String minutes = "";
        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);

        // Append in a StringBuilder
        String aTime = new StringBuilder().append(hours).append(':')
                .append(minutes).append(" ").append(timeSet).toString();

        if(timeIndicate.equals("RGIS Arrival Time BR"))
        {
            edtArrivalTImeBR.setText(aTime);
        }
        else
        {
            edtArrivalTImeSF.setText(aTime);
        }


    }

    public boolean timeBRvalidate(final String time){

        timeBRmatcher = timeBRpattern.matcher(time);
        return timeBRmatcher.matches();

    }

    public boolean timeSFvalidate(final String time){

        timeSFmatcher = timeSFpattern.matcher(time);
        return timeSFmatcher.matches();

    }

    public final static boolean isValidNLCountManagerPhoneNumber(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            if (target.length() < 6 || target.length() > 13) {
                return false;
            } else {
                return android.util.Patterns.PHONE.matcher(target).matches();
            }
        }
    }

    public final static boolean isValidRGISSupervisorPhoneNumber(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            if (target.length() < 6 || target.length() > 13) {
                return false;
            } else {
                return android.util.Patterns.PHONE.matcher(target).matches();
            }
        }
    }

}
