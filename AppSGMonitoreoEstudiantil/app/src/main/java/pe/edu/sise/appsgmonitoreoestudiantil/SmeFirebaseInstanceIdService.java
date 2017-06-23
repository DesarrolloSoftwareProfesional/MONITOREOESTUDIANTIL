package pe.edu.sise.appsgmonitoreoestudiantil;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONObject;

import pe.edu.sise.utils.FcmTokenAsyncTask;
import pe.edu.sise.utils.JSONObjectValue;

/**
 * Created by Abel on 17/06/2017.
 */

public class SmeFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "SmeFirebaseInstIdServ";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
        // super.onTokenRefresh();
    }

    private void sendRegistrationToServer(String token) {
        try {
            new FcmTokenAsyncTask().execute(JSONObjectValue.fcmToken("1", token));
        } catch (Exception e) {
            Log.d(TAG, Log.getStackTraceString(e));
        }
    }

}
