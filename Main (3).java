import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
  //CORES DO PROGRAMA
  public static final String BLUE="\033[1;34m";
  public static final String RED="\u001B[31m";
  public static final String RESET="\033[0m";
  public static final String NEGRITO="\033[1m";
  public static int nextId = 1;
  public static int nextIdV = 1;
  
  
  public static void main(String[] args) {
  Map<Integer, String> mapa = new HashMap<>();
  mapa.put(1, "primeiro");
  mapa.put(2, "segundo");
  mapa.put(3, "terceiro");
  mapa.put(4, "quarta");
  mapa.put(5, "quinto");

    Scanner tcl=new Scanner(System.in); 
    Layout layout=new Layout();
    Menu menu=new Menu();
    Viagens viagens=new Viagens();
    Avaliador avaliador=new Avaliador();
    Validador validador=new Validador();
    Api api=new Api();
    Calculometro calculometro=new Calculometro();
    
    //CRIANDO INSTANCIAS PRO BANCO DE DADOS
    Cliente teste=new Cliente("bertunes@gmail.com","123","Gabriel");
    teste.setId(90);
    validador.adicionarCliente(teste);
    validador.acessoBancoId(teste,0);
    validador.adcAvaliacoesC(teste);
    avaliador.adicionarCliente(teste);
    Cliente teste2=new Cliente("bertunes.com","123","Manoel");
    teste2.setId(10);
    validador.adicionarCliente(teste2);
    validador.acessoBancoId(teste2,0);
    validador.adcAvaliacoesC(teste2);
    avaliador.adicionarCliente(teste2);


    System.out.print(menu.telaInicial());
    int opcao=tcl.nextInt();
    tcl.nextLine();

    switch (opcao){
      case 1:
        tcl.nextLine();
        System.out.print("\nDigite seu email:");
        String email=tcl.nextLine().toLowerCase();
        System.out.print("Digite uma senha:");
        String senha=tcl.nextLine();

            //VALIDA E ARMAZENA E CRIA USUARIO
          if(validador.validarCadastro(email)==true){
              System.out.println(RED+"Email já cadastrado"+RESET);
              break;
              //colocar um botao de voltar para o menu
            }
            
          else{

              //DIFERENCIAR USUÁRIO ENTRE CLIENTE E MOTORISTA
              layout.clearScreen();
              layout.cabecalho();
              System.out.println("\t\t\tCadastro");
              System.out.print("---------------------------------------------");
              System.out.print("\n\nDigite sua categoria\n"+BLUE+"Motorista ou Cliente:\n"+RESET);
              String categoria=tcl.nextLine().toLowerCase();
            
              if (categoria.equals("cliente")){
                layout.clearScreen();;
                layout.cabecalho();
                System.out.println("\t\t\tCadastro Cliente");
                System.out.print("---------------------------------------------");
                

                //SETAR INFORMAÇÕES DO CLIENTE
                System.out.print("\n\nDigite seu nome completo:");
                String nome=tcl.nextLine().toLowerCase();

                Cliente cliente1=new Cliente(email,senha,nome);
                System.out.print("Digite seu telefone(opcional):");
                Long telefone=tcl.nextLong();
                if (telefone>=900000000 && telefone<=999999999){
                  cliente1.setTelefone(telefone);
                }


                //CONFIRMAR INFORMAÇÕES CADASTRAIS
                layout.clearScreen();
                layout.cabecalho();
                System.out.println("\t\t\tCadastro Cliente");
                System.out.print("---------------------------------------------");
                System.out.println("\n"+NEGRITO+cliente1.infosCLiente()+RESET);
                System.out.print("\nConfirmar Informações?");
                tcl.nextLine();
                String confirma=tcl.nextLine().toLowerCase();
                if(confirma.equals("sim")){
                  cliente1.setId(nextId++);
                  validador.adicionarCliente(cliente1);
                  validador.acessoBancoId(cliente1,1);
                  System.out.println("Cadastro efetuado com sucesso");
                  cliente1.infosCLiente();
                  opcao=2;
                }  
                }
              else{
                layout.clearScreen();
                layout.cabecalho();
                System.out.println("\t\t\tCadastro Motorista");
                System.out.print("---------------------------------------------");
                System.out.print("\n\nDigite sua idade:");
                int idade=tcl.nextInt();
                System.out.print("Digite sua CNH:");
                String cnh=tcl.next();
                tcl.nextLine();
                System.out.print("Digite seu nome completo:");
                String nome=tcl.nextLine().toLowerCase();
                Motorista motorista2=new Motorista(email,senha,nome,idade,cnh);
   
                layout.clearScreen();
                //CONFIRMAR INFORMAÇÕES CADASTRAIS
                layout.clearScreen();
                layout.cabecalho();
                System.out.println("\t\t\tCadastro Motorista");
                System.out.print("---------------------------------------------");
                //antes de criar motorista precisa instanciar o carro
                System.out.println("\n"+NEGRITO+motorista2.infosMotorista()+RESET);
                System.out.print("\nConfirmar Informações?");
                String confirma=tcl.nextLine().toLowerCase();
                if(confirma.equals("sim")){
                  motorista2.setId(nextId++);
                  validador.adicionarMotorista(motorista2);
                  validador.acessoBancoId(motorista2,0);
                  System.out.println("Cadastro efetuado com sucesso");
                  motorista2.infosMotorista();
                  validador.adcAvaliacoesM(motorista2);
                  avaliador.adicionarMotorista(motorista2);
                
                  
                  opcao=2;
                }
              }
            }
        
          try{
            Thread.sleep(2000);
          }
          catch(InterruptedException e) {
            
          }
          layout.clearScreen();

      case 2:
            int reiniciar=0;
            while(true){
          layout.clearScreen();
          System.out.println("\t\t\tLOGIN");
          System.out.print("---------------------------------------------");
          System.out.println("\nDigite seu email:");
          email=tcl.nextLine().toLowerCase();
          System.out.println("\nDigite sua senha:");
          senha=tcl.nextLine();

        
          if(validador.validarAcesso(email,senha)==true){
            layout.clearScreen();
            System.out.print("login com sucesso");
              if(validador.loginCli(email)!=null){
                int reiniciar2=0;
                while(reiniciar2!=5){
                Cliente cli=validador.loginCli(email);
                System.out.println(menu.telaCliente());
                System.out.println("Digite sua opcao:");
                reiniciar2=tcl.nextInt();
                if(reiniciar2==1){
                  System.out.println("Digite o seu local de partida");
                  tcl.nextLine();
                  String local=tcl.nextLine();
                  Map<String, String> valoresApi=api.pegaLocalizacao(local);
                  Double latitude=Double.parseDouble(valoresApi.get("lat"));
                  Double longitude=Double.parseDouble(valoresApi.get("lon"));
                  List<Viagem> listaViagens=viagens.retornaViagem();
                  for(Viagem viagem:listaViagens){
                    if(calculometro.raio(latitude,longitude,viagem.getLat(),viagem.getLon())==true){
                      System.out.println(viagem.exibirViagem());
                      System.out.println("Escolha o ID da viagem que deseja escolher");
                      int viagemId=tcl.nextInt();
                      Viagem viagemEsc=viagens.acessarViagem(viagemId);
                      viagemEsc.adicionarCliente(cli);
                      viagemEsc.diminuirLugares();
                      layout.clearScreen();
                    }
                    else{
                      System.out.println("Não existem viagens disponíveis");
                      try{
                        Thread.sleep(2000);
                      }
                      catch(InterruptedException e) {

                      }
                      layout.clearScreen();
                    }
                  }
                  

                }
                  
                else if(reiniciar2==2){
                  System.out.println("Avalie sua ultima viagem");
                    Viagem viagem=cli.getViagens().get(cli.getViagens().size() - 1);
                    System.out.println(NEGRITO+"Partida: "+RESET+viagem.getLocalPartida()+NEGRITO+"\nDestino: "+RESET+viagem.getDestino());
                   viagem.exibirClientes();
                   Usuario motorista=viagem.acessarMotorista();
                    System.out.println(motorista.infosUsuarioPublico());
                    System.out.println("Digite a nota do motorista de 1 a 10");
                    int nota=tcl.nextInt();
                    avaliador.avaliarMotorista(motorista,nota);
                    System.out.println("Avaliação efetuada com sucesso");
                    System.out.println("Nota atual do cliente"+motorista.getNota());
                }
                }
              }
              else{
                int reiniciar2=0;
                while(reiniciar2!=5){
                Motorista motorista=validador.loginMotorista(email);
                  
                System.out.println(menu.telaMotorista());
                System.out.println("Digite sua opcao:");
                reiniciar2=tcl.nextInt();
                if(reiniciar2==1){
                  layout.clearScreen();
                  System.out.print("1)Carro\n2)Moto\n3)Outro veículo\n");
                  int tipoVeiculo=tcl.nextInt();
                  layout.clearScreen();
                  System.out.println("Digite a placa do veiculo:");
                  tcl.nextLine();
                  String placa=tcl.nextLine().toUpperCase();
                  System.out.println("Digite o modelo do veiculo:");
                  String modelo=tcl.nextLine().toLowerCase();
                  if(tipoVeiculo==1){
                    Veiculo carro1=new Carro(modelo,placa);
                    carro1.setPlaca(placa);
                    carro1.setModelo(modelo);
                    motorista.adicionarVeiculo(carro1);
                  }
                  else if(tipoVeiculo==2){
                    Veiculo moto1=new Moto(modelo,placa);
                    motorista.adicionarVeiculo(moto1);
                    moto1.exibirVeiculo();
                  }
                  else{
                    System.out.println("Digite a quantidade de lugares:");
                    int lugares=tcl.nextInt();
                    Veiculo outro1=new Veiculo(lugares,modelo,placa);
                    motorista.adicionarVeiculo(outro1);
                  }
                  layout.clearScreen();
                }
                  
                else if(reiniciar2==2){
                  System.out.println("Digite a partida");
                  tcl.nextLine();
                  String partida=tcl.nextLine().toLowerCase();
                  System.out.println("Digite o final da viagem");
                  Map<String, String> valoresApi=api.pegaLocalizacao(partida);
                  Double lat=Double.parseDouble(valoresApi.get("lat"));
                  Double lon=Double.parseDouble(valoresApi.get("lon"));
                  String destino=tcl.nextLine().toLowerCase();
                  System.out.println(NEGRITO+"\nDigite pontos de parada durante a viagem"+RESET);
                  String pontos[]=new String[5];
                  for(int i=0;i<5;i++){
                    System.out.println("Digite o "+mapa.get(i+1) +" ponto de parada:");
                    pontos[i]=tcl.nextLine().toLowerCase();
                  }
                  motorista.infosVeiculos();
                  System.out.println("Digite a placa do carro escolhido\n");
                  String carEscolhido=tcl.nextLine().toUpperCase();
                  Veiculo car=motorista.getVeiculo(carEscolhido);
                  Viagem viagem=new Viagem(partida,destino,pontos,car,motorista);
                  viagem.setIdV(nextIdV++);
                  viagem.setLat(lat);
                  viagem.setLon(lon);
                  motorista.adicionarViagem(viagem);
                  viagens.adicionarViagem(viagem);
                  layout.clearScreen();
                }
                  
                else if(reiniciar2==3){
                  System.out.println("Avalie sua ultima viagem");
                  Viagem viagem=motorista.getViagens().get(motorista.getViagens().size() - 1);
                  System.out.println(viagem.exibirViagem());
                  System.out.println(NEGRITO+"Partida: "+RESET+viagem.getLocalPartida()+NEGRITO+"\nDestino: "+RESET+viagem.getDestino());
                  viagem.exibirClientes();
                  System.out.println("Escolha o ID do passageiro que deseja avaliar");
                  int idavalido=tcl.nextInt();
                 Usuario cliente=viagem.acessarCliente(idavalido);
                  System.out.println(cliente.getNome());
                  System.out.println(cliente.getId());
                  System.out.println("Digite a nota do passageiro de 1 a 10");
                  int nota=tcl.nextInt();
                  avaliador.avaliarCliente(cliente,nota);
                  System.out.println("Avaliação efetuada com sucesso");
                  System.out.println("Nota atual do cliente"+cliente.getNota());
                  try{
                    Thread.sleep(2000);
                  }
                  catch(InterruptedException e) {

                  }
                  layout.clearScreen();
                  
                }
              }
              }
              }              
          else{
            System.out.println(RED+"Login ou senha incorretos"+RESET);
          }
              tcl.nextLine();
            }
        
      }
    tcl.close();
    }
}