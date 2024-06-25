public class Veiculo{
  protected int lugares;
  protected String placa;
  protected String modelo;
  protected Motorista motorista;

  

  public Veiculo(){
    lugares=0;
    modelo="nao identificado";
    placa="AAA-0000";
  }

  public Veiculo(int Lugares,String modelo, String placa){
    this.lugares=Lugares;
    this.modelo=modelo;
    this.placa=placa;
  }

  public int getLugares(){
    return lugares;
  }

  public void setLugares(int lugares){
    this.lugares=lugares;
  }

  public String getPlaca(){
    return placa;
  }

  public void setPlaca(String placa){
    this.placa=placa;
  }

  public String getModelo(){
    return modelo;
  }

  public void setModelo(String modelo){
    this.modelo=modelo;
  }

  public void adicionarDono(Motorista dono){
    motorista=dono;
  }

  public String exibirVeiculo(){
    String txt= "\t\t\tModelo: "+this.modelo+"\n";
    txt+="\t\t\tLugares: "+this.lugares+"\n";
    txt+="\t\t\tPlaca: "+this.placa+"\n";
    return txt;
  }

  public void exibirDono(){
    System.out.printf("\nInformações do dono do",getModelo()); 
    System.out.println(motorista.infosMotorista());
  }

  
  
}