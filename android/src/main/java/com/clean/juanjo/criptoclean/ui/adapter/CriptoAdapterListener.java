package com.clean.juanjo.criptoclean.ui.adapter;

import android.view.View;

/**
 * Created by juanj on 17/01/2018.
 */

public interface CriptoAdapterListener {
    void onClick(View view,int position);
    void onLongClick(View view,int position);
}