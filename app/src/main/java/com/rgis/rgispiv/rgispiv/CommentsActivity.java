package com.rgis.rgispiv.rgispiv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommentsActivity extends Activity implements View.OnClickListener {

    ImageButton imgbtnBack;
    Button btnTakePhotos,btnSubmit;
    int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    ImageView imgCapture;
    String filePath="";
    EditText edtComments;
    Bundle getbundle;
    boolean imageAttach=false, afterMailSent=false;
    String any_comments="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        initialize();

    }

    private void initialize() {
        imgbtnBack = (ImageButton)findViewById(R.id.imgbtnBack);
        imgbtnBack.setOnClickListener(this);

        btnTakePhotos = (Button)findViewById(R.id.btnTakePhotos);
        btnTakePhotos.setOnClickListener(this);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        imgCapture = (ImageView)findViewById(R.id.imgCapture);
        edtComments = (EditText)findViewById(R.id.edtComments);

        getBundledata();
    }
    String storeName="",storeNumber="",inventoryDate="",salesFLoor="",arrivalTImeBR="",arrivalTImeSF="",countManager="",countManagerContactNo="",rgisSupervisor="",rgisSupervisorContactNo="",storeReadinessOption="",storeComments="";

    String new_inventory="",back_room="",back_room_question="";

    private void getBundledata() {

       getbundle = getIntent().getExtras();
        storeName = getbundle.getString("Store Name");
        storeNumber = getbundle.getString("Store Number");
        inventoryDate = getbundle.getString("Inventory Date");
        salesFLoor = getbundle.getString("Sales Floor Count Length");
        arrivalTImeBR = getbundle.getString("RGIS Arrival Time BR");
        arrivalTImeSF = getbundle.getString("RGIS Arrival Time SF");
        countManager = getbundle.getString("NL Count Manager");
        countManagerContactNo = getbundle.getString("NL Count Manager Contact Number");
        rgisSupervisor = getbundle.getString("RGIS Supervisor");
        rgisSupervisorContactNo = getbundle.getString("RGIS Supervisor Contact Number");
        storeReadinessOption = getbundle.getString("Store Readiness Option");
        storeComments = getbundle.getString("Store Comments");

        new_inventory = getResources().getString(R.string.new_inventory_title)+"\n\n"+
                "Store Name: "+storeName + "\n\n"+
                "Store Number: "+storeNumber + "\n\n"+
                "Inventory Date: "+inventoryDate + "\n\n"+
                "Sales Floor Count Length: "+salesFLoor + "\n\n"+
                "RGIS Arrival Time BR: "+arrivalTImeBR + "\n\n"+
                "RGIS Arrival Time SF: "+arrivalTImeSF + "\n\n"+
                "NL Count Manager: "+countManager + "\n\n"+
                "NL Count Manager Contact Number: "+countManagerContactNo + "\n\n"+
                "RGIS Supervisor: "+rgisSupervisor + "\n\n"+
                "RGIS Supervisor Contact Number: "+rgisSupervisorContactNo + "\n\n"+
                getResources().getString(R.string.store_readiness_title)+"\n\n"+
                "Store Readiness Option: "+storeReadinessOption + "\n\n"+
                "Store Comments: "+storeComments + "\n\n";

        back_room_question = getResources().getString(R.string.backroom_title)+"\n\n"+
                getbundle.getString("Question1")+" : "+getbundle.getString("Answer1")+ "="+ getbundle.getString("QuestionSelection1") + "\n\n"+
                getbundle.getString("Question2")+" : "+getbundle.getString("Answer2")+ "="+ getbundle.getString("QuestionSelection2") + "\n\n"+
                getbundle.getString("Question3")+ "="+ getbundle.getString("QuestionSelection3") + "\n\n"+
                getbundle.getString("Question4")+ "="+ getbundle.getString("QuestionSelection4") + "\n\n"+
                getbundle.getString("Question5")+ "="+ getbundle.getString("QuestionSelection5") + "\n\n"+
                getbundle.getString("Question6")+ "="+ getbundle.getString("QuestionSelection6") + "\n\n"+
                getbundle.getString("Question7")+ "="+ getbundle.getString("QuestionSelection7") + "\n\n"+
                getbundle.getString("Question8")+ "="+ getbundle.getString("QuestionSelection8") + "\n\n"+
                getbundle.getString("Question9")+ "="+ getbundle.getString("QuestionSelection9") + "\n\n"+
                getbundle.getString("Question10")+ "="+ getbundle.getString("QuestionSelection10") + "\n\n"+
                getbundle.getString("Question11")+ "="+ getbundle.getString("QuestionSelection11") + "\n\n";

        back_room ="NL & RGIS Actions and Agreements 1 : "+ getbundle.getString("actionAgree1")+ "\n"+
                "Agreed by(NL Manager) 1 : "+getbundle.getString("agreeBy1")+ "\n"+
                "RGIS Review Completed (on inventory date) 1 : "+getbundle.getString("review1")+ "\n\n"+

                "NL & RGIS Actions and Agreements 2 : "+ getbundle.getString("actionAgree2")+ "\n"+
                "Agreed by(NL Manager) 2 : "+getbundle.getString("agreeBy2")+ "\n"+
                "RGIS Review Completed (on inventory date) 2 : "+getbundle.getString("review2")+ "\n\n"+

                "NL & RGIS Actions and Agreements 3 : "+ getbundle.getString("actionAgree3")+ "\n"+
                "Agreed by(NL Manager) 3 : "+getbundle.getString("agreeBy3")+ "\n"+
                "RGIS Review Completed (on inventory date) 3 : "+getbundle.getString("review3")+ "\n\n"+

                "NL & RGIS Actions and Agreements 4 : "+ getbundle.getString("actionAgree4")+ "\n"+
                "Agreed by(NL Manager) 4 : "+getbundle.getString("agreeBy4")+ "\n"+
                "RGIS Review Completed (on inventory date) 4 : "+getbundle.getString("review4")+ "\n\n"+

                "NL & RGIS Actions and Agreements 5 : "+ getbundle.getString("actionAgree5")+ "\n"+
                "Agreed by(NL Manager) 5 : "+getbundle.getString("agreeBy5")+ "\n"+
                "RGIS Review Completed (on inventory date) 5 : "+getbundle.getString("review5")+ "\n\n"+

                "NL & RGIS Actions and Agreements 6 : "+ getbundle.getString("actionAgree6")+ "\n"+
                "Agreed by(NL Manager) 6 : "+getbundle.getString("agreeBy6")+ "\n"+
                "RGIS Review Completed (on inventory date) 6 : "+getbundle.getString("review6")+ "\n\n"+

                "NL & RGIS Actions and Agreements 7 : "+ getbundle.getString("actionAgree7")+ "\n"+
                "Agreed by(NL Manager) 7 : "+getbundle.getString("agreeBy7")+ "\n"+
                "RGIS Review Completed (on inventory date) 7 : "+getbundle.getString("review7")+ "\n\n"+

                "NL & RGIS Actions and Agreements 8 : "+ getbundle.getString("actionAgree8")+ "\n"+
                "Agreed by(NL Manager) 8 : "+getbundle.getString("agreeBy8")+ "\n"+
                "RGIS Review Completed (on inventory date) 8 : "+getbundle.getString("review8")+ "\n\n"+

                "NL & RGIS Actions and Agreements 9 : "+ getbundle.getString("actionAgree9")+ "\n"+
                "Agreed by(NL Manager) 9 : "+getbundle.getString("agreeBy9")+ "\n"+
                "RGIS Review Completed (on inventory date) 9 : "+getbundle.getString("review9")+ "\n\n"+

                "NL & RGIS Actions and Agreements 10 : "+ getbundle.getString("actionAgree10")+ "\n"+
                "Agreed by(NL Manager) 10 : "+getbundle.getString("agreeBy10")+ "\n"+
                "RGIS Review Completed (on inventory date) 10 : "+getbundle.getString("review10")+ "\n\n"+

                "NL & RGIS Actions and Agreements 11 : "+ getbundle.getString("actionAgree11")+ "\n"+
                "Agreed by(NL Manager) 11 : "+getbundle.getString("agreeBy11")+ "\n"+
                "RGIS Review Completed (on inventory date) 11 : "+getbundle.getString("review11")+ "\n\n";

    }

    @Override
    public void onClick(View v) {
        if(v == imgbtnBack)
        {
            finish();
        }
        else if(v == btnTakePhotos)
        {
            selectImage();
        }
        else if(v == btnSubmit)
        {

            any_comments = "Any Comments: "+edtComments.getText().toString()+ "\n\n";

            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, new_inventory + "\n" + back_room_question + "\n" + back_room + "\n" + any_comments);
            emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            if(imageAttach)
            {
                emailIntent.setType("image/jpeg");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + picturePath));
            }

            startActivity(emailIntent);
            afterMailSent = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(afterMailSent)
        {
            Intent intent = new Intent(CommentsActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            afterMailSent = false;
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library", "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(CommentsActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    String picturePath="";
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
            {
                Uri selectedImage = data.getData();
                try {
                    Bitmap bitmap = decodeUri(selectedImage);
                    imgCapture.setImageBitmap(bitmap);

                    String[] filePath = { MediaStore.Images.Media.DATA };

                    Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);

                    c.moveToFirst();

                    int columnIndex = c.getColumnIndex(filePath[0]);

                    picturePath = c.getString(columnIndex);
                    imageAttach = true;

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

        final int REQUIRED_SIZE = 140;

        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);

    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        storeCameraPhotoInSDCard(thumbnail);

        imgCapture.setImageBitmap(thumbnail);

    }

    private void storeCameraPhotoInSDCard(Bitmap bitmap){

        File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "photo_" + System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            imageAttach = true;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            imageAttach = false;
        } catch (IOException e) {
            //e.printStackTrace();
            imageAttach = false;
        }

        picturePath = outputFile.getAbsolutePath();
    }

}
