
```
NumGo是对0~1在一段时间内的变化进行监听的数值生成器(支持插值器)，可以根据这些数值实现动画。
```


#### 简单使用：让textView旋转360度动画
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
![简单使用效果](https://img-blog.csdn.net/20180709094654773?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwNDQ3MjYz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
#### 基本使用
```
        NumGo numGo = new NumGo(true, 5, 1000);
///////////用构造函数，等价下面三句////////////////////////////
//        numGo.setReverse(true);//0-->1--|1-->0        ///
//        //numGo.setReverse(false);//0-->1--|0-->1    ///
//        //设置时间                                   ///
//        numGo.setRepeatCount(5);                   ///
//        //设置重复方式 是否是回返式，及0~1后再1~0     ///             
//        numGo.setTime(10000);                   ///
//        //设置重复次数 -1无限重复                 ///

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
![基本使用效果](https://img-blog.csdn.net/20180709093550491?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwNDQ3MjYz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)