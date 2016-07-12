package com.example.a41665767.tp3;
import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageButton;
import java.util.Random;

/**
 * Created by 41665767 on 28/6/2016.
 */
public class GameButton extends ImageButton {
    public boolean checked;
    Random random;

    public GameButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        random = new Random();
        this.checked = random.nextBoolean();
        pintar();
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private void pintar() {
        if(checked) {
            this.setImageResource(R.mipmap.coco);
        }else{
            this.setImageResource(R.mipmap.turbina);
        }
    }

    public void flip()
    {
        checked = !checked;
        pintar();
    }

    public void reset(){
        this.checked = random.nextBoolean();
        pintar();
    }
}
