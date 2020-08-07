package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

import com.example.almacen.publico.PrefUtil;

public class Splashactivity extends AppCompatActivity {
ImageView ivsplash;
PrefUtil prefUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        prefUtil = new PrefUtil(this);
        ivsplash = (ImageView) findViewById(R.id.splash);
        CountDownTimer countDownTimer = new CountDownTimer( 5000, 1000 ) {
            @Override
            public void onTick(long l) {
                if (l > 4000) {
                    expand(ivsplash);
                }
            }
            @Override
            public void onFinish() {
                if (prefUtil.getStringValue(PrefUtil.LOGIN_STATUS).equals("1")) {
                    Intent intent = new Intent(Splashactivity.this, CategoriActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Splashactivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        countDownTimer.start();
    }
    //    //Animación para expandir una imagen
    public static void expand(final View v) {
        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), View.MeasureSpec.EXACTLY);
        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec);
        final int targetWidth = v.getMeasuredWidth();
        v.getLayoutParams().width = 1;
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.setVisibility(View.VISIBLE);
                v.getLayoutParams().width = interpolatedTime == 1 ? ViewGroup.LayoutParams.MATCH_PARENT : (int)(targetWidth * interpolatedTime );
                v.requestLayout();
            }
            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration((int)(targetWidth / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(animation);
    }
}