package david.examen1eva;

/**
 * Created by david.carabel on 20/12/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrimeraActivity extends AppCompatActivity {

    @BindView(R.id.fragment_frame_layout)
    FrameLayout fragmentFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera);
        ButterKnife.bind(this);

        FragmentLogin loginFragment = new FragmentLogin();

        addFragmentToLayout(loginFragment);
    }

    private void addFragmentToLayout(Fragment fragment) {


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_frame_layout, fragment);
        transaction.commit();
    }

    public void replaceFragmentToLayout(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_frame_layout, fragment);
        transaction.commit();
    }

}