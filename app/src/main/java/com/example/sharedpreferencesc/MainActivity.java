package com.example.sharedpreferencesc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
Button ar,en;
Context context;
    String current_Device_language,current_app_language;
    SharedPreferences sharedPreferences ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current_Device_language=(Locale.getDefault().getDisplayLanguage().toString());

        textView=findViewById(R.id.textView);
        textView.setText(current_Device_language.toString());
        sharedPreferences = getSharedPreferences("MySP",MODE_PRIVATE); //open
        ar=findViewById(R.id.ar);
        en=findViewById(R.id.en);

        if (sharedPreferences.getString("language","").equals("ar")){
          allarabic();

        }else if(sharedPreferences.getString("language","").equals("en")){
        allenglish();
        }
ar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        current_app_language="ar";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language",current_app_language);
       // editor.remove("language");

        editor.commit();
        allarabic();
    }
});
       en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_app_language="en";
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("language",current_app_language);
                // editor.remove("language");

                editor.commit();
allenglish();
            }
        });
    }
    private void allenglish(){

        en.setText("english");
        ar.setText("arabic");
    }
    private void allarabic() {
        en.setText("اللغة الانجليزية");
        ar.setText("اللغة العربية");
    }

}