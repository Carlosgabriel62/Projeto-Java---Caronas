import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Viagem  {
  // atributos 
  private String localPartida;
  private String destino;
  private String[] trajeto=new String[5];//talves uma lista com pontos de parada
   private List<Cliente> clientes;
  private Veiculo veiculo;
  private int IdV;
  private int lugares;
  private Motorista motorista;
  private double lat;
  private double lon;

  public Viagem(String localPartida,String destino, String[] trajeto,Veiculo veiculo,Motorista motorista){
    this.localPartida=localPartida;
    this.destino=destino;
    this.trajeto=trajeto;
    this.veiculo=veiculo;
    this.clientes = new ArrayList<>(veiculo.getLugares());
    this.lugares=veiculo.getLugares();
    this.motorista=motorista;
  }

  // getters and setters 
  public String getLocalPartida(){
    return localPartida;
  }

  public void setlocalPartida(String localPartida){
    this.localPartida = localPartida;
  }

  public String getDestino(){
    return destino;
  }

  public void setDestino(String destino){
    this.destino = destino;
  }

  public void setIdV(int IdV){
    this.IdV = IdV;
  }

  public int getIdV(){
    return IdV;
  }

  public void setLat(double lat){
    this.lat=lat;
  }

  public double getLat(){
    return lat;
  }

  public void setLon(double lon){
    this.lon=lon;
  }

  public double getLon(){
    return lon;
  }

  public String[] getTrajeto(){ return trajeto;
      }

      public void setTrajeto(String[] trajeto){
        this.trajeto = trajeto;
      }

      public void encerrarViagem(){
        System.out.println("Viagem encerrada");
      }

      public void definirQntdPass(){
        System.out.println("Quantidade de lugares"+veiculo.getLugares());
      }

      public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        cliente.adicionarViagem(this);
      }

  public void exibirClientes() {
      Set<Integer> idsExibidos = new HashSet<>();
      StringBuilder texto = new StringBuilder();

      for (Cliente cliente : clientes) {
          if (!idsExibidos.contains(cliente.getId())) {
              idsExibidos.add(cliente.getId());

              texto.append("Nome: ");
              texto.append(cliente.getNome());
              texto.append("\nID: ");
              texto.append(cliente.getId());
              texto.append("\n");
          }
      }

      System.out.println(texto.toString());
  }

  public Cliente acessarCliente(int id){
    for(Cliente cli:clientes){
      if(cli.getId()==id){
        return cli;
      }
    }
    return null;
  }

  public Motorista acessarMotorista(){
    return motorista;
  }

  public void diminuirLugares(){
     lugares=lugares-1;
  }


      public String exibirViagem(){
        String txt;
        txt="id: "+getIdV()+ "\n";
        txt+="Local de partida: "+getLocalPartida()+"\n";
        txt+="Destino: "+getDestino()+"\n";
        for(int i=0;i<5;i++){
          int a=i+1;
          txt+="Ponto de parada "+(a)+" :"+trajeto[i]+"\n";
        }
        txt+=veiculo.exibirVeiculo();
        txt+="Quantidade de lugares ainda disponíveis"+lugares;
        return txt;
      }

    }































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































   