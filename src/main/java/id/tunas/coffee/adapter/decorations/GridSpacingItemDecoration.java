package id.tunas.coffee.adapter.decorations;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.logging.Logger;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GridSpacingItemDecoration.class));

    private final int spacing;
    private final int spanCount;

    public GridSpacingItemDecoration(int spacing, int spanCount) {
        this.spacing = spacing;
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;
        LOGGER.info("position: " + position + ", column: " + column);
        outRect.left = column * spacing / spanCount;
        outRect.right = spacing - (column + 1) * spacing / spanCount;
        outRect.bottom = spacing;

        if (position < spanCount) {
            outRect.top = spacing;
        }
    }
}
