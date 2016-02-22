package jp.gr.java_conf.myoshii.android.fragmenttransitiontest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends Fragment {
    private static final String TAG = FragmentA.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, null);

        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText("Fragment A");

        Resources resources = getResources();
        int color = resources.getColor(android.R.color.holo_red_light);
        textView.setBackgroundColor(color);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FragmentB へ遷移
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction xact = fragmentManager.beginTransaction();

                Fragment fragment = new FragmentB();
                xact.replace(R.id.fragment_area, fragment, "FragmentB");
                xact.addToBackStack(null);

                xact.commit();

                Log.d(TAG, "A --> B");
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }
}
