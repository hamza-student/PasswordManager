package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTextViewClick(View view) {
        TextView textView = findViewById(R.id.password);

        if (textView.getText().length() == 0) {
            Toast.makeText(context, "No password generated", Toast.LENGTH_SHORT).show();
            return;
        }

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("password", textView.getText());
        clipboard.setPrimaryClip(clip);

        Toast.makeText(context, "Copied successfully", Toast.LENGTH_SHORT).show();
    }

    public void onGenerateButtonClick(View view) {
        String password = PasswordGenerator.generate();
        TextView textView = findViewById(R.id.password);
        textView.setText(password);
    }
}