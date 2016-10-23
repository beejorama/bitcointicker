package com.example.ben.bitcointicker;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import info.blockchain.api.APIException;
import info.blockchain.api.exchangerates.Currency;
import info.blockchain.api.exchangerates.ExchangeRates;

import static android.content.ContentValues.TAG;

/**
 * Created by Ben on 16/10/2016.
 */

public class UpdateAsyncTask extends AsyncTask<UIManager, Void, Currency> {

    HashMap<String, Currency> hm;
    UIManager u;
    Currency c;

    @Override
    protected Currency doInBackground(UIManager... u){
        this.u = u[0] ;

        try{
            hm = (HashMap<String, Currency>) ExchangeRates.getTicker();
            c = hm.get("GBP");
        }
        catch (APIException e){
            System.out.print("APIException" + e);
            Log.e(TAG, "doInBackground: API Exception");
        }
        catch (IOException e){
            System.out.println("IOException" + e);
            Log.e(TAG, "doInBackground: IOException");
        }
        return c;
    }

    protected void onPostExecute(Currency result) {
        u.populateFields(result);
    }
}
