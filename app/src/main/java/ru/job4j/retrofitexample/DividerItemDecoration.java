package ru.job4j.retrofitexample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private int padding;
    private Paint paint;
    private int offSet;

    DividerItemDecoration(int padding) {
        this.padding = padding;
        this.offSet = 16;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.paint.setColor(Color.parseColor("#03DAC5"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top += padding;
        outRect.bottom += padding;
        outRect.left += padding;
        outRect.right += padding;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);

            c.drawRect(
                    layoutManager.getDecoratedLeft(child) + offSet,
                    layoutManager.getDecoratedTop(child) + offSet,
                    layoutManager.getDecoratedRight(child) - offSet,
                    layoutManager.getDecoratedBottom(child) - offSet,
                    this.paint
            );
        }
    }
}
