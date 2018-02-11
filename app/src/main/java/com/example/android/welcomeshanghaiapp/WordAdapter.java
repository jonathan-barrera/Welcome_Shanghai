package com.example.android.welcomeshanghaiapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by jonathanbarrera on 2/10/18
 * This custom WordAdapter class can adapt instances from the Word class to
 * an array for TextView inflation.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //private MediaPlayer mediaPlayer;

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_phrase, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView chineseTextView = (TextView) listItemView.findViewById(R.id.chinese_translation);
        // Get the version name from the current Word object and
        // set this text on the TextView
        chineseTextView.setText(currentWord.getChineseTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_translation);
        // Get the version number from the current Word object and
        // set this text on the TextView
        englishTextView.setText(currentWord.getEnglishTranslation());

        // Set the ColorResourceId as the background color for the text_container view
        // which contains both of the text views.
        /**View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Set the background color for the play button
        View playButton = listItemView.findViewById(R.id.play_button);
        playButton.setBackgroundColor(color);


        listItemView.setBackgroundColor(mColorResourceId); */


        // Return the whole list item layout (containing 2 TextViews and an ImageView and a media player)
        // so that it can be shown in the ListView
        return listItemView;
    }

}