package edu.neu.ccs.cs5004.eschaton.controller.rest;

import com.google.gson.Gson;
import edu.neu.ccs.cs5004.eschaton.controller.Controller;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractCommand implements CommandInterface {

    protected Model model;
    protected HttpClient client;
    protected Gson gson;
    protected String URL;


    /** When the client needs to reach a new endpoint a new RESTRequest will be made. The
     * host and port will generally be fixed. A new flag will have to be made in components
     * for each new endpoint. POST's should call POST() and GET's should call GET().
     *
     * @param client HTTPClient used in every RESTRequest.
     * @param host String representing the domain name. "http://[something]"
     * @param port String representing the port number of the server.
     * @param flag String matching the REST endpoint on the server the instance of this
     *             class targets.
     */

    public AbstractCommand(Model model, HttpClient client, Gson gson, String host, String port, String flag) {
      this.model = model;
      this.client = client;
      this.gson = gson;
      this.URL =  host + port + flag;
      System.out.println(URL);
    }

    public HttpClient getClient() { return client; }

    public String getURL() { return URL; }

    /**
     * @return String the JSON response from the server. A board with a 50/50 shot at
     * the center square being marked.
     * @throws IOException
     */
    protected String GET(){

      String loot = "";

      try {

        HttpGet GET = new HttpGet(URL);

        HttpResponse response = client.execute(GET);

        System.out.println("status: " + response.getStatusLine());

        HttpEntity GETentity = response.getEntity();
        byte[] buffer = new byte[1024];

        if(GETentity != null) {
          InputStream GETStream = GETentity.getContent();
          int bytesRead = 0;

          try {

            BufferedInputStream bufferReader = new BufferedInputStream(GETStream);

            while ((bytesRead = bufferReader.read(buffer)) != -1) {
              String something = new String(buffer, 0, bytesRead);
              System.out.println(something);
              loot += something;
            }
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            try {
              GETStream.close();
            } catch (Exception ignore) {}
          }
        } else {
          System.out.println("ENTITY = NULL");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return loot;
    }

    /**
     * @param json String formatted to JSON that is sent in the POST request as the
     *             entity to the server.
     * @return String the JSON response from the server. The server will take the board
     * mark the appropriate square for it's play.
     * @throws IOException
     */
    protected String POST(String json){

      String loot = "";

      try {

        System.out.println(URL);
        HttpPost POST = new HttpPost(URL);
        POST.addHeader("content-type", "application/json");
        POST.setEntity(new StringEntity(json));

        HttpResponse response = client.execute(POST);

        System.out.println("status: " + response.getStatusLine());

        HttpEntity POSTentity = response.getEntity();
        byte[] buffer = new byte[1024];

        if(POSTentity != null) {
          InputStream POSTStream = POSTentity.getContent();
          int bytesRead = 0;

          try {

            BufferedInputStream bufferReader = new BufferedInputStream(POSTStream);

            while ((bytesRead = bufferReader.read(buffer)) != -1) {
              String something = new String(buffer, 0, bytesRead);
              loot += something;
            }
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            try {
              POSTStream.close();
            } catch (Exception ignore) {}
          }
        } else {
          System.out.println("ENTITY = NULL");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println(loot);
      return loot;
    }

  }


