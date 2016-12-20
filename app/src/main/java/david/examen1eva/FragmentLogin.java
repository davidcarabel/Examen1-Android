package david.examen1eva;

/**
 * Created by david.carabel on 20/12/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import david.library.QBAdmin;


public class FragmentLogin extends Fragment {

    @BindView(R.id.etUsuario)
    EditText etUsuario;
    @BindView(R.id.etPassword)
    EditText etPassword;

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);

        crearSesionQuickblox();

        return root;
    }

    private void crearSesionQuickblox() {
        QBAdmin qbAdmin = new QBAdmin(new Quickblox(), getContext());

    }

    @OnClick(R.id.btnEntrar)
    void login() {

        String user = etUsuario.getText().toString();
        String pass = etPassword.getText().toString();

        //Validacion de Input
        if (user.length() < 4) {
            //Avisar al usuario de que el nombre introducido no tiene la longitud suficiente
        }
        if (pass.length() < 6) {
            //Avisar al usuario de que la contraseña introducida no tiene longitud suficiente
        }


        QBUser qbUser = new QBUser(user, pass);

        QBUsers.signIn(qbUser, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                Toast.makeText(getContext(), "Logeado con exito!", Toast.LENGTH_SHORT).show();
                //Cambiar a actividad Main
                Intent successLoginIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(successLoginIntent);
            }

            @Override
            public void onError(QBResponseException errors) {
                Toast.makeText(getContext(), "Fallo!!!!!!", Toast.LENGTH_SHORT).show();
                //Cambiar EditText de color o algo
            }
        });

    }

    @OnClick(R.id.btnRegistro)
    void registro() {
        FragmentRegistro fragmentRegistro = new FragmentRegistro();

        PrimeraActivity activity = (PrimeraActivity) getActivity();
        activity.replaceFragmentToLayout(fragmentRegistro);
    }


}