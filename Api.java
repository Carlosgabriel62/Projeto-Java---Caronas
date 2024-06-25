  import java.net.HttpURLConnection;
  import java.net.URL;
  import java.io.BufferedReader;
  import java.io.InputStreamReader;
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;
  import java.util.HashMap;
  import java.util.Map;

public class Api{
  public Map<String, String> pegaLocalizacao(String local){
    
         Map<String,String> coordenadas = new HashMap<>();
       try {
  
        String apiUrl = "https://geocode.maps.co/search?q="+local+"&api_key=666f19ff970eb288553083uso2b2e7d";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
  
                  int responseCode = connection.getResponseCode();
                  if (responseCode == HttpURLConnection.HTTP_OK) {
                      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                      String inputLine;
                      StringBuilder response = new StringBuilder();
  
                      while ((inputLine = in.readLine()) != null) {
                          response.append(inputLine);
                      }
                      in.close();
  
                        Pattern latPattern = Pattern.compile("\"lat\":\"([^\"]+)\"");
                        Pattern lonPattern = Pattern.compile("\"lon\":\"([^\"]+)\"");
                        Matcher latMatcher = latPattern.matcher(response);
                        Matcher lonMatcher = lonPattern.matcher(response);
  
                        while (latMatcher.find() && lonMatcher.find()) {
                            String lat = latMatcher.group(1);
                            String lon = lonMatcher.group(1);
                            coordenadas.put("lat", lat);
                            coordenadas.put("lon", lon);
                    }
  
                  } 
                  else {
                      System.out.println("GET request não funcionou, código de resposta: " + responseCode);
                  }
              }
       catch (Exception e) {
                  e.printStackTrace();
              }
        return coordenadas;
          }
    }