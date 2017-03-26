package com.navandu.micontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmContact extends AppCompatActivity {


    String tlf;
    String name;
    String email;
    String description;
    int day;
    int month;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_contact);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(getResources().getString(R.string.res_name));
        tlf = bundle.getString(getResources().getString(R.string.res_tlf));
        email = bundle.getString(getResources().getString(R.string.res_email));
        description = bundle.getString(getResources().getString(R.string.res_description));

        day = bundle.getInt(getResources().getString(R.string.res_day));
        month = bundle.getInt(getResources().getString(R.string.res_month));
        year = bundle.getInt(getResources().getString(R.string.res_year));

        TextView tvName = (TextView) findViewById(R.id.tvNameConfirm);
        tvName.setText(name);

        TextView tvDate = (TextView) findViewById(R.id.tvDateConfirm);
        tvDate.setText(Integer.toString(day) + "/" + Integer.toString(month + 1)  + "/" + Integer.toString(year));

        TextView tvTlf = (TextView) findViewById(R.id.tvTlfConfirm);
        tvTlf.setText(tlf);

        TextView tvEmail = (TextView) findViewById(R.id.tvEmailConfirm);
        tvEmail.setText(email);

        TextView tvDescription = (TextView) findViewById(R.id.tvDescriptionConfirm);
        tvDescription.setText(description);

        Button btn = (Button) findViewById(R.id.BtnEdit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmContact.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.res_name), name);
                intent.putExtra(getResources().getString(R.string.res_tlf), tlf);
                intent.putExtra(getResources().getString(R.string.res_email), email);
                intent.putExtra(getResources().getString(R.string.res_description), description);
                intent.putExtra(getResources().getString(R.string.res_day), day);
                intent.putExtra(getResources().getString(R.string.res_month), month);
                intent.putExtra(getResources().getString(R.string.res_year), year);


                startActivity(intent);

            }
        });

    }
}
