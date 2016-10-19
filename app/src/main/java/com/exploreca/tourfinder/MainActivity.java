package com.exploreca.tourfinder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.exploreca.tourfinder.utils.UIHelper;

public class MainActivity extends Activity {

    public static final String LOGTAG = "EXPLORECA";
    public static final String USERNAME = "username";

    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getPreferences(MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void setPreference(View v) {
        Log.i(LOGTAG, "Clicked set");
        SharedPreferences.Editor editor = settings.edit();
        String prefValue = UIHelper.getText(this, R.id.editText1);
        editor.putString(USERNAME,prefValue);
        editor.commit();
        UIHelper.displayText(this, R.id.textView1, "Preferences saved!");
    }

    public void refreshDisplay(View v) {
        Log.i(LOGTAG, "Clicked show");

        String prefValue = settings.getString(USERNAME, "Not found!");
        UIHelper.displayText(this, R.id.textView1, prefValue);
    }

}
