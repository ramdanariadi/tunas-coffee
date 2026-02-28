package id.tunas.coffee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.tunas.coffee.adapter.ProductGridAdapter;
import id.tunas.coffee.adapter.decorations.GridSpacingItemDecoration;
import id.tunas.coffee.dto.Product;

public class MainActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductGridAdapter adapter = new ProductGridAdapter(Product.createDummy());
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration(50, 2);
        RecyclerView recyclerView = findViewById(R.id.category_grid);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(gridSpacingItemDecoration);
        recyclerView.setAdapter(adapter);
    }
}
