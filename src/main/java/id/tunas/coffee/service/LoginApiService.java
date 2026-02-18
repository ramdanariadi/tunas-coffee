package id.tunas.coffee.service;

import id.tunas.coffee.dto.api.GetAccessTokenRequest;
import id.tunas.coffee.dto.api.LoginRequest;
import id.tunas.coffee.dto.api.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApiService {
    @POST("/api/v1/user/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("/api/v1/user/token")
    Call<LoginResponse> token(@Body GetAccessTokenRequest request);
}
