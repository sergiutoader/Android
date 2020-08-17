/*      Toader Sergiu-Cristian      */

package com.example.tema1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adaugare de action bar cu options menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.toggle_open_descritpion, R.string.toggle_close_description);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        if(navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        RadioButton rb1 = findViewById(R.id.radioButton1);
        rb1.toggle();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // onClick la elementele din drawer
        switch (item.getItemId()) {
            case R.id.start_1:
                drawer.closeDrawer(GravityCompat.START);
                Intent i1 = new Intent(this, FirstDescendantActivity.class);
                startActivity(i1);
                return true;
            case R.id.start_2:
                drawer.closeDrawer(GravityCompat.START);
                Intent i2 = new Intent(this, SecondDescendantActivity.class);
                startActivity(i2);
                return true;
            case R.id.maps:
                drawer.closeDrawer(GravityCompat.START);
                Uri uri = Uri.parse("geo:44.435065,26.047774");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String message = "This is an important message";
        // onClick la butoanele din options menu
        if(id == R.id.action_information) {
            final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Title");
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}
            });
            alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}
            });
            alertBuilder.show();
        } else if(id == R.id.action_toast) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    // onClick la FAB
    public void displaySnackBar(View view) {
        Snackbar.make(view, "This message is important", Snackbar.LENGTH_SHORT).show();
    }

    public void displayInfo(View view) {
        String output = "";

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        // Verificare Radio Buttons
        switch (selectedId) {
            case R.id.radioButton1:
                output += "First RB selected";
                break;
            case R.id.radioButton2:
                output += "Second RB selected";
                break;
            case R.id.radioButton3:
                output += "Third RB selected";
                break;
        }

        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        // Verificare CheckBox
        if(checkBox1.isChecked()) {
            output += ", First CB selected";
        }
        if(checkBox2.isChecked()) {
            output += ", Second CB selected";
        }

        ToggleButton tb = findViewById(R.id.toggleButton);
        // Verificare Toggle Button
        if(!(tb.isChecked())) {
            output += ", Toggle button off";
        } else {
            output += ", Toggle button on";
        }

        // Verificare Edit Text
        EditText et = findViewById(R.id.editText);
        String etString = et.getText().toString();

        output += (", text is " + etString);
        Log.v("Tema1", output);
    }
}