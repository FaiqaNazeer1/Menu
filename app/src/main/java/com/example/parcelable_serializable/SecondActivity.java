package com.example.parcelable_serializable;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView tvType, tvCountryName, tvCapital, tvLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvType = findViewById(R.id.tvType);
        tvCountryName = findViewById(R.id.tvCountryName);
        tvCapital = findViewById(R.id.tvCapital);
        tvLanguage = findViewById(R.id.tvLanguage);

        String type = getIntent().getStringExtra("type");

        if (type.equals("serializable")) {
            CountrySerializable c = (CountrySerializable) getIntent().getSerializableExtra("country_serializable");
            tvType.setText("Received via: Serializable");
            tvCountryName.setText("Country Name: " + c.getCountryName());
            tvCapital.setText("Capital: " + c.getCapital());
            tvLanguage.setText("National Language: " + c.getNationalLanguage());
        } else {
            CountryParcelable c = getIntent().getParcelableExtra("country_parcelable");
            tvType.setText("Received via: Parcelable");
            tvCountryName.setText("Country Name: " + c.getCountryName());
            tvCapital.setText("Capital: " + c.getCapital());
            tvLanguage.setText("National Language: " + c.getNationalLanguage());
        }
    }
}