package com.chuyennt.it4785_2012;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("jsonObject");
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            ((TextView)findViewById(R.id.textView)).setText(jsonObject.getString("username"));
            ((TextView)findViewById(R.id.textView)).setText(jsonObject.getString("name"));
            ((TextView)findViewById(R.id.textView)).setText(jsonObject.getString("email"));
            ((TextView)findViewById(R.id.textView)).setText(new JSONObject(jsonObject.getString("address")).getString("street"));
            ((TextView)findViewById(R.id.textView)).setText(jsonObject.getString("phone"));
            ((TextView)findViewById(R.id.textView)).setText(new JSONObject(jsonObject.getString("company")).getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}