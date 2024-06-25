import java.util.ArrayList;
import java.util.List;

public class Viagens{
  private List<Viagem> viagens=new ArrayList<>();

public void adicionarViagem(Viagem viagem){
  viagens.add(viagem);
}

  public Viagem acessarViagem(int id){
    for(Viagem viagem:viagens){
      if(viagem.getIdV()==id){
        return viagem;
      }
    }
    return null;
  }

  public List<Viagem> retornaViagem(){
    return viagens;
  }


  public String exibirViagensDisponiveis(){
    String txt2;
    txt2= "\t\t\tViagens Disponíveis\n";
    for(Viagem viagem:viagens){
      txt2+=viagem.exibirViagem();
    }
    return txt2;
  }
  
}