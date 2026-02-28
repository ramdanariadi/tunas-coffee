package id.tunas.coffee.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.tunas.coffee.R;
import id.tunas.coffee.dto.Product;

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.ProductViewHolder> {

    private final List<Product> products;

    public ProductGridAdapter(List<Product> categories) {
        this.products = categories;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_grid_item, parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product category = products.get(position);
        holder.product.setText(category.getName());
        Glide.with(holder.itemView.getContext()).load(category.getImageUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView product;
        private final ImageView img;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            this.product = itemView.findViewById(R.id.category_text);
            this.img = itemView.findViewById(R.id.category_image);
        }
    }
}
