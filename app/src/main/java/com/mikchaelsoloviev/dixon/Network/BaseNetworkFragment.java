package com.mikchaelsoloviev.dixon.Network;

import android.support.v4.app.Fragment;

/**
 * Created by USER on 24.10.2015.
 */
public class BaseNetworkFragment <T> extends Fragment {
    T data;
    public  T getData (){
        return data;
    }
    public  void loadData(){

    }
}
