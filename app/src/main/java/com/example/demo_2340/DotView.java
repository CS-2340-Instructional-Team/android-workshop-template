package com.example.demo_2340;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DotView extends View {
    private Paint paint;
    private Dot dot;

    public DotView(Context context, Dot dot) {
        super(context);
        this.dot = dot;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (dot.isVisible()) {
            paint.setColor(Color.BLUE);
            canvas.drawCircle(dot.getX(), dot.getY(), dot.getRadius(), paint);
        }
    }
}
