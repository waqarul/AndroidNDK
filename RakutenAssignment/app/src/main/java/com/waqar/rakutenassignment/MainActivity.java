package com.waqar.rakutenassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    // views
    @BindView(R.id.tv_result) TextView tvResult;


    @OnClick(R.id.btn_increment)
    public void onIncrementClicked(View view){

        int currentValue = 0; // hold current value of text view

        // check if there is nothing in text view, else place the textview value
        if (TextUtils.isEmpty(tvResult.getText().toString()))
            currentValue = 0;
        else
            currentValue = Integer.valueOf(tvResult.getText().toString());

        // call a native method
        tvResult.setText(countUpFromJNI(currentValue));


        // another way to count up
        //        tvResult.setText(""+countUpFromJNIShortVersion(currentValue));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding with butterknife
        ButterKnife.bind(this);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String countUpFromJNI(int value);

    // this method is also used to get incremented value from jni
    public native long countUpFromJNIShortVersion(int value);
}
