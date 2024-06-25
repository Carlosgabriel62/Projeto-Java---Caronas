public class Carro extends Veiculo{
  
  public Carro(){
    super.setLugares(4);
  }

  public Carro(String modelo,String placa){
      super.setLugares(4);
      super.setModelo(modelo);
      super.setPlaca(placa);
  }

  


}