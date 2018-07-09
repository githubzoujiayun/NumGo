package top.toly.numgotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import top.toly.num_go.NumGo;
import top.toly.num_go.interpolator.D_X2_Inter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity1";
    private TextView mId_tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mId_tv_hello = findViewById(R.id.sinD);

        NumGo numGo = new NumGo(true, 0, 5000);

///////////用构造函数，等价下面三句////////////////////////////
//        numGo.setReverse(true);//0-->1--|1-->0        ///
//        //numGo.setReverse(false);//0-->1--|0-->1    ///
//        //设置时间                                   ///
//        numGo.setRepeatCount(5);                   ///
//        //设置重复方式 是否是回返式，及0~1后再1~0     ///
//        numGo.setTime(10000);                   ///
//        //设置重复次数 -1无限重复                 ///


        numGo.setInterpolator(new D_X2_Inter());

        //更新时监听
        numGo.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                Log.d(TAG, "onUpdate: " + rate);
                mId_tv_hello.setTranslationY(-600 * rate);
            }
        });
        //停止时监听
        numGo.setOnStop(new NumGo.OnStop() {
            @Override
            public void onStop() {
                mId_tv_hello.setText("I was Stopped");
            }
        });
        //重复时监听
        numGo.setOnRepeat(new NumGo.OnRepeat() {
            @Override
            public void onRepeat(int count) {
                mId_tv_hello.setText(mId_tv_hello.getText() + ":" + count);

            }
        });

        numGo.go();//运行
//        numGo.end();//停止
    }
}
