package com.example.android.welcomeshanghaiapp;

/**
 * Created by jonathanbarrera on 2/09/2018
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Chinese translation for that word.
 */

public class Word {

    /** Default translation of the word */
    private String mEnglishTranslation;

    /** Chinese translation of the word */
    private String mChineseTranslation;

    /** Audio resource ID for the word*/
    private int mAudioResourceId;

    /**
     * The constructor for the english and miwork word translations *without* an image
     * @param englishTranslation the translation in the english
     * @param chineseTranslation the chinese translation
     */
    public Word(String englishTranslation, String chineseTranslation, int audioResourceId) {
        mEnglishTranslation = englishTranslation;
        mChineseTranslation = chineseTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the chinese translation of the word.
     */
    public String getChineseTranslation(){
        return mChineseTranslation;
    }

    /**
     * Get the english translation of the word.
     */
    public String getEnglishTranslation(){
        return mEnglishTranslation;
    }

    /**
     * Get the audio resource id for the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
