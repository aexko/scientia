package ca.qc.bdeb.c5gm.fragment101.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.qc.bdeb.c5gm.fragment101.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment1 #newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment1 extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }
}