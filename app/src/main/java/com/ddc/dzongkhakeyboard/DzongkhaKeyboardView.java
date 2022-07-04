package com.ddc.dzongkhakeyboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.preference.PreferenceManager;
import android.util.AttributeSet;


import java.util.List;

public class DzongkhaKeyboardView extends KeyboardView {
    SharedPreferences sharedPreferences;

    public DzongkhaKeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);


    }

    public DzongkhaKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }





    @Override
    public void onDraw(Canvas canvas) {

        Paint paint = new Paint();

        int theme = sharedPreferences.getInt("theme_key", 0);


        super.onDraw(canvas);

        Paint paint2 = new Paint();

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(getResources().getDimension(R.dimen.canvasTextSize));

        paint.setColor(getResources().getColor(R.color.popupKeyColor));
        paint2.setColor(getResources().getColor(R.color.white200));

        

        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {
            if (key.label != null) {
// drawing the superscript characters on english keyboard;
                if (key.label.toString().equals("q") || key.label.toString().equals("Q") )
                    canvas.drawText("+", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if ((key.codes[0] == 'w' || key.codes[0] == 'W'))
                    canvas.drawText("x", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("e") || key.label.toString().equals("E") )
                    canvas.drawText("÷", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("r") || key.label.toString().equals("R") )
                    canvas.drawText("=", key.x + (key.width*7)/10 , key.y + (key.height*3)/10 , paint);

                else if (key.label.toString().equals("t") || key.label.toString().equals("T") )
                    canvas.drawText("/", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("y") || key.label.toString().equals("Y") )
                    canvas.drawText("-", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("u") || key.label.toString().equals("U") )
                    canvas.drawText("<", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("i") || key.label.toString().equals("I") )
                    canvas.drawText(">", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("o") || key.label.toString().equals("O") )
                    canvas.drawText("[", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("p") || key.label.toString().equals("P") )
                    canvas.drawText("]", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                if (key.label.toString().equals("a") || key.label.toString().equals("A") )
                    canvas.drawText("!", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if ((key.codes[0] == 's' || key.codes[0] == 'S'))
                    canvas.drawText("@", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("d") || key.label.toString().equals("D") )
                    canvas.drawText("#", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("f") || key.label.toString().equals("F") )
                    canvas.drawText("%", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("g") || key.label.toString().equals("G") )
                    canvas.drawText("^", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("h") || key.label.toString().equals("H") )
                    canvas.drawText("&", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("j") || key.label.toString().equals("J") )
                    canvas.drawText("*", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("k") || key.label.toString().equals("K") )
                    canvas.drawText("(", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("L") || key.label.toString().equals("l") )
                    canvas.drawText(")", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("z") || key.label.toString().equals("Z") )
                    canvas.drawText("_", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("x") || key.label.toString().equals("X") )
                    canvas.drawText("'", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("c") || key.label.toString().equals("C") )
                    canvas.drawText("\"", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("v") || key.label.toString().equals("V") )
                    canvas.drawText(":", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("b") || key.label.toString().equals("B") )
                    canvas.drawText(";", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("n") || key.label.toString().equals("N") )
                    canvas.drawText(",", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);

                else if (key.label.toString().equals("m") || key.label.toString().equals("M") )
                    canvas.drawText("?", key.x + (key.width*7)/10 , key.y + (key.height*3)/10, paint);



            }


// drawing the drawing icons on the menu keys ;
            if(key.codes[0] == -4 ||key.codes[0] == -12 ||key.codes[0] == -5 ||key.codes[0]==-17||key.codes[0]==-9||key.codes[0]==-14||key.codes[0]==-15||key.codes[0]==-16||key.codes[0]==-18){
               if(theme==0){
                   Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.function_keys_bg);
                   dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                   dr.draw(canvas);
               }
               else{
                   Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.function_keys_dark);
                   dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                   dr.draw(canvas);
               }
            }
            if(key.codes[0] == -21 ){

                if(theme == 0){
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_light);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_emoji);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
                else{
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_black);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_emoji);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    paint.setStrokeWidth(4);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
            }
            if(key.codes[0] == -26 ){

                if(theme == 0){
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_light);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_emoji);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
                else{
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_black);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_emoji);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    paint.setStrokeWidth(4);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
            }
            if(key.codes[0]==-22){
                if(theme == 0){
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_light);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_baseline_keyboard_24);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
                else{
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_black);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_baseline_keyboard_24);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    paint.setStrokeWidth(4);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }

            }
            if(key.codes[0]==-23){
                if(theme == 0){
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_light);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_settings);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
                else{
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_black);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_settings);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    paint.setStrokeWidth(4);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }

            }
            if(key.codes[0]==-24){
                if(theme == 0){
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_light);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_hide);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
                else{
                    Drawable dr = (Drawable) this.getResources().getDrawable(R.drawable.keyboard_bg_black);
                    dr.setBounds(key.x , key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                    Drawable dr2 = (Drawable) this.getResources().getDrawable(R.drawable.ic_hide);
                    dr2.setBounds(key.x+( key.height) , key.y+( key.height/4), key.x +( key.height*2-key.height/4), key.y+( key.height/4) + ( key.height*3/4));
                    dr2.draw(canvas);
                    paint.setStrokeWidth(4);
                    canvas.drawLine(10,key.y +key.height+(key.height/10),canvas.getWidth()-10,key.y +key.height+(key.height/10),paint2);

                }
            }
