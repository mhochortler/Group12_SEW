package at.maymay.convertme.application.dal;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import at.maymay.convertme.application.core.model.Currency;


public class CurrencyExchangeAPI extends AsyncTask<Currency, Void, JSONObject> {
    static private String url = "https://openexchangerates.org/api/latest.json";
    static private String charset = java.nio.charset.StandardCharsets.UTF_8.name();
    static private String apikey = "4a473f8e307b47d4862f6ab1dfdb269c";
    private static String query = "app_id=" + apikey;
    private Currency curr = null;
    private JSONObject obj;

    protected JSONObject doInBackground(Currency... arg0) {
        JSONObject jsonObject = null;
        curr = arg0[0];
        try {
            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String json = "";
            String line = reader.readLine();
            while(line != null){
                json += line;
                line = reader.readLine();
            }
            reader.close();
            if (!json.equals("")) {
                jsonObject = new JSONObject(json);
            }
        } catch (Exception e) {
            System.out.println("Couldn't get Exchange rates!"+ e.getMessage());
        }
        this.obj = jsonObject;
        return jsonObject;
    }

    protected void onPostExecute(JSONObject obj) {
        obj = this.obj;
        curr.loadExchangeRates(obj);
    }
}
