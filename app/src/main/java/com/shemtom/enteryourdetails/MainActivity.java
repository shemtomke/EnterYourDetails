package com.shemtom.enteryourdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameTxt, emailTxt, dateBirth;
    TextView details, topText;
    Button nextBtn, exitBtn, backBtn;
    View panel;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTxt = (EditText) findViewById(R.id.nameTxt); //enter name
        emailTxt = (EditText) findViewById(R.id.emailTxt); //email
        dateBirth = (EditText) findViewById(R.id.editTextDate); //date

        details = (TextView) findViewById(R.id.detailsDisplayTxt);
        topText = (TextView) findViewById(R.id.topViewTxt);

        nextBtn = (Button) findViewById(R.id.nextButton);
        exitBtn = (Button) findViewById(R.id.ExitBtn);
        backBtn = (Button) findViewById(R.id.backButton);

        panel = (View) findViewById(R.id.panelView);

        try {
            constraintLayout.setEnabled(false);
        }
        catch (Exception e)
        {

        }

        //disable the panel, backButton, TopTex and details
        DisablePanel();

        Next();
        Back();
        Exit();
    }

    void EnablePanel()
    {
        panel.setActivated(true);
        backBtn.setEnabled(true);
        topText.setEnabled(true);
        details.setEnabled(true);

        nextBtn.setEnabled(false);
        exitBtn.setEnabled(false);
    }
    void DisablePanel()
    {
        panel.setActivated(false);
        backBtn.setEnabled(false);
        topText.setEnabled(false);
        details.setEnabled(false);

        nextBtn.setEnabled(true);
        exitBtn.setEnabled(true);
    }

    //onclick next then save the details
    public void Next()
    {
        nextBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //display entered details in an output panel
                EnablePanel();
                details.setText(nameTxt + "\t" + emailTxt + "\t" + dateBirth);
            }
        });
    }
    public void Back()
    {
        backBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //display entered details in an output panel
                DisablePanel();
                details.setText("");
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