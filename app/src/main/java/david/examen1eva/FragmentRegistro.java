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
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRegistro extends Fragment {

    @BindView(R.id.etUsuario)
    EditText etUsuario;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.etRepeatPassword)
    EditText etRepeatPassword;


    public FragmentRegistro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @OnClick(R.id.btnVolver)
    void volver() {
        FragmentLogin fragmentLogin = new FragmentLogin();

        PrimeraActivity activity = (PrimeraActivity) getActivity();
        activity.replaceFragmentToLayout(fragmentLogin);
    }

    @OnClick(R.id.btnRegistro)
    void registro() {
        String user = etUsuario.getText().toString();
        String pass = etPassword.getText().toString();
        String rPass = etRepeatPassword.getText().toString();

        if (pass.equals(rPass)) {
            QBUser qbUser = new QBUser(user, pass);

            QBUsers.signUp(qbUser, new QBEntityCallback<QBUser>() {
                @Override
                public void onSuccess(QBUser user, Bundle params) {
                    Toast.makeText(getContext(), "Registrado con exito!", Toast.LENGTH_SHORT).show();
                    //Cambiar a actividad Main
                    Intent successLoginIntent = new Intent(getActivity(), MainActivity.class);
                    startActivity(successLoginIntent);
                }

                @Override
                public void onError(QBResponseException errors) {
                    Toast.makeText(getContext(), "Fallo en el Registro!!!!!!", Toast.LENGTH_SHORT).show();
                    //Cambiar EditText de color o algo
                }
            });
        } else {
            Toast.makeText(getContext(), "Las contraseñas no coinciden!", Toast.LENGTH_SHORT).show();
        }

        //Despues de comprobar el Input vuelvo al Login
        volver();
    }

}