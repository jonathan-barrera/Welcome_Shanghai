package com.example.android.welcomeshanghaiapp;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class UsefulPhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    /**
     * global variable OnCompletionListener
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    /**
     * global variable OnAudioFocusChangeListener
     */
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phrase_list);

        // Create and setup the {@ AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Create an array list to contain all of the vocab words for numbers.
        final ArrayList<Word> words = new ArrayList<Word>();

        // Add each number vocab word and its miwok translation
        words.add(new Word("Hello", "你好 (nǐ hǎo)",
                R.raw.nihao));
        words.add(new Word("My name is...", "我叫... (wǒ jiào)",
                R.raw.wojiao));
        words.add(new Word("Where are you from?", "你是哪国人？(nǐ shì nǎguórén)",
                R.raw.nishinaguoren));
        words.add(new Word("I am American.", "我是美国人。(wǒ shì měiguórén)",
                R.raw.woshimeiguoren));
        words.add(new Word("I don't understand.", "我听不懂。(wǒ tīngbùdǒng)",
                R.raw.wotingbudong));
        words.add(new Word("Do you speak English?", "你会说英语吗？(nǐ huì shuō yīngyǔ ma?)",
                R.raw.nihuishuoyingyuma));
        words.add(new Word("Excuse me", "对不起 (duìbùqǐ)",
                R.raw.duibuoqi));
        words.add(new Word("Thank You", "谢谢 (xièxie)",
                R.raw.xiexie));
        words.add(new Word("Bathroom", "厕所 (cèsuǒ)",
                R.raw.cesuo));
        words.add(new Word("Where is...?", "...在哪里？(zài nǎli?)",
                R.raw.zainali));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                // Release the media player before playing an audiofile
                releaseMediaPlayer();

                // request audio focus to play the audio file
                int result = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(UsefulPhrasesActivity.this, word.getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    /**
     * Release the mediaplayer if the user leaves the app.
     */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Abandon focus once the media player has been released.
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}