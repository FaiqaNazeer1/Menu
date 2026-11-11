package com.example.parcelable_serializable;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private void showPopupMenu(View view) {

        PopupMenu popupMenu = new PopupMenu(this, view);

        popupMenu.getMenu().add("Home");
        popupMenu.getMenu().add("Settings");
        popupMenu.getMenu().add("Profile");
        popupMenu.getMenu().add("Logout");

        popupMenu.setOnMenuItemClickListener(item -> {

            Toast.makeText(this,
                    item.getTitle(),
                    Toast.LENGTH_SHORT).show();

            return true;
        });

        popupMenu.show();
    }

    private void showFloatingMenu(View view) {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.WHITE);

        String[] options = {"Add", "Edit", "Delete", "Share"};

        PopupWindow popupWindow = new PopupWindow(
                layout,
                400,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true
        );

        for (String option : options) {

            TextView textView = new TextView(this);

            textView.setText(option);
            textView.setTextSize(18);
            textView.setPadding(20, 20, 20, 20);
            textView.setTextColor(Color.BLACK);

            layout.addView(textView);

            textView.setOnClickListener(v -> {

                Toast.makeText(this,
                        option + " Clicked",
                        Toast.LENGTH_SHORT).show();

                popupWindow.dismiss();
            });
        }

        popupWindow.showAtLocation(
                view,
                Gravity.CENTER,
                0,
                0
        );
    }

    @Override
    public void onCreateContextMenu(
            ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Option");

        menu.add(0, 1, 0, "Copy");
        menu.add(0, 2, 1, "Edit");
        menu.add(0, 3, 2, "Delete");
        menu.add(0, 4, 3, "Share");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case 1:
                Toast.makeText(this, "Copy Selected",
                        Toast.LENGTH_SHORT).show();
                return true;

            case 2:
                Toast.makeText(this, "Edit Selected",
                        Toast.LENGTH_SHORT).show();
                return true;

            case 3:
                Toast.makeText(this, "Delete Selected",
                        Toast.LENGTH_SHORT).show();
                return true;

            case 4:
                Toast.makeText(this, "Share Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onContextItemSelected(item);
    }
    EditText etCountryName, etCapital, etLanguage;
    Button btnSerializable, btnParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPopup = findViewById(R.id.btnPopup);
        Button btnFloating = findViewById(R.id.btnFloating);
        Button btnContext = findViewById(R.id.btnContext);

        btnPopup.setOnClickListener(v ->
                showPopupMenu(v));

        btnFloating.setOnClickListener(v ->
                showFloatingMenu(v));

        registerForContextMenu(btnContext);

        etCountryName = findViewById(R.id.etCountryName);
        etCapital = findViewById(R.id.etCapital);
        etLanguage = findViewById(R.id.etLanguage);
        btnSerializable = findViewById(R.id.btnSerializable);
        btnParcelable = findViewById(R.id.btnParcelable);

        btnSerializable.setOnClickListener(v -> {
            String name = etCountryName.getText().toString();
            String capital = etCapital.getText().toString();
            String lang = etLanguage.getText().toString();

            CountrySerializable country = new CountrySerializable(name, capital, lang);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("type", "serializable");
            intent.putExtra("country_serializable", country);
            startActivity(intent);
        });

        btnParcelable.setOnClickListener(v -> {
            String name = etCountryName.getText().toString();
            String capital = etCapital.getText().toString();
            String lang = etLanguage.getText().toString();

            CountryParcelable country = new CountryParcelable(name, capital, lang);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("type", "parcelable");
            intent.putExtra("country_parcelable", country);
            startActivity(intent);
        });
    }
}