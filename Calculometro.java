import java.lang.Math;

public class Calculometro {
  private static final double EARTH_RADIUS = 6371.0; // Raio da Terra em km

  public boolean raio(double lat_clie, double lon_clie, double lat_mot, double lon_mot) {
      double latClieRad = Math.toRadians(lat_clie);
      double lonClieRad = Math.toRadians(lon_clie);
      double latMotRad = Math.toRadians(lat_mot);
      double lonMotRad = Math.toRadians(lon_mot);

      double deltaLat = latMotRad - latClieRad;
      double deltaLon = lonMotRad - lonClieRad;

      double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                 Math.cos(latClieRad) * Math.cos(latMotRad) *
                 Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      double distancia = EARTH_RADIUS * c;


      // Retorna false se a distância for maior que 2 km
      return distancia <= 2;
  }

}
