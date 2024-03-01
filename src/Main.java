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
            Eventos meu_evento = new Eventos();
            meu_evento.Consultar();
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

    ArrayList usuarios = new ArrayList();
    public void Inserir(){

        String c, n, f;

        Scanner teclado = new Scanner(System.in);


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

        for (Usuario u : usuarios)
        {
            System.out.println("Codigo: " + u.getCodigo());
            System.out.println("Nome: " + u.getNome());
            System.out.println("Fone: " + u.getFone());
        }

        /*Chama menu Principal*/
        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();
    }

    public void Consultar() {
        System.out.println("Entrou");
    }
}
class Evento {
    public String Nome;
    public String Endereco;
    public String Categoria;
    public String Horario;
    public String Descricao;

    public Evento(String n, String e, String c, String h, String d) {
        this.setNome(n);
        this.setEndereco(e);
        this.setCategoria(c);
        this.setHorario(h);
        this.setDescricao(d);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = Endereco;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        this.Categoria = Categoria;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        this.Horario = Horario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() + "Endereco: " + this.getEndereco() + "Categoria: " + this.getCategoria() + "Horario: " + this.getHorario() + "Descricao: " + this.getDescricao();
    }
}

class Eventos {
    ArrayList<Evento> eventos = new ArrayList<Evento>();
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
    public void Inserir(){

        String n, e, c, h, d;

        Scanner teclado = new Scanner(System.in);

        char controle = 's';
        do{
            System.out.println("Entre com um Nome:");
            n = teclado.nextLine();
            System.out.println("Entre com um Endereço:");
            e = teclado.nextLine();
            System.out.println("Entre com uma Categoria:");
            c = teclado.nextLine();
            System.out.println("Entre com um Horario:");
            h = teclado.nextLine();
            System.out.println("Entre com um Descrição:");
            d = teclado.nextLine();

            Evento e1 = new Evento(n,e,c,h,d);
            eventos.add(e1);

            System.out.println("Deseja cadastrar outro evento? S-SiM N=Não");
            controle = teclado.next().charAt(0);
        }while (controle == 's' || controle == 'S');

        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();
    }
    void Excluir(){
        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();

    }
    public void Consultar() {
        System.out.println("Entrou");
        for (Evento e : eventos ) {
            System.out.println(e);
            System.out.println("Nome: " + e.getNome());
            System.out.println("Endereco: " + e.getEndereco());
            System.out.println("Categoria: " + e.getCategoria());
            System.out.println("Horario: " + e.getHorario());
            System.out.println("Descricao: " + e.getDescricao());
        }
    }
}