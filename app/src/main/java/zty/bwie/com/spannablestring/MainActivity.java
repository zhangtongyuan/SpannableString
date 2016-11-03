package zty.bwie.com.spannablestring;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        setTv1();
    }

    //SpannableString文本类
    private void setTv1() {
        //SpannableString文本类，包含不可变的文本但可以用已有对象替换和分离。
        //可变文本类参考SpannableStringBuilder
        SpannableString ss = new SpannableString("红色字体超链接黄色下划线删除线绝对大小亮红亮黄.粗体x轴缩放TypefaceSpan文本字体张桐源");

        System.out.println("length:" + ss.length());
        //不同的Span类 参考http://www.cnblogs.com/jisheng/archive/2013/01/10/2854088.html

        //用颜色标记文本
        ss.setSpan(new ForegroundColorSpan(Color.RED), 0, 2,
                //setSpan时需要指定的 flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括).
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用超链接标记文本
        ss.setSpan(new URLSpan("http://www.baidu.com"), 4, 7,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用样式标记文本（斜体）
        ss.setSpan(new StyleSpan(Typeface.ITALIC), 5, 7,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用删除线标记文本
        ss.setSpan(new StrikethroughSpan(), 12, 15,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用下划线标记文本
        ss.setSpan(new UnderlineSpan(), 9, 12,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用颜色标记
        ss.setSpan(new ForegroundColorSpan(Color.YELLOW), 7, 9,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 绝对大小（文本字体）
        ss.setSpan(new AbsoluteSizeSpan(100), 15, 19,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置高亮样式一
        ss.setSpan(new BackgroundColorSpan(Color.RED), 19, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置高亮样式二
        ss.setSpan(new ForegroundColorSpan(Color.YELLOW), 21, 23, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //设置TextView可点击
        //用ImageSpan替换文本
        //获取Drawable资源
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        //创建ImageSpan
        ImageSpan saa = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        //用ImageSpan替换文本
        ss.setSpan(saa, 23, 24, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        //粗体
        ss.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 24, 26,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        //基于x轴缩放
        ss.setSpan(new ScaleXSpan(3.8f), 26, 30, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //TypefaceSpan 文本字体
        ss.setSpan(new TypefaceSpan("monospace"), 30, 46,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        //TextAppearanceSpan 文本外貌（包括字体、大小、样式和颜色）
        ss.setSpan(new TextAppearanceSpan(this, android.R.style.TextAppearance),
                46, 49, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv1.setMovementMethod(LinkMovementMethod.getInstance()); //实现文本的滚动
        tv1.setText(ss);

    }
}
