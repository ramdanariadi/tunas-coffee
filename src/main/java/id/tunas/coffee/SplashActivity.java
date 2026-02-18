package id.tunas.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import id.tunas.coffee.service.TokenManagement;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TokenManagement tokenManagement = TokenManagement.getInstance(this);
        String token = tokenManagement.getToken();
        Toast.makeText(this, token != null ? "valid session" : "invalid session", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, token != null ? MainActivity.class : LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
