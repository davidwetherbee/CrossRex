package com.dwetherbee.crossrexapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.dwetherbee.crossrexapp.R;

/**
 * Created with IntelliJ IDEA.
 * User: Flavadave
 * Date: 8/24/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenuActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
        button = (Button) findViewById(R.id.profilebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent1;
                intent1 = new Intent(MainMenuActivity.this, MyProfileActivity.class);
                startActivity(intent1);
            }
        });
    }
Button button;
}