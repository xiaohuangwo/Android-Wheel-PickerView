package vn.fstyle.com.androidWheelPickerView.widget;

import java.util.ArrayList;
import java.util.List;

import vn.fstyle.com.androidWheelPickerView.R;

/**
 * WheelOptions.
 *
 * @author DaoLQ
 */
final class WheelOptions {
    private final WheelPickerView view;
    private LoopView mLoopView;

    private WheelPickerView.OnOptionChangedListener mOnOptionChangedListener;

    public WheelOptions(WheelPickerView view) {
        super();
        this.view = view;
    }

    public void setOnOptionChangedListener(
            WheelPickerView.OnOptionChangedListener listener) {
        this.mOnOptionChangedListener = listener;
    }

    public void setPicker(List<String> items) {
        List<String> mOptionsItems = items == null ? new ArrayList<String>() : items;
        mLoopView = (LoopView) view.findViewById(R.id.loopView);
        mLoopView.setArrayList(mOptionsItems);
        mLoopView.setCurrentItem(0);
        mLoopView.setNotLoop();

        mLoopView.setListener(new LoopRunnable.LoopListener() {
            @Override
            public void onItemSelect(int item) {
                doItemChange();
            }
        });
        assert items != null;
        setCurrentItems(items.size() / 2);
    }

    private void doItemChange() {
        if (mOnOptionChangedListener != null) {
            int option1 = mLoopView.getCurrentItem();
            mOnOptionChangedListener.onOptionChanged(view, option1);
        }
    }

    public void setCyclic(boolean cyclic) {
        mLoopView.setCyclic(cyclic);
    }

    public int getCurrentItems() {
        return mLoopView.getCurrentItem();
    }

    public void setCurrentItems(int option1) {
        mLoopView.setCurrentItem(option1);
    }
}
