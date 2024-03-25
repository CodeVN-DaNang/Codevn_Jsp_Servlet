


import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */
public class GoogleUtils {
     public static String getToken(final String code) throws ClientProtocolException, IOException {
    String response = Request.Post(LoginGoogle.GOOGLE_LINK_GET_TOKEN)
        .bodyForm(Form.form().add("client_id", LoginGoogle.GOOGLE_CLIENT_ID)
            .add("client_secret", LoginGoogle.GOOGLE_CLIENT_SECRET)
            .add("redirect_uri",LoginGoogle.GOOGLE_REDIRECT_URI).add("code", code)
            .add("grant_type", LoginGoogle.GOOGLE_GRANT_TYPE).build())
        .execute().returnContent().asString();
      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
      return accessToken;
  }
  public static User getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
    String link = LoginGoogle.GOOGLE_LINK_GET_USER_INFO + accessToken;
    String response = Request.Get(link).execute().returnContent().asString();
    User user = new Gson().fromJson(response, User.class);
    System.out.println(user);
    return user;
  }

}
