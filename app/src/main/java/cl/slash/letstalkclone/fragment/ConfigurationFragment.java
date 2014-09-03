package cl.slash.letstalkclone.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 02-09-14.
 */
public class ConfigurationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup)inflater.inflate(R.layout.fragment_configuration, null);
        return container;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
