package example.codeclan.com.cardgame;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by user on 24/01/2017.
 */

public class WSavedWinners {

    private static final String PREF_SAVEDTEXT = "savedWinners";

    public static void setStoredText(Context context, String text) {

        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_SAVEDTEXT, text)
                .apply();
    }

    public static String getStoredText(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_SAVEDTEXT, null);

    }

}
