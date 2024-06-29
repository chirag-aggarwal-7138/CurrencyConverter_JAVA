import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


import java.io.IOException;

public class ExchangeRateFetcher {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static JsonObject fetchRates(String baseCurrency) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(API_URL + baseCurrency);
        CloseableHttpResponse response = httpClient.execute(request);

        String jsonResponse = EntityUtils.toString(response.getEntity());
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        response.close();
        httpClient.close();

        return jsonObject;
    }
}
