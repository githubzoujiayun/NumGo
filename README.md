
```
NumGo是对0~1在一段时间内的变化进行监听的数值生成器(支持插值器)，可以根据这些数值实现动画。
```


#### 一：简单使用：让textView旋转360度动画
```
 mId_tv_hello = findViewById(R.id.id_tv_hello);
```

```
    new NumGo().setOnUpdate(new NumGo.OnUpdate() {
        @Override
        public void onUpdate(float rate) {
            mId_tv_hello.setRotation(rate *360);
        }
    }).go();
```
![简单使用效果](https://user-gold-cdn.xitu.io/2018/7/9/1647d163eb062848?imageslim)
#### 二：基本使用
```
        NumGo numGo = new NumGo(true, 5, 1000);
///////////用构造函数，等价下面三句////////////////////////////
//		 //设置重复方式 是否是回返式，及0~1后再1~0		///
//        numGo.setReverse(true);//0-->1--|1-->0       ///
//        //numGo.setReverse(false);//0-->1--|0-->1   ///
//        //设置重复次数 -1无限重复                  ///
//        numGo.setRepeatCount(5);                  ///
//        //设置时间							   ///
//        numGo.setTime(10000);                   ///

        //更新时监听
        numGo.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mId_tv_hello.setTranslationX(100 * rate);
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
```
![基本使用效果](https://user-gold-cdn.xitu.io/2018/7/9/1647d15b87de390c?imageslim)


---
#### 三：插值器使用：目前定义四个简单的插值器
>使用
```
mNumGo1.setInterpolator(new D_Sin_Inter())
```
![下面四种插值器效果比较](https://user-gold-cdn.xitu.io/2018/7/9/1647d2e090b10e17?w=300&h=529&f=gif&s=591751)
>sin式减速
```
        mNumGo1 = new NumGo();
        mNumGo1.setInterpolator(new D_Sin_Inter());
        mNumGo1.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mSinD.setTranslationY(-1200 * rate);
            }
        });
```
>sin式加速
```
        mNumGo2 = new NumGo();
        mNumGo2.setInterpolator(new A_Sin_Inter());
        mNumGo2.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mSinA.setTranslationY(-1200 * rate);
            }
        });
```
>x平方式减速：

```
        mNumGo3 = new NumGo();
        mNumGo3.setInterpolator(new D_X2_Inter());
        mNumGo3.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mXD.setTranslationY(-1200 * rate);
            }
        });
```
>x平方式加速：
```
        mNumGo4 = new NumGo();
        mNumGo4.setInterpolator(new A_X2_Inter());
        mNumGo4.setOnUpdate(new NumGo.OnUpdate() {
            @Override
            public void onUpdate(float rate) {
                mXA.setTranslationY(-1200 * rate);
            }
        });
```
>运行：

```
    @OnClick(R.id.start)
    public void onViewClicked() {
        mNumGo1.go();
        mNumGo2.go();
        mNumGo3.go();
        mNumGo4.go();
    }
```
