package com.example.a1718129_localization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1718129_localization.Helper.LocaleHelper;

import java.util.Locale;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView header, textView2, textView4, textView6, textView7, textView8, textView9, textView10;
    Button btn1,btn2;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = (TextView)findViewById(R.id.header);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView7 = (TextView)findViewById(R.id.textView7);
        textView8 = (TextView)findViewById(R.id.textView8);
        textView9 = (TextView)findViewById(R.id.textView9);
        textView10 = (TextView)findViewById(R.id.textView10);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if (language==null)
            Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));
    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        header.setText(resources.getString(R.string.freelance_illustrator));
        textView2.setText(resources.getString(R.string.appreciations));
        textView4.setText(resources.getString(R.string.followers));
        textView6.setText(resources.getString(R.string.following));
        textView7.setText(resources.getString(R.string.artist));
        textView8.setText(resources.getString(R.string.year5));
        textView9.setText(resources.getString(R.string.available));
        textView10.setText(resources.getString(R.string.portofolio));
        btn1.setText(resources.getString(R.string.follow));
        btn2.setText(resources.getString(R.string.message));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_id)
        {
            Paper.book().write("language","id");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }
}
