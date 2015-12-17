package com.samples.shubhamc.testingrecycler;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get reference to onCreate  method and Configure it!!
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        final RecyclerView view;
        view = (RecyclerView) findViewById(R.id.recycler_view);
        view.setHasFixedSize(true);
        //setting the layout manager
        Log.d("breakpoint1", "the application is reaaching at this point1");
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        Log.d("breakpoint2", "the application is reaaching at this point2");
        if (mLayoutManager != null) {
            Log.d("breakpoint3", "the application is reaaching at this point3");

            view.setLayoutManager(mLayoutManager);
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            Log.d("breakpoint5", "the application is reaaching at this point5");
            //set the orientation for the recyclerview layout manager

            //set the adapter for the recycler view
            ContactAdapter ca = new ContactAdapter(this);
            Log.d("breakpoint6", "the application is reaaching at this point6");
            view.setAdapter(ca);
            Log.d("breakpoint7", "the application is reaaching at this point7");
        } else {
            Log.d("breakpoint4", "the application is reaaching at this point4");
            Toast.makeText(this, "layout manager is null", Toast.LENGTH_LONG).show();
        }


    }


    //write a animate function that will work on the viewholder
    public static void animate(RecyclerView.ViewHolder viewHolder, Boolean goesDown ) {
        //perform animation to the view holder
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(viewHolder.itemView,"translationY",goesDown == true?350:-350,0);
        animatorTranslateY.setDuration(850);
        animatorTranslateY.start();
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
}
