package com.fitucab.ventanasmoduloactividades;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import layout.fragments_actividades.ActividadAutomatica;
import layout.fragments_actividades.ActividadManual;

public class RegistrarActividad extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdater;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTansaction;
    private ActividadAutomatica mActividadAutomatica;
    private ActividadManual mActividadManual;
    private Fragment mFragmentSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_actividad);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText("Auomático"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Manual"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mActividadAutomatica = new ActividadAutomatica();
        mActividadManual = new ActividadManual();
        mFragmentSeleccionado = new Fragment();

        //Initializing viewPager
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mFragmentManager = getFragmentManager();
        mFragmentTansaction = mFragmentManager.beginTransaction();
        mFragmentTansaction.add(R.id.actividad_layout,mActividadAutomatica).commit();


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        mViewPager.setCurrentItem(tab.getPosition());

        Log.d("CASE","CASE");

        switch (tab.getPosition()) {
            case 1:mFragmentSeleccionado = mActividadAutomatica;
                Log.d("CASE","AUTOMATICA");
                break;
            case 2:
                mFragmentSeleccionado = mActividadManual;
                Log.d("CASE","MANUAL");
                break;
        }

        mFragmentTansaction = mFragmentManager.beginTransaction();
        mFragmentTansaction.replace(R.id.actividad_layout,mFragmentSeleccionado).commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }



}
