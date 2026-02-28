package id.tunas.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.tunas.coffee.dto.api.LoginRequest;
import id.tunas.coffee.dto.api.LoginResponse;
import id.tunas.coffee.service.LoginApiService;
import id.tunas.coffee.service.RetrofitClient;
import id.tunas.coffee.service.TokenManagement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button backButton = findViewById(R.id.btn_login_back);
        backButton.setOnClickListener(view -> finish());

        Button loginButton = findViewById(R.id.login_button);
        EditText username = findViewById(R.id.login_username);
        EditText password = findViewById(R.id.login_password);
        loginButton.setOnClickListener(view -> {
            login(username.getText().toString(), password.getText().toString());
        });

        TextView textView = findViewById(R.id.sign_up_tv);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
            finish();
        });

        TextView forgotPassTv = findViewById(R.id.forgot_pass);
        forgotPassTv.setOnClickListener(view -> {
            Intent intent = new Intent(this, ForgotPasswordActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void login(String username, String password){
        TokenManagement tokenManagement = TokenManagement.getInstance(this);
        Retrofit instance = RetrofitClient.getInstance(tokenManagement);
        LoginApiService loginApiService = instance.create(LoginApiService.class);

        LoginRequest loginRequest = new LoginRequest(username, password);
        Call<LoginResponse> login = loginApiService.login(loginRequest);

        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if( response.isSuccessful()){
                    LoginResponse body = response.body();
                    tokenManagement.saveToken(body.getData().getAccessToken(), body.getData().getRefreshToken());
                    Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "login failure" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "login failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
