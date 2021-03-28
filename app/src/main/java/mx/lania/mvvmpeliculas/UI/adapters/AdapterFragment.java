package mx.lania.mvvmpeliculas.UI.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import mx.lania.mvvmpeliculas.UI.fragments.FragmentNotificaciones;
import mx.lania.mvvmpeliculas.UI.fragments.FragmentPelicula;
import mx.lania.mvvmpeliculas.UI.fragments.FragmentUbicacion;
import mx.lania.mvvmpeliculas.UI.fragments.PushNotificationsFragment;

public class AdapterFragment extends FragmentPagerAdapter {
    private int numberOfTabs;

    public AdapterFragment(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numberOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentPelicula();
            case 1:
                return new FragmentUbicacion();
            case 2:
                return new PushNotificationsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}