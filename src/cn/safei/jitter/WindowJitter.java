package cn.safei.jitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import cn.safei.R;

/**
 * @Copyright © 2015 sanbo Inc. All rights reserved.
 * @Description: 界面抖动
 * @Version: 1.0
 * @Create: 2015年6月29日 下午9:48:11
 * @Author: sanbo
 */
public class WindowJitter extends Activity {

    private LinearLayout line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jitter);

        initView();
    }

    private void initView() {
        line = (LinearLayout) this.findViewById(R.id.ly);
        this.findViewById(R.id.jitter).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(WindowJitter.this, R.anim.myanim);
                line.startAnimation(anim);
            }
        });
    }

}
