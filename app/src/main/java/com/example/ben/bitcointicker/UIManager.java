package com.example.ben.bitcointicker;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import info.blockchain.api.exchangerates.Currency;

/**
 * Handles all UI changes
 * Created by Ben on 16/10/2016.
 */

public class UIManager extends Activity{

    private Context context;
    private View rootView;
    TextView lastText;

    /**
     * Default constructor
     * @param mL
     */
    public UIManager(int[] mL, Context con, View mRootView) {
        this.context = con;
        this.rootView = mRootView;
        lastText = (TextView) this.rootView.findViewById(mL[0]);
    }

    public void populateFields(Currency c){
        lastText.setText("£" + c.getLast().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }
}
