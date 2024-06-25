import java.util.HashMap;
import java.util.Map;

public class Avaliador{
  private Motorista motorista;
  private Cliente cliente;
  Map<Integer,Float> notasClientes=new HashMap<>();
  Map<Integer,Float> notasMotoristas=new HashMap<>();
  Map<Integer,Integer> qntdAvaCliente=new HashMap<>();
  Map<Integer,Integer> qntdAvaMotorista=new HashMap<>();
  

  public void adicionarCliente(Cliente cliente){
    notasClientes.put(cliente.getId(),cliente.getNota());
    qntdAvaCliente.put(cliente.getId(),0);
  }

  public void exibirClientes(){
    System.out.println("Clientes");
    for(Map.Entry<Integer, Float> entry : notasClientes.entrySet()) {
        System.out.println("ID: " + entry.getKey() + ", Valor: " + entry.getValue());
    }
  }

  public void exibirMotorista(){
    System.out.println("Clientes");
    for(Map.Entry<Integer, Float> entry : notasMotoristas.entrySet()) {
        System.out.println("ID: " + entry.getKey() + ", Valor: " + entry.getValue());
    }
  }

  public void adicionarMotorista(Motorista motorista){
    notasMotoristas.put(motorista.getId(),motorista.getNota());
    qntdAvaMotorista.put(motorista.getId(),0);
  }
  
  public float notasClientes(Usuario cliente){
    Float Nota_=notasClientes.get(cliente.getId());
    return Nota_;
  }
  
  public float notasMotoristas(Usuario motorista){ 
    Float Nota_=notasMotoristas.get(motorista.getId());
    return Nota_;
  }

  public void qntdAvaCliente(Usuario cliente){
    int Quantidade=qntdAvaCliente.get(cliente.getId());
  }

  public void qntdAvaMotorista(Usuario motorista){ 
    int Quantidade=qntdAvaMotorista.get(motorista.getId());
  }
  
  public void avaliarCliente(Usuario cliente,int nota){
    float Nota_=notasClientes.get(cliente.getId());
    Nota_+=nota;
    int Quantidade=qntdAvaCliente.get(cliente.getId());
    Quantidade=Quantidade+1;
    Float Media=Nota_/Quantidade;
    notasClientes.put(cliente.getId(),Media);
    qntdAvaCliente.put(cliente.getId(),Quantidade);
    cliente.setNota(Media);
  }

  public void avaliarMotorista(Usuario motorista,int nota){ 
    float Nota_=notasMotoristas.get(motorista.getId());
    Nota_+=nota;
    int Quantidade=qntdAvaMotorista.get(motorista.getId());
    Quantidade=Quantidade+1;
    Float Media=Nota_/Quantidade;
    notasMotoristas.put(motorista.getId(),Media);
    qntdAvaMotorista.put(motorista.getId(),Quantidade);
    motorista.setNota(Media);
  }

  
}