package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.clickshop.Mpreference;
import com.example.clickshop.R;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getSupportActionBar().hide();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (Mpreference.retrive(splashActivity.this)) {
                        Intent intent = new Intent(splashActivity.this, ProductView.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Intent intent = new Intent(splashActivity.this, signin.class);
                        startActivity(intent);
                        finish();
                    }

                    }
                }

            };


        thread.start();
        };
    }
