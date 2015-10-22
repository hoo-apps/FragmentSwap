package edu.hooapps.android.fragmentswap;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public interface OnFragmentButtonClickedListener {
        void onFragmentButtonClicked();
    }
    private OnFragmentButtonClickedListener fragmentButtonClickedListener;

    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.fragmentButtonClickedListener = (OnFragmentButtonClickedListener) activity;
        } catch (ClassCastException e) {
            // TODO HANDLE ERROR HERE
            Log.e("Frag", "Activity must implement OnFragmentButtonClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        Button swapButton = (Button) rootView.findViewById(R.id.swap_button);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragments();
            }
        });

        return rootView;
    }

    private void swapFragments() {
        this.fragmentButtonClickedListener.onFragmentButtonClicked();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new BlankFragment());
        ft.commit();
    }
}
