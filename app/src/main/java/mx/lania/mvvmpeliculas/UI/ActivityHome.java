package mx.lania.mvvmpeliculas.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

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

        // ¿Existe un usuario logueado?
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }


        tabLayoutPelicula.addTab(tabLayoutPelicula.newTab().setText("Peliculas")); //titulo pestaña
        tabLayoutPelicula.addTab(tabLayoutPelicula.newTab().setText("Ubicación")); //titulo pestaña
        tabLayoutPelicula.addTab(tabLayoutPelicula.newTab().setText("Notificaciones")); //titulo pestaña
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
                    case 2:
                        getSupportActionBar().setTitle("NOTIFICACIONES");
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
