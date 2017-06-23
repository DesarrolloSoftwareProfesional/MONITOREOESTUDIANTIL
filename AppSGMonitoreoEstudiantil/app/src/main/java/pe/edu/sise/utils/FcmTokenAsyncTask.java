package pe.edu.sise.utils;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;
import pe.edu.sise.controller.AlumnoController;
import pe.edu.sise.model.Response;

/**
 * Created by Abel on 23/06/2017.
 */

public class FcmTokenAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    private static final String TAG = "FcmTokenAsyncTask";

    @Override
    protected Response doInBackground(JSONObject... params) {
        return AlumnoController.updateFcmToken(params[0]);
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        Log.d(TAG, "fcmUpdate" + response.getMsg());
    }
}
