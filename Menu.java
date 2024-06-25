public class Menu{
  
  public String telaInicial(){
    String txt;
    txt="\t\t**CarONE-M**\n";
    txt+="1) Cadastrar um novo usuário\n";
    txt+="2) Logar usuário existente\n";
    txt+="Selecione uma opção:";
    return txt;
  }

  public String telaMotorista(){
    String txt;
    txt="\t\t**CarONE-M**\n";
    txt+="1) Cadastrar Veículo\n";
    txt+="2) Cadastrar Viagem\n";
    txt+="3) Avaliar Passageiro\n";
    txt+="5) Sair\n";
    return txt;
  }

  public String telaCliente(){
    String txt;
    txt="\t\t**CarONE-M**\n";
    txt+="1) Buscar por carona\n";
    txt+="2) Avaliar uma viagem\n";
    txt+="5) Sair\n";

    return txt;
  }


}