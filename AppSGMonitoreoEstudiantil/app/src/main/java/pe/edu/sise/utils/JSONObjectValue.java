package pe.edu.sise.utils;

import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Abel on 23/06/2017.
 */

public class JSONObjectValue {
    private static final String TAG="FcmTokenAsyncTask";

    public static JSONObject fcmToken(String fcmToken, String idAlumno) {
        JSONObject jsonObject = null;

        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Attributes.ALUM_FCM_TOKEN, fcmToken);
            hashMap.put(Attributes.ALUM_ID, idAlumno);

            jsonObject = new JSONObject(hashMap);

        } catch (Exception e) {
            Log.d(TAG, "Error valueFcmToken " + Log.getStackTraceString(e));
        }

        return jsonObject;
    }
}
