package com.fitucab.ventanasmoduloactividades;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegistrarActividad extends AppCompatActivity {

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_actividad);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mTabLayout.addTab(mTabLayout.newTab().setText("Auomático"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Manual"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }


}
