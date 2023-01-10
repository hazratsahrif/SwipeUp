package utils;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

public class TopFadingEdge extends RecyclerView {
     Context context;
     AttributeSet attributeSet;
    int defStyleAttr = 0;
    public TopFadingEdge(Context context) {
        super(context);
        this.context = context;
    }
    public TopFadingEdge(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        this.context = context;
        this.attributeSet = attributeSet;
    }
    public TopFadingEdge(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context,attributeSet,defStyleAttr);
        this.context = context;
        this.attributeSet = attributeSet;
        this.defStyleAttr = defStyleAttr;
    }
    @Override
    protected float getBottomFadingEdgeStrength() {
        return 0;

    }

    @Override
    protected float getTopFadingEdgeStrength() {
        return 55;
    }
}
