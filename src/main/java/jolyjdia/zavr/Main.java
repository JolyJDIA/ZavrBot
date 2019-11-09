package jolyjdia.zavr;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static final Properties properties = new Properties();
    private static String accessToken;
    static {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        accessToken = properties.getProperty("access_token");
    }
    private static final VkApiClient vkApiClient = new VkApiClient(new HttpTransportClient());
    public static void main(String[] args) throws ClientException, ApiException {
        UserActor zavr = new UserActor(310289867, accessToken);
        System.out.println(vkApiClient.friends().get(zavr).execute());

    }
}
