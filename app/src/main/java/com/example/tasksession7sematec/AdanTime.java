package com.example.tasksession7sematec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdanTime extends AppCompatActivity {
    EditText etCityName;
    Button btnOk;
    TextView tvAdanTime;
    String txtetCityName;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adan_time);


        etCityName = findViewById(R.id.etCityName);
        btnOk = findViewById(R.id.btnOk);
        tvAdanTime = findViewById(R.id.tvAdanTime);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtetCityName = etCityName.getText().toString();
                url = "https://api.aladhan.com/v1/timingsByCity?city="+txtetCityName+"&country=Iran&method=8";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            URL obj = new URL("url");
                            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                            con.setRequestMethod("GET");
                            con.setRequestProperty("User-Agent", "Mozilla/5.0");
                            int responseCode = con.getResponseCode();
                            if (responseCode == HttpURLConnection.HTTP_OK) {
                                BufferedReader in = new BufferedReader(new InputStreamReader(
                                        con.getInputStream()));
                                String inputLine;
                                StringBuffer response = new StringBuffer();
                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                }
                               // System.out.println(response.toString());


                                JSONObject objResponse = new JSONObject(response.toString());
                                String strData = objResponse.getString("data");
                                JSONObject objData = new JSONObject(strData);
                                String strTimings = objResponse.getString("timings");
                                JSONObject objTimings = new JSONObject(strTimings);
                                String strMaghrib = objResponse.getString("Maghrib");

                                tvAdanTime.setText(strMaghrib);

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }).start();


            }
        });


    }
}
