package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
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
        Double magnitude = currentItem.getMagnitude();

        GradientDrawable magnitudeCircle = (GradientDrawable) currentMagnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentItem.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        NumberFormat numberFormatMagnitude = NumberFormat.getNumberInstance();
        currentMagnitude.setText(numberFormatMagnitude.format(magnitude));

        TextView currentLocationRadius = (TextView) listItemView.findViewById(R.id.location_radius);
        currentLocationRadius.setText(currentItem.getLocationRadius());

        TextView currentLocationArea = (TextView) listItemView.findViewById(R.id.location_area);
        currentLocationArea.setText(currentItem.getLocationArea());

        TextView currentDate = (TextView) listItemView.findViewById(R.id.date);
        currentDate.setText(currentItem.getDate());

        TextView currentTime = (TextView) listItemView.findViewById(R.id.time);
        currentTime.setText(currentItem.getTime());

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
