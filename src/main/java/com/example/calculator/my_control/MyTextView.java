package com.example.calculator.my_control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
自定义组件：带有边框的标签
 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    Paint paint = new Paint();//创建一个paint对象

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);//构造函数
    }

    @Override//重写方法
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);//设置paint的颜色

        //绘制边框
        canvas.drawLine(0,0,this.getWidth(),0,paint);//绘制上方的边框
        canvas.drawLine(0,this.getHeight(),this.getWidth(),this.getHeight(),paint);//绘制下方的边框(因为会被遮挡，所以需要-1）
        canvas.drawLine(0,0,0,this.getHeight(),paint);//绘制左边的边框
        canvas.drawLine(this.getWidth(),0,this.getWidth(),this.getHeight(),paint);//绘制右边的边框(因为会被遮挡，所以需要-1）

    }


}
