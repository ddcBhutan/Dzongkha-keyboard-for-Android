package com.ddc.dzongkhakeyboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.os.Build;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.RequiresApi;
public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private DzongkhaKeyboardView keyboardView;
    private Keyboard dzongkha_keyboard_normal;
    private Keyboard dzongkha_keyboard_shift;
    private Keyboard english_keyboard_normal;
    private Keyboard english_keyboard_shift;
    private Keyboard symKeyboard1;
    private Keyboard symKeyboard2;
    private Keyboard keypad;
    private Keyboard engSym1;
    private Keyboard engSym2;
    private Keyboard emoji;
    Vibrator v;
    AudioManager am;
    private boolean sym1;
    private boolean sym2;
    private static final float SOUND_VOLUME = 500.0F;
    private static final int VIBRATION_TIME = 40;
    private String THEME_KEY = "theme_key";
    private static final String SOUND_KEY = "sound_key";
    private static final String VIBRATION_KEY = "vibration_key";
    private static final String DEFAULT_KEYBOARD = "default_keyboard";
    // when default keyboard is true it means to make dzongkha as default keyboard
    // when the keyboard is opened for the first time;
    private boolean vibrate;
    private boolean sound;
    private boolean changeShift;


    int [] THEMES = {
            R.layout.keyboard_view_light, R.layout.keyboard_view_dark
    };
    SharedPreferences sharedPreferences;



    private Keyboard keyboard;
    private boolean shift = false;
    private boolean caps = false;
    private boolean dzo;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        sym1 = false;
        sym2 = false;
        changeShift = true;


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override public void onInitializeInterface() {

        dzongkha_keyboard_normal = new Keyboard(this, R.xml.dzongkha_keyboard_normal);
        dzongkha_keyboard_shift = new Keyboard(this, R.xml.dzongkha_keyboard_shift);
        english_keyboard_normal = new Keyboard(this, R.xml.english_keyboard_normal);
        english_keyboard_shift = new Keyboard(this, R.xml.english_keyboard_shift);
        symKeyboard1 = new Keyboard(this, R.xml.sym1);
        symKeyboard2 = new Keyboard(this, R.xml.sym2);
        engSym1 = new Keyboard(this, R.xml.eng_symbols);
        engSym2 = new Keyboard(this, R.xml.eng_symbol2);
        keypad = new Keyboard(this,R.xml.keypad);
        emoji = new Keyboard(this,R.xml.emoji);
        // this is the initialization of all the keyboard layouts that has been created in xml folder;

    }
    @Override public View onCreateInputView() {
        sound = sharedPreferences.getBoolean(SOUND_KEY, false);
        vibrate = sharedPreferences.getBoolean(VIBRATION_KEY,false);

        keyboardView = (DzongkhaKeyboardView) getLayoutInflater().inflate(THEMES[sharedPreferences.getInt(THEME_KEY, 0)], null);
        // initialization of keyboard theme from shared preference;

        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }
    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInput(attribute, restarting);

        // Restart the InputView to apply right theme selected.
        setInputView(onCreateInputView());

        switch (attribute.inputType & InputType.TYPE_MASK_CLASS) {// selecting keyboard layout based on the typeclass
            case InputType.TYPE_CLASS_NUMBER:
                keyboard = keypad;
                keyboardView.setKeyboard(keyboard);
                changeShift = false;
                break;
            default:
                if(sharedPreferences.getBoolean(DEFAULT_KEYBOARD,false)){
                    keyboard = dzongkha_keyboard_normal;
                    dzo = true;
                    shift = false;

                }
                else{
                    keyboard = english_keyboard_shift;
                    shift = true;
                    dzo = false;

                }
                changeShift = true;

                keyboardView.setKeyboard(keyboard);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

           if(keyCode == KeyEvent.KEYCODE_ENTER){
               return false;// let underlying class handle the enter key
           }


           else{
               return super.onKeyDown(keyCode, event);

           }

    }

    @Override
    public void onPress(int primaryCode) {// removing keypreview from function and menu keys;
        if(primaryCode == -5||primaryCode == -21||primaryCode == -22||primaryCode == -23||primaryCode == -24||primaryCode == -12||primaryCode == -14||
                primaryCode == -11||primaryCode == -4||primaryCode == -26||primaryCode == -70||primaryCode == -16||primaryCode == 32||
                primaryCode == -18||primaryCode == -17||primaryCode == -9||primaryCode == -15){
            keyboardView.setPreviewEnabled(false);

        }
        else{
            keyboardView.setPreviewEnabled(true);
        }


    }

    @Override
    public void onRelease(int primaryCode) {


    }



    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        if(primaryCode!=-5 && primaryCode != -70){//removing sound and vibration from backspace emoji backspace and space keys
            if(vibrate){
                v.vibrate(VIBRATION_TIME);

            }
            if(sound){
                am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD,SOUND_VOLUME);
            }
        }


        InputConnection inputConnection = getCurrentInputConnection();

            switch(primaryCode) {
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                    break;
                case Keyboard.KEYCODE_DONE:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case -70:
                    CharSequence selectedText1 = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText1)) {
                        inputConnection.deleteSurroundingText(2, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                    break;
                case -21:
                    keyboard = emoji;
                    keyboardView.setKeyboard(keyboard);
                    //inputConnection.commitText("\uD83D\uDE05 ", 1);
                    break;
                case -22:
                    ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .showInputMethodPicker();

                    break;
                case -23:
                    if(sharedPreferences.getBoolean(DEFAULT_KEYBOARD,false)){
                        Intent dialogIntent2 = new Intent(this, Setting_dzo.class);
                        dialogIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dialogIntent2);

                        break;

                    }
                    else{
                        Intent dialogIntent2 = new Intent(this, Setting.class);
                        dialogIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dialogIntent2);
                        break;

                    }


                case -24:
                    requestHideSelf(0);
                    break;
                case -26:
                    keyboard = english_keyboard_normal;
                    keyboardView.setKeyboard(keyboard);
                    //inputConnection.commitText("\uD83D\uDE05 ", 1);
                    break;
                case -31:
                    inputConnection.commitText("\uD83D\uDE02", 1);
                    break;//😂
                case -32:
                    inputConnection.commitText("\uD83E\uDD14", 1);
                    break;//🤔
                case -33:
                    inputConnection.commitText("\uD83D\uDE05", 1);
                    break;//😅
                case -34:
                    inputConnection.commitText("\uD83D\uDE06", 1);
                    break;//😆
                case -35:
                    inputConnection.commitText("\uD83D\uDE22", 1);
                    break;//😢
                case -36:
                    inputConnection.commitText("\uD83D\uDE0E", 1);
                    break;//😎
                case -37:
                    inputConnection.commitText("\uD83D\uDE21", 1);
                    break;//😡
                case -38:
                    inputConnection.commitText("\uD83D\uDE34", 1);
                    break;//😴
                case -39:
                    inputConnection.commitText("\uD83D\uDC7A", 1);
                    break;//👺
                case -40:
                    inputConnection.commitText("\uD83D\uDC7F", 1);
                    break;//👿
                case -41:
                    inputConnection.commitText("\uD83D\uDE4F", 1);
                    break;//🙏
                case -42:
                    inputConnection.commitText("\uD83D\uDC4D", 1);
                    break;//👍
                case -43:
                    inputConnection.commitText("\uD83D\uDC8B", 1);
                    break;//💋
                case -44:
                    inputConnection.commitText("\uD83D\uDC40", 1);
                    break;//👀
                case -45:
                    inputConnection.commitText("\uD83D\uDC36", 1);
                    break;//🐶
                case -46:
                    inputConnection.commitText("❤️", 1);
                    break;//❤️
                case -47:
                    inputConnection.commitText("\uD83D\uDC9A", 1);
                    break;//💚
                case -48:
                    inputConnection.commitText("\uD83D\uDC94", 1);
                    break;//💔
                case -49:
                    inputConnection.commitText("\uD83D\uDC93", 1);
                    break;//💓
                case -50:
                    inputConnection.commitText("\uD83D\uDD25", 1);
                    break;//🔥
                case -51:
                    inputConnection.commitText("\uD83D\uDE3A", 1);
                    break;//😺
                case -52:
                    inputConnection.commitText("\uD83C\uDF83", 1);
                    break;//🎃
                case -53:
                    inputConnection.commitText("\uD83D\uDE09", 1);
                    break;//😉
                case -54:
                    inputConnection.commitText("\uD83D\uDE18", 1);
                    break;//😘
                case -55:
                    inputConnection.commitText("\uD83C\uDDE7\uD83C\uDDF9", 1);
                    break;//🇧🇹
                case -56:
                    inputConnection.commitText("\uD83C\uDF82", 1);
                    break;//🎂
                case -57:
                    inputConnection.commitText("\uD83D\uDC4F", 1);
                    break;//👏
                case -58:
                    inputConnection.commitText("\uD83D\uDCA9", 1);
                    break;//💩
                case -59:
                    inputConnection.commitText("\uD83D\uDE03",1);
                    break;//😃
                case -60:
                    inputConnection.commitText("\uD83D\uDC4C",1);
                    break;//👌
                case -61:
                    inputConnection.commitText("\uD83D\uDE2D",1);
                    break;//😭
                case -14:

                        keyboard = symKeyboard1;
                        keyboardView.setKeyboard(keyboard);
                        sym1 = true;
                    break;
                case -16:
                    keyboard = english_keyboard_normal;
                    keyboardView.setKeyboard(keyboard);

                    break;

                case -15:

                        keyboard = symKeyboard2;
                        keyboardView.setKeyboard(keyboard);
                        sym2 = true;

                    break;
                case -17:

                    keyboard = engSym1;
                    keyboardView.setKeyboard(keyboard);
                    sym2 = true;

                    break;
                case -18:

                    keyboard = engSym2;
                    keyboardView.setKeyboard(keyboard);
                    sym2 = true;

                    break;

                case -9:
                    keyboard = dzongkha_keyboard_normal;
                    keyboardView.setKeyboard(keyboard);
                    dzo = true;

                    break;

                case -11:

                    if(dzo) {
                        keyboard = english_keyboard_normal;
                        keyboardView.setKeyboard(keyboard);
                        dzo=false;
                        break;

                    }
                    else{
                        keyboard = dzongkha_keyboard_normal;
                        keyboardView.setKeyboard(keyboard);
                        dzo = true;

                    }
                    break;
                case -12:
                    if(shift){
                        clearShiftMode();
                        break;
                    }
                    shift = true;
                    if(dzo){
                        keyboard = dzongkha_keyboard_shift;
                        keyboardView.setKeyboard(keyboard);
                        break;

                    }
                    else{
                        keyboard = english_keyboard_shift;
                        keyboardView.setKeyboard(keyboard);

                    }
                    break;
                default :
                    char code = (char) primaryCode;
                    if(Character.isLetter(code) && caps){
                        code = Character.toUpperCase(code);
                    }
                    inputConnection.commitText(String.valueOf(code), 1);
                    clearShiftMode();


            }
        }

    public void clearShiftMode(){// clear shift mode after one character is typed
        if(changeShift){
            if(shift){
                if(dzo){
                    keyboard = dzongkha_keyboard_normal;

                    keyboardView.setKeyboard(keyboard);

                }
                else{

                    keyboard = english_keyboard_normal;
                    keyboardView.setKeyboard(keyboard);
                    dzo=false;

                }
                shift = false;
            }
        }
    }


    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {


    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
