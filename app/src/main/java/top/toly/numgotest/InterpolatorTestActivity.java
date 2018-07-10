package top.toly.numgotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.toly.num_go.NumGo;
import top.toly.num_go.interpolator.A_Sin_Inter;
import top.toly.num_go.interpolator.A_X2_Inter;
import top.toly.num_go.interpolator.D_Sin_Inter;
import top.toly.num_go.interpolator.D_X2_Inter;

public class InterpolatorTestActivity extends AppCompatActivity {

    @BindView(R.id.sinD)
    TextView mSinD;
    @BindView(R.id.sinA)
    TextView mSinA;
    @BindView(R.id.xD)
    TextView mXD;
    @BindView(R.id.xA)
    TextView mXA;
    @BindView(R.id.start)
    Button mStart;
    private NumGo mNumGo1;
    private NumGo mNumGo2;
    private NumGo mNumGo3;
    private NumGo mNumGo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNumGo1 = new NumGo();
        mNumGo1.setInterpolator(new D_Sin_Inter());
        mNumGo1.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mSinD.setTranslationY(-1200 * rate);
            }
        });

        mNumGo2 = new NumGo();
        mNumGo2.setInterpolator(new A_Sin_Inter());
        mNumGo2.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mSinA.setTranslationY(-1200 * rate);
            }
        });

        mNumGo3 = new NumGo();
        mNumGo3.setInterpolator(new D_X2_Inter());
        mNumGo3.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mXD.setTranslationY(-1200 * rate);
            }
        });

        mNumGo4 = new NumGo();
        mNumGo4.setInterpolator(new A_X2_Inter());
        mNumGo4.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mXA.setTranslationY(-1200 * rate);
            }
        });
    }


    @OnClick(R.id.start)
    public void onViewClicked() {
        mNumGo1.go();
        mNumGo2.go();
        mNumGo3.go();
        mNumGo4.go(2000);
    }
}
