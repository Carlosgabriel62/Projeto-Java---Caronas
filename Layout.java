public class Layout{

  //LIMPADOR DE TELA
  public static void clearScreen() {
      System.out.print("\033[H\033[2J");  
  }

  public static void cabecalho() {
      System.out.print("\033[H");  
  }
  
}