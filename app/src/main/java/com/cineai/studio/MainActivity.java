package com.cineai.studio;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView status;
    private EditText screenplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(32, 28, 32, 28);
        root.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("CineAI Studio");
        title.setTextSize(28);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = new TextView(this);
        subtitle.setText("AI Cinematic Studio");
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle, new LinearLayout.LayoutParams(-1, -2));

        screenplay = new EditText(this);
        screenplay.setHint("سناریو یا داستان خود را وارد کنید...");
        screenplay.setGravity(Gravity.TOP | Gravity.RIGHT);
        screenplay.setMinLines(10);
        screenplay.setPadding(20, 20, 20, 20);
        root.addView(screenplay, new LinearLayout.LayoutParams(-1, 0, 1));

        LinearLayout buttons = new LinearLayout(this);
        buttons.setOrientation(LinearLayout.VERTICAL);

        Button newProject = new Button(this);
        newProject.setText("پروژه جدید");
        newProject.setOnClickListener(v -> {
            screenplay.setText("");
            status.setText("پروژه جدید آماده است.");
        });
        buttons.addView(newProject);

        Button convert = new Button(this);
        convert.setText("تبدیل سناریو");
        convert.setOnClickListener(v -> {
            if (screenplay.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "ابتدا سناریو را وارد کنید.", Toast.LENGTH_SHORT).show();
            } else {
                status.setText("سناریو برای تولید سینمایی آماده شد.");
            }
        });
        buttons.addView(convert);

        Button export = new Button(this);
        export.setText("خروجی ویدئو");
        export.setOnClickListener(v -> status.setText("خروجی ویدئو در نسخه بعدی فعال می‌شود."));
        buttons.addView(export);

        root.addView(buttons, new LinearLayout.LayoutParams(-1, -2));

        status = new TextView(this);
        status.setText("آماده");
        status.setTextSize(15);
        status.setGravity(Gravity.CENTER);
        status.setPadding(8, 16, 8, 8);
        root.addView(status, new LinearLayout.LayoutParams(-1, -2));

        ScrollView scroll = new ScrollView(this);
        scroll.addView(root);
        setContentView(scroll);
    }
}
