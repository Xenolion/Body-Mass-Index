package com.xenolion.bodymassindex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Obese People always tap this Button!!\n There is neither messages nor food, Just Chill!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void seeBMI(View view){
        try {
        EditText wei= (EditText)findViewById(R.id.w);
        EditText hei= (EditText)findViewById(R.id.h);
        TextView bmitext=(TextView)findViewById(R.id.bmitxt);
        double weight=Double.parseDouble(wei.getText().toString());
        double height=Double.parseDouble(hei.getText().toString());
        double bmi=((weight)/(height*height));
        bmitext.setText(String.valueOf(bmi));
        TextView status=(TextView)findViewById(R.id.stts);
        if(bmi<18.5)
            status.setText("Underweight");
        else if (bmi>=18.5 && bmi<=24.9)
            status.setText("Normal");
        else if(bmi>=25&&bmi<=29.9)
            status.setText("Overweight");
        else if(bmi>=30 && bmi<=39.9)
            status.setText("Obese");
        else
            status.setText("Morbid Obesity");
        MediaPlayer mp =MediaPlayer.create(getApplicationContext(),R.raw.beep);
        mp.start();}
        catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Please both data correctly to continue!!\n Good luck!!",Toast.LENGTH_LONG);
        }

    }
}
