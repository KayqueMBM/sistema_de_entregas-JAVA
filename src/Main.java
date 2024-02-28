import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();

    }
}

class Menu{
    public void MenuPrincipal(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Sistema de Eventos da Cidade Joinville");
        int escolha = 0;
        do{
            System.out.println(" 1 - Cadastro de Usuários");
            System.out.println(" 2 - Consulta de Usuários");
            System.out.println(" 3 - Cadastro de Eventos");
            System.out.println(" 4 - Consulta de Eventos");
            System.out.println(" Digite sua opção: ");
            escolha = teclado.nextInt();
        }while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4);

        if (escolha == 1)
        {
            Usuarios meu_usuario = new Usuarios();
            meu_usuario.Inserir();
        }
        if (escolha == 2)
        {
            Usuarios meu_usuario = new Usuarios();
            meu_usuario.Consultar();
        }
        if (escolha == 3)
        {
            Eventos meu_evento = new Eventos();
            meu_evento.Menu();
        }
        if (escolha == 4)
        {
        }
    }
}
class Usuario{

    public String Codigo;
    public String Nome;
    public String Fone;

    public Usuario(String c, String n, String f) {
        this.setCodigo(c);
        this.setNome(n);
        this.setFone(f);
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = Nome;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String fone) {
        this.Fone = Fone;
    }

    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + "Nome: " + this.getNome() + "Fone: " + this.getFone();
    }

}
class Usuarios{

    public void Inserir(){

        String c, n, f;

        Scanner teclado = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        char controle = 's';
        do{
            System.out.println("Entre com um Codigo:");
            c = teclado.nextLine();
            System.out.println("Entre com um Nome:");
            n = teclado.nextLine();
            System.out.println("Entre com um Telefone:");
            f = teclado.nextLine();
            Usuario u1 = new Usuario(c,n,f);
            usuarios.add(u1);

            System.out.println("Deseja cadastrar outro usuário? S-SiM N=Não");
            controle = teclado.next().charAt(0);
        }while (controle == 's' || controle == 'S');

        /*Chama menu Principal*/
        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();
    }
    public void Consultar() {
        for (Usuario usuario : 'usuarios');
        System.out.println("Codigo: " + 'usuarios'.getCodigo());
        System.out.println("Nome: " + 'usuarios'.getNome());
        System.out.println("Fone: " + 'usuarios'.getFone());
        System.out.println();
        }
    }
}
class Evento {
    public String Nome;
    public String Endereco;
    public String Categoria;
    public String Horario;
    public String Descricao;
}

class Eventos {
    Evento e1 = new Evento();
    public void Menu(){

        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        do{
            System.out.println(" 1 - Inserir");
            System.out.println(" Digite sua opção: ");
            escolha = teclado.nextInt();
        }while (escolha != 1);

        Eventos meu_evento = new Eventos();
        if (escolha == 1)
        {
            meu_evento.Inserir();
        }
        if (escolha == 2)
        {
            meu_evento.Excluir();
        }
    }
    void Inserir(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Entre com Nome do Evento:");
        e1.Nome = teclado.nextLine();
        System.out.println("Entre com Endereço do Evento:");
        e1.Endereco = teclado.nextLine();
        System.out.println("Escolha a Categoria (1 - Festa de aniverário, 2 - Casamento, 3 - Show ):");
        e1.Categoria = teclado.nextLine();
        System.out.println("Entre com horário do Evento:");
        e1.Horario = teclado.nextLine();
        System.out.println("Entre com descrição do Evento:");
        e1.Descricao = teclado.nextLine();

        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();
    }
    void Excluir(){
        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();

    }
}