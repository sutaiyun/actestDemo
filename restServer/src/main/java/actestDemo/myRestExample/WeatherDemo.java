package actestDemo.myRestExample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sutaiyun on 2016/8/18.
 */
public class WeatherDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://api.weatherdt.com/common/?area=101020100&type=forecast&key=XXXXXX");
            HttpURLConnection uRLConnection = (HttpURLConnection) url.openConnection();
            uRLConnection.setDoOutput(true);
            uRLConnection.connect();
            InputStream is = uRLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String respJson = "";
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                respJson += readLine;
            }

            System.out.println("respJson are" + respJson);
            is.close();
            br.close();
            uRLConnection.disconnect();
        } catch (Throwable e) {
            System.out.println(" Error: " + e);
        }
    }
}