//            if(key.codes[0] == -21 ){
//                paint.setStrokeWidth(3);
//                canvas.drawLine(5,key.y +key.height-(key.height/8),canvas.getWidth()-5,key.y +key.height-(key.height/8),paint);
//

//            }
        }

    }



    @Override
    protected boolean onLongPress(Keyboard.Key key) {

        // For English keyboard long press action;

        if (key.codes[0] == 'q' || key.codes[0] == 'Q' ) {
            getOnKeyboardActionListener().onKey('+', null);
            return true;
        } else if (key.codes[0] == 'w' || key.codes[0] == 'W') {
            getOnKeyboardActionListener().onKey('x', null);
            return true;
        } else if (key.codes[0] == 'e' || key.codes[0] == 'E' ) {
            getOnKeyboardActionListener().onKey('÷', null);
            return true;
        } else if (key.codes[0] == 'r' || key.codes[0] == 'R') {
            getOnKeyboardActionListener().onKey('=', null);
            return true;
        } else if (key.codes[0] == 't' || key.codes[0] == 'T' ) {
            getOnKeyboardActionListener().onKey('/', null);
            return true;
        }
        else if (key.codes[0] == 'y' || key.codes[0] == 'Y' ) {
            getOnKeyboardActionListener().onKey('-', null);
            return true;
        } else if (key.codes[0] == 'u' || key.codes[0] == 'U' ) {
            getOnKeyboardActionListener().onKey('<', null);
            return true;
        } else if (key.codes[0] == 'i' || key.codes[0] == 'I' ) {
            getOnKeyboardActionListener().onKey('>', null);
            return true;
        } else if (key.codes[0] == 'o' || key.codes[0] == 'O' ) {
            getOnKeyboardActionListener().onKey('[', null);
            return true;
        }
        else if (key.codes[0] == 'p' || key.codes[0] == 'P' ) {
            getOnKeyboardActionListener().onKey(']', null);
            return true;
        }
        if (key.codes[0] == 'a' || key.codes[0] == 'A' ) {
                getOnKeyboardActionListener().onKey('!', null);
                return true;
        } else if (key.codes[0] == 's' || key.codes[0] == 'S') {
                getOnKeyboardActionListener().onKey('@', null);
                return true;
        } else if (key.codes[0] == 'd' || key.codes[0] == 'D' ) {
                getOnKeyboardActionListener().onKey('#', null);
                return true;
        } else if (key.codes[0] == 'f' || key.codes[0] == 'F') {
                getOnKeyboardActionListener().onKey('%', null);
                return true;
        } else if (key.codes[0] == 'g' || key.codes[0] == 'G' ) {
                getOnKeyboardActionListener().onKey('^', null);
                return true;
        } else if (key.codes[0] == 'h' || key.codes[0] == 'H' ) {
                getOnKeyboardActionListener().onKey('&', null);
                return true;
        } else if (key.codes[0] == 'j' || key.codes[0] == 'J' ) {
                getOnKeyboardActionListener().onKey('*', null);
                return true;
        } else if (key.codes[0] == 'k' || key.codes[0] == 'K' ) {
                getOnKeyboardActionListener().onKey('(', null);
                return true;
        } else if (key.codes[0] == 'l' || key.codes[0] == 'L' ) {
            getOnKeyboardActionListener().onKey(')', null);
            return true;
        }

        else if (key.codes[0] == 'z' || key.codes[0] == 'Z' ) {
                getOnKeyboardActionListener().onKey('_', null);
                return true;
        } else if (key.codes[0] == 'x' || key.codes[0] == 'X') {
                getOnKeyboardActionListener().onKey('\'', null);
                return true;
        } else if (key.codes[0] == 'c' || key.codes[0] == 'C' ) {
                getOnKeyboardActionListener().onKey('\"', null);
                return true;
        } else if (key.codes[0] == 'v' || key.codes[0] == 'V' ) {
                getOnKeyboardActionListener().onKey(':', null);
                return true;
        } else if (key.codes[0] == 'b' || key.codes[0] == 'B' ) {
                getOnKeyboardActionListener().onKey(';', null);
                return true;
        } else if (key.codes[0] == 'n' || key.codes[0] == 'N' ) {
                getOnKeyboardActionListener().onKey(',', null);
                return true;
        } else if (key.codes[0] == 'm' || key.codes[0] == 'M' ) {
                getOnKeyboardActionListener().onKey('?', null);
                return true;
        } else {
            return super.onLongPress(key);
        }
    }


}



