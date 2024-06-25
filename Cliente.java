import java.util.List;
import java.util.ArrayList;

public class Cliente extends Usuario{
  private Long telefone;
  private Avaliador avaliador;
  private List<Viagem> viagens= new ArrayList<>();

  public Cliente(String email,String senha,String nome){
    super(email,senha,nome);
    nota=0;
    telefone=null;
    avaliador=new Avaliador();
    avaliador.adicionarCliente(this);
  }

  public Cliente(String email,String senha,String nome,int id){
    super(email,senha,nome);
    nota=0;
    telefone=null;
    avaliador=new Avaliador();
    avaliador.adicionarCliente(this);
  }

  public Long getTelefone(){
    return telefone;
  }
  
  public void setTelefone(Long telefone){
    this.telefone=telefone;
  }
  public List<Viagem> getViagens(){
    return viagens;
  }


  public void adicionarViagem(Viagem viagem){
    viagens.add(viagem);
  }

  public String infosCLiente(){
    String txt=super.infosUsuario();
    txt+="\t\t\tNota: "+nota;
    txt+="\n\t\t\tTelefone: "+telefone;
    return txt;
  }
  
}