package com.moby.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg_page;
    private RadioButton rbtn_page1;
    private RadioButton rbtn_page2;
    private RadioButton rbtn_page3;
    private RadioButton rbtn_page4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initActivity();
    }

    private void initActivity() {
        rg_page = (RadioGroup) findViewById(R.id.rg_page);
        rbtn_page1 = (RadioButton) findViewById(R.id.rbtn_page1);
        rbtn_page2 = (RadioButton) findViewById(R.id.rbtn_page2);
        rbtn_page3 = (RadioButton) findViewById(R.id.rbtn_page3);
        rbtn_page4 = (RadioButton) findViewById(R.id.rbtn_page4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbtn_page1:
                break;
            case R.id.rbtn_page2:
                break;
            case R.id.rbtn_page3:
                break;
            case R.id.rbtn_page4:
                break;
            default:
                break;
        }
    }
}
