# AndroidAnimateLayoutChanges

##1： `android:animateLayoutChanges="true"` layout     默认 layout 动画 就可在 布局中设置 `android:animateLayoutChanges="true"` 
  
  ```Java
  <LinearLayout
        android:id="@+id/ll_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:animateLayoutChanges="true"
        android:orientation="vertical">
        
    </LinearLayout>
  ```
  
  
  
  ```Java 
     Button button = new Button(MainActivity.this);
            button.setText("" + new Random().nextInt(100));
            mLinearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mLinearLayout.removeView(view);
                }
            });
  ```
  
  
     
   ![](https://github.com/SomnusWu/AndroidAnimateLayoutChanges/blob/master/layout_default.gif)  
  
  
  
##2: layout  自定义动画 

```Java
        LayoutTransition mTransitioner = new LayoutTransition();
        //入场动画:view在这个容器中消失时触发的动画
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f, 0f);
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animIn);

        //出场动画:view显示时的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);
```

#### 设置给 Layout 
```Java
          //自定义动画
            Button button = new Button(MainActivity.this);
            button.setText("" + new Random().nextInt(100));
            mll_layout_01.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mll_layout_01.removeView(view);
                }
            });

            mll_layout_01.setLayoutTransition(mTransitioner);
```
![](https://github.com/SomnusWu/AndroidAnimateLayoutChanges/blob/master/layout_custom.gif)  


##3：`clipChildren` 作用  

* 1、只需在根节点设置android:clipChildren为false即可，默认为true</br>
* 2、可以通过android:layout_gravity控制超出的部分如何显示。</br>
* 3、android:clipChildren的意思：是否限制子View在其范围内</br>
* 








