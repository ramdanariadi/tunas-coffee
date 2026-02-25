package id.tunas.coffee.adapter;

import android.net.Uri;
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
import id.tunas.coffee.dto.Category;

public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridAdapter.CategoryViewHolder> {

    private List<Category> categories;

    public CategoryGridAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_list_item, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.category.setText(category.getName());
        Glide.with(holder.itemView.getContext()).load(category.getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView category;
        private ImageView img;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            this.category = itemView.findViewById(R.id.category_text);
            this.img = itemView.findViewById(R.id.category_image);
        }
    }
}
