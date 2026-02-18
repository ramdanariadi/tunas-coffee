package id.tunas.coffee;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import id.tunas.coffee.adapter.ProductListAdapter;
import id.tunas.coffee.dto.Product;

public class ListProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        ProductListAdapter adapter = new ProductListAdapter(Product.createDummy());
        RecyclerView recyclerView = findViewById(R.id.rc_product);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
