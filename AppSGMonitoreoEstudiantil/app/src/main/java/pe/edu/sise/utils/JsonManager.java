package pe.edu.sise.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Abel on 29/04/2017.
 */

public class JsonManager {

    private static final String TAG = "JsonManager";

    // variables
    private static HttpURLConnection httpURLConnection;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private static BufferedReader bufferedReader;

    // metodo para Listar , buscar y eliminar
    public static String getJsonString(String urlClient, String method) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(urlClient);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (Exception e) {
            //Log.d(TAG, e.toString());
        } finally {
            closeHttpURLConnection(httpURLConnection);
            closeBufferedReader(bufferedReader);
            closeInputStream(inputStream);
        }

        return stringBuilder.toString();
    }

    // metodo para isertar , actualizar y listar por post
    public static String getJsonString(String urlClient, String method, JSONObject jsonObject) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(urlClient);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();

            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(jsonObject.toString().getBytes("UTF-8"));
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (Exception e) {
            //Log.d(TAG, e.toString());
        } finally {
            closeHttpURLConnection(httpURLConnection);
            closeBufferedReader(bufferedReader);
            closeInputStream(inputStream);
            closeOutputStream(outputStream);
        }

        return stringBuilder.toString();
    }


    //metodos privados para cerrar los objetos
    private static void closeHttpURLConnection(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private static void closeInputStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e) {
            //Log.d(TAG, Log.getStackTraceString(e));
        }
    }

    private static void closeBufferedReader(BufferedReader bufferedReader) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            //Log.d(TAG, Log.getStackTraceString(e));
        }
    }

    private static void closeOutputStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception e) {
            //Log.d(TAG, Log.getStackTraceString(e));
        }
    }
}