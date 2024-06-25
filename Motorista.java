import java.util.List;
import java.util.ArrayList;

public class Motorista extends Usuario{
  protected int idade;
  protected String cnh;
  protected List<Veiculo> veiculos= new ArrayList<>();

  private List<Viagem> viagens= new ArrayList<>();

  public Motorista(String email,String senha,String nome,int idade,String cnh){
    super(email,senha,nome);
    this.idade=idade;
    this.cnh=cnh;

  } 

  public List<Viagem> getViagens(){
    return viagens;
  }

  public Veiculo getVeiculo(String placa){
    for (Veiculo veiculo : veiculos) {
      if (veiculo.getPlaca().equals(placa)) {
          return veiculo;
      }
  }
    return null;
  }

  public void adicionarVeiculo(Veiculo veiculo){
    veiculo.adicionarDono(this);
    veiculos.add(veiculo);
  }
  
  public void removerVeiculo(Veiculo veiculo){
    veiculos.remove(veiculo);
  }

  public void adicionarViagem(Viagem viagem){
    viagens.add(viagem);
  }

  public void infosVeiculos(){
    System.out.println("Veiculos do Motorista "+nome+" : ");
    String txt;
    for(Veiculo veiculo:veiculos){
      System.out.println(veiculo.exibirVeiculo());
    }
  }

  public String infosMotorista(){
    String txt=super.infosUsuario();
    txt+="\t\t\tIdade: "+idade;
    txt+="\n\t\t\tCNH: "+cnh;
    return txt;
  }


  
}