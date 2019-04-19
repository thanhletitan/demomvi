package net.thoitrangsi.ptcore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.databinding.DataBindingUtil;
import net.thoitrangsi.ptcore.databinding.HeaderFragmentBinding;

import timber.log.Timber;

/**
 * Created by thanh.le on 4/17/2019.
 */
public class HeaderView extends RelativeLayout {
    HeaderFragmentBinding binding;
    private String title;
    private OnClickListener leftClick;
    private OnClickListener rightFirstButtonClick;
    private OnClickListener rightSecondButtonClick;
    private OnClickListener rightThirdButtonClick;
    private int iconLeft = R.drawable.ic_arrow_back_black_24dp;
    private int iconRight1 = R.drawable.ic_search_black_24dp;
    private int iconRight2 = R.drawable.ic_arrow_back_black_24dp;
    private int iconRight3 = R.drawable.ic_arrow_back_black_24dp;


    public HeaderView(Context context) {
        super(context);
        init(context);
    }

    private HeaderView(Context context, String title, OnClickListener leftClick, OnClickListener rightFirstButtonClick,
                       OnClickListener rightSecondButtonClick, OnClickListener rightThirdButtonClick,
                       int iconLeft,int iconRight1,int iconRight2,int iconRight3) {
        super(context);
        this.title = title;
        this.leftClick = leftClick;
        this.rightSecondButtonClick = rightSecondButtonClick;
        this.rightThirdButtonClick = rightThirdButtonClick;
        this.rightFirstButtonClick = rightFirstButtonClick;
        this.iconLeft = iconLeft;
        this.iconRight1 = iconRight1;
        this.iconRight2 = iconRight2;
        this.iconRight3 = iconRight3;
        init(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        Timber.i("init");
        if (!isInEditMode()) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.header_fragment, this, true);
            binding.executePendingBindings();
            setButton();
            setIcon();
            setTitle(title);
        } else {
            inflate(context, R.layout.header_fragment, this);
        }

    }

    private void setIcon(){
        binding.btnBack.setImageResource(iconLeft);
        binding.btnRight1.setImageResource(iconRight1);
        binding.btnRight2.setImageResource(iconRight2);
        binding.btnRight3.setImageResource(iconRight3);

    }
    private void setButton() {
        binding.btnBack.setVisibility(leftClick != null ? View.VISIBLE : View.GONE);
        binding.btnRight1.setVisibility(rightFirstButtonClick != null ? View.VISIBLE : View.GONE);
        binding.btnRight2.setVisibility(rightSecondButtonClick != null ? View.VISIBLE : View.GONE);
        binding.btnRight3.setVisibility(rightThirdButtonClick != null ? View.VISIBLE : View.GONE);
        if (leftClick != null) {
            setLeftButtonClick(leftClick);
        }
        if (rightFirstButtonClick != null) {
            set1ButtonClick(rightFirstButtonClick);
        }
        if (rightSecondButtonClick != null) {
            set2ButtonClick(rightSecondButtonClick);
        }
        if (rightThirdButtonClick != null) {
            set3ButtonClick(rightThirdButtonClick);
        }
    }

    private void setLeftButtonClick(OnClickListener click) {
        binding.btnBack.setOnClickListener(click);
    }

    private void set1ButtonClick(OnClickListener click) {
        binding.btnRight1.setOnClickListener(click);
    }

    private void set2ButtonClick(OnClickListener click) {
        binding.btnRight2.setOnClickListener(click);
    }

    private void set3ButtonClick(OnClickListener click) {
        binding.btnRight3.setOnClickListener(click);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title!=null)
            binding.setTitle(title);
    }

    public Builder Builder() {
        return new Builder(this);
    }


    //TODO Builder
    public class Builder {
        private Context context;
        private String title;
        private OnClickListener leftClick;
        private OnClickListener rightFirstButtonClick;
        private OnClickListener rightSecondButtonClick;
        private OnClickListener rightThirdButtonClick;
        private int iconLeft;
        private int iconRight1;
        private int iconRight2;
        private int iconRight3;

        public Builder(HeaderView headerView) {
            this.context = headerView.getContext();
            this.leftClick = headerView.leftClick;
            this.rightFirstButtonClick = headerView.rightFirstButtonClick;
            this.rightSecondButtonClick = headerView.rightSecondButtonClick;
            this.rightThirdButtonClick = headerView.rightThirdButtonClick;
            this.iconLeft = headerView.iconLeft;
            this.iconRight1 = headerView.iconRight1;
            this.iconRight2 = headerView.iconRight2;
            this.iconRight3 = headerView.iconRight3;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setLeftClick(OnClickListener click) {
            this.leftClick = click;
            return this;
        }

        public Builder set1RightClick(OnClickListener click) {
            this.rightFirstButtonClick = click;
            return this;
        }

        public Builder set2RightClick(OnClickListener click) {
            this.rightSecondButtonClick = click;
            return this;
        }

        public Builder set3RightClick(OnClickListener click) {
            this.rightThirdButtonClick = click;
            return this;
        }

        public Builder setIconLeft(int icon) {
            this.iconLeft = icon;
            return this;
        }
        public Builder setIconRight1(int icon) {
            this.iconRight1 = icon;
            return this;
        }
        public Builder setIconRight2(int icon) {
            this.iconRight2 = icon;
            return this;
        }
        public Builder setIconRight3(int icon) {
            this.iconRight3 = icon;
            return this;
        }

        public HeaderView build() {
            return new HeaderView(context, title, leftClick, rightFirstButtonClick, rightSecondButtonClick,
                    rightThirdButtonClick,iconLeft,iconRight1,iconRight2,iconRight3);
        }
    }
}

