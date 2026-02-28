package id.tunas.coffee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import id.tunas.coffee.adapter.ProductGridAdapter;
import id.tunas.coffee.adapter.decorations.GridSpacingItemDecoration;
import id.tunas.coffee.dto.Product;
import id.tunas.coffee.dto.api.GetProductsResponse;
import id.tunas.coffee.service.ProductApiService;
import id.tunas.coffee.service.RetrofitClient;
import id.tunas.coffee.service.TokenManagement;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
{
    private static final Logger LOGGER = Logger.getLogger(MainActivity.class.getName());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration(50, 2);
        RecyclerView recyclerView = findViewById(R.id.category_grid);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(gridSpacingItemDecoration);
        this.getProducts(recyclerView);
    }

    private void getProducts(RecyclerView recyclerView){
        Retrofit instance = RetrofitClient.getInstance();
        TokenManagement tokenManagement = TokenManagement.getInstance(this);
        ProductApiService productApiService = instance.create(ProductApiService.class);
        productApiService.getProducts("Bearer " + tokenManagement.getToken()).enqueue(new retrofit2.Callback<>() {
            @Override
            public void onResponse(@NonNull Call<GetProductsResponse> call, @NonNull Response<GetProductsResponse> response) {
                if(response.isSuccessful()){
                    List<Product> products = response.body().getData();
                    LOGGER.info("products: " + products.toString());
                    ProductGridAdapter adapter = new ProductGridAdapter(products);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetProductsResponse> call, @NonNull Throwable t) {

            }
        });
    }
}
