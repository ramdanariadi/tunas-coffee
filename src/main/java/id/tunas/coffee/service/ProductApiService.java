package id.tunas.coffee.service;

import id.tunas.coffee.dto.api.GetProductsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ProductApiService {

    @GET("/api/v1/product")
    Call<GetProductsResponse> getProducts();
}
