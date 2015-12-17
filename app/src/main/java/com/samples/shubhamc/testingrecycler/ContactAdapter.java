package com.samples.shubhamc.testingrecycler;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shubhamc on 15-12-2015.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    String[] Data;
    private int previousPosition=0;

    public ContactAdapter(Context context){
        Log.d("breakpoint8", "the application is reaaching at this point8");
        Resources resources = context.getResources();
        Data = resources.getStringArray(R.array.name);
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_details, parent, false);
        return new ContactViewHolder(itemView);
    }

    //inside the onBindViewHolder mothod fill the view to be displayed
    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
//in this fill the data into each row present in the recycler view
        holder.vName.setText(Data[position]);
        //apply the animation at this place
        if(position > previousPosition)
        {
          MainActivity.animate(holder, true);
        }
        else
        {
            MainActivity.animate(holder,false);
        }
        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return Data.length;
    }


    //extend  viewholder and create a  class inside the adapter !!!!
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        //in this class we bind the view to our components

        protected TextView vName;

        public ContactViewHolder(View itemView) {
            super(itemView);
            Log.d("breakpoint9", "the application is reaaching at this point9");
            //in this bind the view with the ui components
            vName = (TextView) itemView.findViewById(R.id.Name);

        }
    }
}
