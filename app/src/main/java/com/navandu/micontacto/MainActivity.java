package com.navandu.micontacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextInputEditText teName;
    DatePicker date;
    TextInputEditText teTlf;
    TextInputEditText teEmail;
    TextInputEditText teDescripcion;
    int dayMonth;
    int month;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        teName = (TextInputEditText) findViewById(R.id.teName);
        date = (DatePicker) findViewById(R.id.datepicker);
        teTlf = (TextInputEditText) findViewById(R.id.teTlf);
        teEmail = (TextInputEditText) findViewById(R.id.teEmail);
        teDescripcion = (TextInputEditText) findViewById(R.id.teDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String nameBundle = bundle.getString(getResources().getString(R.string.res_name));
            teName.setText(nameBundle);

            String tlfBundle = bundle.getString(getResources().getString(R.string.res_tlf));
            teTlf.setText(tlfBundle);

            String emailBundle = bundle.getString(getResources().getString(R.string.res_email));
            teEmail.setText(emailBundle);

            String descriptionBundle = bundle.getString(getResources().getString(R.string.res_description));
            teDescripcion.setText(descriptionBundle);

            int dayBundle = bundle.getInt(getResources().getString(R.string.res_day));
            int monthBundle = bundle.getInt(getResources().getString(R.string.res_month));
            int yearBundle = bundle.getInt(getResources().getString(R.string.res_year));
            date.updateDate(yearBundle, monthBundle, dayBundle);
        }


        btn = (Button) findViewById(R.id.btnNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dayMonth = date.getDayOfMonth();
                month = date.getMonth();
                year = date.getYear();

                Log.i("name: ", teName.getText().toString());
                Log.i("tlf: ", teTlf.getText().toString());
                Log.i("email: ", teEmail.getText().toString());
                Log.i("description: ", teDescripcion.getText().toString());
                Log.i("day: ", Integer.toString(dayMonth));
                Log.i("month: ", Integer.toString(month));
                Log.i("year: ", Integer.toString(year));

                Intent intent = new Intent(MainActivity.this, ConfirmContact.class);

                //Para pasar en formato Array
                //String[] valores = new String[7];
                //valores[0] = teName.getText().toString();

                intent.putExtra(getResources().getString(R.string.res_name), teName.getText().toString());
                intent.putExtra(getResources().getString(R.string.res_day), dayMonth);
                intent.putExtra(getResources().getString(R.string.res_year), year);
                intent.putExtra(getResources().getString(R.string.res_month), month);
                intent.putExtra(getResources().getString(R.string.res_tlf), teTlf.getText().toString());
                intent.putExtra(getResources().getString(R.string.res_email), teEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.res_description), teDescripcion.getText().toString());

                startActivity(intent);



            }
        });

    }



}
