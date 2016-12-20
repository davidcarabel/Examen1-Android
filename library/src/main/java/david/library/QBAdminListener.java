package david.library;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by david on 13/12/2016.
 */

public interface QBAdminListener {

    public void logeado(boolean bllogeado, QBUser user);
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos);
    public void datosTablaIdiomaDescargado(HashMap<Integer, String> p);
}
