package david.examen1eva;

/**
 * Created by david.carabel on 20/12/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentNoticias extends Fragment {


    @BindView(R.id.listViewNoticias)
    ListView listViewNoticias;

    final ArrayList<String> categorias = new ArrayList<>();

    public FragmentNoticias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_noticias, container, false);
        ButterKnife.bind(this, root);

        cargarCategorias();

        return root;
    }

    private void cargarCategorias() {

    }

}