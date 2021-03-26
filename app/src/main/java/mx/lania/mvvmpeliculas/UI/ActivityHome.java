package mx.lania.mvvmpeliculas.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lania.mvvmpeliculas.R;
import mx.lania.mvvmpeliculas.UI.adapters.AdapterFragment;

public class ActivityHome extends AppCompatActivity {

    @BindView(R.id.tabLayoutPelicula)
    TabLayout tabLayoutPelicula;

    @BindView(R.id.viewPagerPelicula)
    ViewPager viewPagerPelicula;

    AdapterFragment adapterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        tabLayoutPelicula.addTab(tabLayoutPelicula.newTab().setText("Peliculas")); //titulo pestaña
        tabLayoutPelicula.addTab(tabLayoutPelicula.newTab().setText("Ubicación")); //titulo pestaña
        tabLayoutPelicula.setTabGravity(TabLayout.GRAVITY_FILL); //esto es para colorear la pestaña activa}

        // adapter fragment
        adapterFragment = new AdapterFragment(getSupportFragmentManager(),tabLayoutPelicula.getTabCount());

        viewPagerPelicula.setAdapter(adapterFragment); //se le asigna el adapterFragment al viewPager
        viewPagerPelicula.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutPelicula));

        tabLayoutPelicula.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerPelicula.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        getSupportActionBar().setTitle("PELICULA");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("UBICACION");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

}
