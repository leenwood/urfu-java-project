package alphaproject.urfuProject.Services.RequestService;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class VideoCardAdapter {
    public JsonElement getVideoCards(String targetURL) {

        URL url = null;
        try {
            url = new URL(targetURL);
            URLConnection request = url.openConnection();
            request.connect();
            return JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        } catch (Exception e) {
            return null;
        }

//        HttpURLConnection connection = null;
//        try {
//            URL url = new URL(targetURL);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type",
//                    "application/json");
//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);
//
//            DataOutputStream wr = new DataOutputStream(
//                    connection.getOutputStream()
//            );
//            wr.writeBytes(urlParameters);
//            wr.close();
//
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//
//        rd.close();
//        return response;
//        } catch (Exception e) {
//            return null;
//        } finally {
//            if (connection != null)
//                connection.disconnect();
//        }
    }
}
