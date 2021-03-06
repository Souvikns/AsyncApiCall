import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallApi {
    private String _URL;
    public CallApi(String url){
        this._URL = url;
    }

    //This functions returns in a the response as a string
    public String getDataString() throws IOException {
        URL url = new URL(this._URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String data;
        StringBuffer content = new StringBuffer();
        while ((data = in.readLine())!=null){
            content.append(data);
        }
        in.close();
        return String.valueOf(content);
    }

    //This function return the status code as a Integer
    public int getStatusCode() throws IOException {
        URL url = new URL(this._URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        return status;
    }
}
