package com.example.penguasanacara2_fix;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Method untuk validasi username dan password
    private boolean isValidUsernameAndPassword(String username, String password) {
        return username.equals("Mukhlish") && password.equals("123");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi view dari layout
        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        // Menambahkan listener pada button login
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Memeriksa validitas username dan password
            if (isValidUsernameAndPassword(username, password)) {
                showCustomToast("Login succesful");
            } else {
                showCustomToast("Incorrect username or password");
            }
        });
    }

    // Method untuk menampilkan custom Toast message
    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_xml, null);

        TextView textView = layout.findViewById(R.id.toast_xml);
        textView.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP  | Gravity.FILL_HORIZONTAL, 0, 1500);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}