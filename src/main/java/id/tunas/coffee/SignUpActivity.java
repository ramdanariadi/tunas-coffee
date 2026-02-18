package id.tunas.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import id.tunas.coffee.dto.api.LoginResponse;
import id.tunas.coffee.dto.api.RegisterRequest;
import id.tunas.coffee.service.RetrofitClient;
import id.tunas.coffee.service.TokenManagement;
import id.tunas.coffee.service.UserApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button backButton = findViewById(R.id.btn_sign_up_back);
        backButton.setOnClickListener(this::finish);

        TextView singInTV = findViewById(R.id.sign_in_tv);
        singInTV.setOnClickListener(this::finish);

        EditText username = findViewById(R.id.register_username);
        EditText email = findViewById(R.id.register_email);
        EditText mobile = findViewById(R.id.register_mobile);
        EditText password = findViewById(R.id.register_password);

        Button regiserButton = findViewById(R.id.register_btn);
        regiserButton.setOnClickListener(view -> {
            String username1 = username.getText().toString();
            String email1 = email.getText().toString();
            String mobile1 = mobile.getText().toString();
            String password1 = password.getText().toString();
            register(username1, email1, mobile1, password1);
        });
    }

    private void finish(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void register(String username, String email, String mobile, String password){
        TokenManagement tokenManagement = TokenManagement.getInstance(this);
        Retrofit instance = RetrofitClient.getInstance();
        UserApiService userApiService = instance.create(UserApiService.class);
        RegisterRequest registerRequest = new RegisterRequest(username, email, mobile, password);
        Call<LoginResponse> register = userApiService.register(registerRequest);

        register.enqueue(new retrofit2.Callback<>() {
            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse body = response.body();
                    tokenManagement.saveToken(body.getData().getAccessToken(), body.getData().getRefreshToken());

                    Toast.makeText(SignUpActivity.this, "registration success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(SignUpActivity.this, "registration failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Toast.makeText(SignUpActivity.this, "error network", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
