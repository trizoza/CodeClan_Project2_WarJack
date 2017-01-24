package example.codeclan.com.cardgame;

import android.content.Context;
import android.preference.PreferenceManager;

import java.util.ArrayList;

/**
 * Created by user on 23/01/2017.
 */

public class BJSavedStatistics {

    // static is a class variable( like self. in ruby) final means it cant be changed
    private static final String PREF_SAVEDTEXT = "savedStats";

    // context keeps track of oper system stage
    /* */
    public static void setStoredText(Context context, String text) {
//        REFACTORED
        PreferenceManager.getDefaultSharedPreferences(context) //Shared Preferences
                .edit() //Editor
                .putString(PREF_SAVEDTEXT, text) //Editor
                .apply();   //void

//        ORIGINAL
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//
//        //to change preferences we need editor
//        SharedPreferences.Editor editor = prefs.edit();
//        //editor will save String text into "savedText" key
//        editor.putString(PREF_SAVEDTEXT, text);
//        //apply saved changes, can be done with .commit() too, which sends extra boolean confirmation of done or failed
//        editor.apply();
    }

    public static String getStoredText(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_SAVEDTEXT, null);

//        ORIGINAL
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//        //null can be exchanged with "DEFAULT IF NOTHING FOUND"
//        return prefs.getString(PREF_SAVEDTEXT, null);
    }



}
