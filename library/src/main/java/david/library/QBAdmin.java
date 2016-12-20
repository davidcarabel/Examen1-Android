package david.library;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.QBSettings;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by david on 13/12/2016.
 */

public class QBAdmin {

    QBAdminListener listener;

    public QBAdmin(QBAdminListener listener, Activity activity){
        this.listener = listener;
        String APP_ID  = "50928";
        String AUTH_KEY = "r-DPm6ZBpzOLh2S";
        String AUTH_SECRET = "PNJJgG2rpOq8KDq";
        String ACCOUNT_KEY = "BucwT8dUu7ZxWenVXsXy";

        QBSettings.getInstance().init(activity, APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);

        QBAuth.createSession(new QBEntityCallback<QBSession>() {
            @Override
            public void onSuccess(QBSession qbSession, Bundle bundle) {
                //Successfully created session
            }

            @Override
            public void onError(QBResponseException e) {

            }
        });
    }

    public void login(String suser, String pass){
        final QBUser user = new QBUser(suser,pass);

        QBUsers.signIn(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser qbUser, Bundle bundle) {
                listener.logeado(true, user);
            }

            @Override
            public void onError(QBResponseException e) {
                listener.logeado(false, null);
            }
        });
    }

    public void selectDeTablasIdiomas(String id_idioma){
        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();

        requestBuilder.eq("idiomas", id_idioma);

        QBCustomObjects.getObjects("idiomas", requestBuilder, new QBEntityCallback<ArrayList<QBCustomObject>>(){
            @Override
            public void onSuccess(ArrayList<QBCustomObject> customObjects, Bundle bundle) {
                HashMap<Integer, String> palabras = new HashMap<Integer, String>();
                for(int i = 0; i < customObjects.size(); i++){
                    Log.v("QBAdmin", "Fila " + i+" " + customObjects.get(i).getFields());
                    String sValor = customObjects.get(i).getFields().get("valor").toString();
                    int iPalabra = (int) customObjects.get(i).getFields().get("idp");

                    palabras.put(iPalabra, sValor);
                }
                listener.datosTablaIdiomaDescargado(palabras);
            }

            @Override
            public void onError(QBResponseException e) {

            }
        });
    }
}
