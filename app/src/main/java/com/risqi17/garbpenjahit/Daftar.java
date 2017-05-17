package com.risqi17.garbpenjahit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Daftar extends Activity implements View.OnClickListener {


    public static final String KEY_ID = "id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_JK = "jk";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";

    private EditText editTextId;
    private EditText editTextNama;
    private EditText editTextEmail;
    private EditText editTextPassword;

    //private RadioGroup radiojk;
    private RadioButton radioL,radioP;

    private Button register;

    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager. LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_daftar);

        editTextId = (EditText) findViewById(R.id.edUser);
        editTextNama = (EditText) findViewById(R.id.edNama);
        editTextPassword = (EditText) findViewById(R.id.edPass);
        editTextEmail= (EditText) findViewById(R.id.edEmail);

        //radiojk = (RadioGroup)findViewById(R.id.radiojk);
        radioL = (RadioButton)findViewById(R.id.radioL);
        radioP = (RadioButton)findViewById(R.id.radioP);




        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(this);

        signin = (TextView)findViewById(R.id.txSignIn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });

    }
    /*public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioL:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radioP:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }*/

    private void registerPenjahit() {
        String jenisK = "";
        if(radioL.isChecked()){
            jenisK = "L";
        } else if(radioP.isChecked()){
            jenisK = "P";
        }

        final String id = editTextId.getText().toString().trim();
        final String nama = editTextNama.getText().toString().trim();
        final String jk = jenisK;
        final String password = editTextPassword.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Daftar.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Daftar.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_ID,id);
                params.put(KEY_NAMA,nama);
                params.put(KEY_JK,jk);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
        finish();
    }
    @Override
    public void onClick(View v) {
        if(v == register){
            registerPenjahit();
        }
    }
}
