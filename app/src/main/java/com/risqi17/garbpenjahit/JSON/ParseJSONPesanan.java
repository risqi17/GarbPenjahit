package com.risqi17.garbpenjahit.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Risqi17 on 30/05/2017.
 */

public class ParseJSONPesanan {
    public static String[] ids;
    public static String[] models;
    public static String[] ukurans;

    public static final String JSON_ARRAY = "pesanan";
    public static final String KEY_ID_USER = "id_pemesanan";
    public static final String KEY_ID_MODEL = "id_model";
    public static final String KEY_UKURAN = "ukuran";

    private JSONArray users = null;

    private String json;

    public ParseJSONPesanan(String json) {
        this.json = json;
    }

    public void parseJSON() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            models = new String[users.length()];
            ukurans = new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID_USER);
                models[i] = jo.getString(KEY_ID_MODEL);
                ukurans[i] = jo.getString(KEY_UKURAN);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}