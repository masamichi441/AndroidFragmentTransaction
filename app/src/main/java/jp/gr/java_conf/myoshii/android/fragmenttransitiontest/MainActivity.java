package jp.gr.java_conf.myoshii.android.fragmenttransitiontest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction xact = fragmentManager.beginTransaction();

        Fragment fragment = new FragmentA();
        xact.replace(R.id.fragment_area, fragment, FragmentA.TAG);
        xact.commit();
    }

//    @Override
//    public void onBackPressed() {
//        FragmentManager fm = getFragmentManager();
//
//        // Back Stack が最後の一つになったとき、FragmentC があれば強制的に削除
//        if (fm.getBackStackEntryCount() == 1) {
//            Fragment fragment = fm.findFragmentByTag("FragmentC");
//            if (fragment != null) {
//                FragmentTransaction xact = fm.beginTransaction();
//                xact.remove(fragment);
//                xact.commit();
//            }
//        }
//
//        super.onBackPressed();
//    }

}
