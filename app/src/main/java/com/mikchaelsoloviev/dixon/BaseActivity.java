package com.mikchaelsoloviev.dixon;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by USER on 26.10.2015.
 */
public class  BaseActivity <T> extends AppCompatActivity {
    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
