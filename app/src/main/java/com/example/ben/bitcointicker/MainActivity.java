package com.example.ben.bitcointicker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends Activity {

    public UIManager uiManager;
//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setActionBar(toolbar);

        Context con = this;

        uiManager = new UIManager(new int[] {R.id.last_text_view}, con, findViewById(R.id.activity_main));
        UpdateAsyncTask updater = new UpdateAsyncTask();
        updater.execute(uiManager);
    }
}
