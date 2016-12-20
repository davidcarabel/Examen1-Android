package david.examen1eva;

/**
 * Created by david.carabel on 20/12/2016.
 */

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

import david.library.QBAdminListener;


public class Quickblox implements QBAdminListener {

    @Override
    public void logeado(boolean bllogeado, QBUser user) {

    }

    @Override
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {

    }

    @Override
    public void datosTablaIdiomaDescargado(HashMap<Integer, String> p) {

    }
}