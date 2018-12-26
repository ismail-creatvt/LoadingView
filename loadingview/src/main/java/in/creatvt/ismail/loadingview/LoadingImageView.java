package in.creatvt.ismail.loadingview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class LoadingImageView extends AppCompatImageView {

    private static final int[] STATE_INITIAL = {R.attr.state_initial};

    private static final int[] STATE_SLOW_LOADING = {R.attr.state_slow_loading};

    private static final int[] STATE_FAST_LOADING = {R.attr.state_fast_loading};

    private static final int[] STATE_FINISH = {R.attr.state_finish};

    private static final int INITIAL = 0;

    private static final int SLOW_LOADING = 1;

    private static final int FAST_LOADING = 2;

    private static final int FINISH = 3;

    private boolean isSlowLoading = false;

    private boolean isFastLoading = false;

    private boolean isFinish = false;

    private boolean isInitial = true;

    public LoadingImageView(Context context) {
        super(context);
    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {

        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);

        if(isFinish){
            mergeDrawableStates(drawableState,STATE_FINISH);
        }
        else if(isSlowLoading){
            mergeDrawableStates(drawableState,STATE_SLOW_LOADING);
        }

        else if(isFastLoading){
            mergeDrawableStates(drawableState,STATE_FAST_LOADING);
        }
        else{
            mergeDrawableStates(drawableState,STATE_INITIAL);
        }

        return drawableState;
    }

    public boolean isSlowLoading() {
        return isSlowLoading;
    }

    public void setSlowLoading(boolean slowLoading) {
        if(slowLoading){
            resetBooleansExcept(SLOW_LOADING);
        }
        isSlowLoading = slowLoading;
        refreshDrawableState();
    }

    public boolean isFastLoading() {
        return isFastLoading;
    }

    public void setFastLoading(boolean fastLoading) {
        if(fastLoading){
            resetBooleansExcept(FAST_LOADING);
        }
        isFastLoading = fastLoading;
        refreshDrawableState();
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        if(finish){
            resetBooleansExcept(FINISH);
        }
        isFinish = finish;
        refreshDrawableState();
    }

    public boolean isInitial() {
        return isInitial;
    }

    public void setInitial(boolean initial) {
        if(initial){
            resetBooleansExcept(INITIAL);
        }
        isInitial = initial;
        refreshDrawableState();
    }

    private void resetBooleansExcept(int except){
        isInitial = except == INITIAL && isInitial;
        isSlowLoading = except == SLOW_LOADING && isSlowLoading;
        isFastLoading = except == FAST_LOADING && isFastLoading;
        isFinish = except == FINISH && isFinish;
    }
}
