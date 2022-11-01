package com.shemtom.enteryourdetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText nameTxt, emailTxt, dateBirth;
    Button nextBtn, exitBtn;

    AlertDialog dialog;
    DatePickerDialog.OnDateSetListener dateDialog;

    final Calendar myCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTxt = (EditText) findViewById(R.id.nameTxt); //enter name
        emailTxt = (EditText) findViewById(R.id.emailTxt); //email
        dateBirth = (EditText) findViewById(R.id.editTextDate); //date

        nextBtn = (Button) findViewById(R.id.nextButton);
        exitBtn = (Button) findViewById(R.id.ExitBtn);

        showDate();
        showDateDetails();
        Next();
        Exit();
    }

    //onclick next then save the details
    public void Next()
    {
        nextBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //display entered details in an output panel - dialog
                showDetailsDialog(nameTxt.getText() + "\n" + dateBirth.getText() + "\n" + emailTxt.getText());
            }
        });
    }

    public void showDetailsDialog(String details)
    {
        dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Details entered")
                .setMessage(details)
                .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }
    public void showDateDetails()
    {
        dateDialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                String myFormat="dd/MM/yy";
                SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.UK);
                dateBirth.setText(dateFormat.format(myCalendar.getTime()));
            }
        };
    }

    public void showDate()
    {
        dateBirth.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //display entered details in an output panel - dialog
                new DatePickerDialog(MainActivity.this,dateDialog,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //on click exit then exit app
    public void Exit()
    {
        exitBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //exit the app
            finish();
            System.exit(0);
            }
        });
    }
}