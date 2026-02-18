package id.tunas.coffee.service;

import id.tunas.coffee.dto.api.LoginResponse;
import id.tunas.coffee.dto.api.RegisterRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiService {
    @GET("/api/v1/user")
    Call<Void> getProfile();

    @POST("/api/v1/user/register")
    Call<LoginResponse> register(@Body RegisterRequest request);
}
