package com.risqi17.garbpenjahit;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class komplain extends AppCompatActivity implements View.OnClickListener {


    public static final String KEY_ID = "id";
    public static final String KEY_ISI = "isi";

    private Button btSaran;
    private EditText etSaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komplain);

        getSupportActionBar().setTitle("Feedback");

        btSaran = (Button)findViewById(R.id.btSaran);
        btSaran.setOnClickListener(this);
        etSaran = (EditText)findViewById(R.id.etSaran);


    }

    private void Saran() {

        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String ids = sharedPreferences.getString(Config.ID_SHARED_PREF, "Not Available");

        final String id = ids;
        final String isi = etSaran.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.SARAN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(komplain.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(komplain.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_ID, id);
                params.put(KEY_ISI, isi);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        etSaran.setText("");
    }

    @Override
    public void onClick(View v){
        Saran();
    }
}
