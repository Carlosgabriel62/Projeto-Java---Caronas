import java.util.List;
import java.util.ArrayList;

public class Validador {
    private List<Motorista> motoristas;
    private List<Cliente> clientes;
    private List<Integer> bancoId = new ArrayList<>();
    private Avaliador avaliador=new Avaliador();

    public Validador() {
        this.motoristas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);

    }

    public void adicionarMotorista(Motorista motorista) {
        this.motoristas.add(motorista);

    }

    public Boolean validarCadastro(String email) {
        for (Cliente cli : clientes) {
            if (cli.getEmail().equals(email)) {
                return true;
            }
        }
        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Boolean validarAcesso(String email, String senha) {
        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(email) && motorista.getSenha().equals(senha)) {
                return true;
            }
        }
        for (Cliente cli : clientes) {
            if (cli.getEmail().equals(email) && cli.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    // VER ESSE METODO
    public void acessoBancoId(Usuario usuario, int flag) {
        this.bancoId.add(usuario.getId());
        bancoId.add(flag);
    }

    // VER ESSE METODO
    public int buscarFLagCli(String email) {
        for (Cliente cli : clientes) {
            if (cli.getEmail().equals(email)) {
                return cli.getId();
            }
        }
        return 0;
    }

    public int buscarFLagMotorista(String email) {
        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(email)) {
                return motorista.getId();
            }
        }
        return 0;
    }

    public Cliente loginCli(String email) {
        for (Cliente cli : clientes) {
            if (cli.getEmail().equals(email)) {
                return cli;
            }
        }
        return null; // Retorna null se nenhum usuário for encontrado
    }

    public Motorista loginMotorista(String email) {
        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(email)) {
                return motorista;
            }
        }
        return null; // Retorna null se nenhum usuário for encontrado
    }

    public void adcAvaliacoesC(Cliente cliente){
        avaliador.adicionarCliente(cliente);
    }
    
    public void adcAvaliacoesM(Motorista motorista){
        avaliador.adicionarMotorista(motorista);
    }
    
    public void exibirBancoDados() {
        int contador = 1;
        System.out.println("Clientes");
        for (Cliente cli : clientes) {
            System.out.println(contador + " " + cli.infosCLiente());
            contador++;
        }
        System.out.println("Motoristas");
        contador = 1;
        for (Motorista motorista : motoristas) {
            System.out.println(contador + " " + motorista.infosMotorista());
            contador++;
        }
    }
}
