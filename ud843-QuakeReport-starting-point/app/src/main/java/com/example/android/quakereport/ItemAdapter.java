package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {


    public ItemAdapter(@NonNull Context context, @NonNull ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null)
            listItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);

        Item currentItem = getItem(position);

        TextView currentMagnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        currentMagnitude.setText(currentItem.getMagnitude());

        TextView currentLocation = (TextView) listItemView.findViewById(R.id.location);
        currentLocation.setText(currentItem.getLocation());

        TextView currentDate = (TextView) listItemView.findViewById(R.id.date);
        currentDate.setText(currentItem.getDate());

        return listItemView;
    }
}
