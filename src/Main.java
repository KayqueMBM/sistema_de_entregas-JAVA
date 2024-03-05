import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();

        String nomeDoArquivo = "events.data.txt";
        String conteudoParaGravar = "Este é o conteúdo que será gravado no arquivo.";

        gravarArquivo(nomeDoArquivo, conteudoParaGravar);
    }

    public static void gravarArquivo(String nomeDoArquivo, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
            writer.write(conteudo);
            System.out.println("Arquivo gravado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo: " + e.getMessage());
        }

    }
}

class Menu{
    public void MenuPrincipal(){

        Scanner teclado = new Scanner(System.in);


        System.out.println("Sistema de Eventos da Cidade Joinville");
        int escolha = 0;
        do{
            System.out.println(" 1 - Cadastro de Usuários");
            System.out.println(" 2 - Cadastro de Eventos");
            System.out.println(" Digite sua opção: ");
            escolha = teclado.nextInt();
        }while (escolha != 1 && escolha != 2);

        if (escolha == 1)
        {
            Usuarios meu_usuario = new Usuarios();
            meu_usuario.Inserir();
        }
        if (escolha == 2)
        {
            Eventos meu_evento = new Eventos();
            meu_evento.Menu();
        }
    }
}
class Usuario{

    private String Codigo;
    private String Nome;
    private String Fone;

    public Usuario(String c, String n, String f) {
        this.setCodigo(c);
        this.setNome(n);
        this.setFone(f);
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String fone) {
        this.Fone = fone;
    }

    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + " - Nome: " + this.getNome() + " - Fone: " + this.getFone();
    }

}
class Usuarios{


    public void Inserir(){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String c, n, f;

        char controle = 's';
        do {
            System.out.println("Entre com um Codigo:");
            c = teclado.next();
            System.out.println("Entre com um Nome:");
            n = teclado.next();
            System.out.println("Entre com um Telefone:");
            f = teclado.next();
            Usuario p = new Usuario(c,n, f);
            lista.add(p);
            System.out.println("Deseja cadastrar outro usuário? s ou S para sim.");
            controle = teclado.next().charAt(0);
        }while(controle == 's' || controle == 'S');

        for (Usuario i: lista){
            System.out.println(i.toString());
        }
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
        this.Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        this.Horario = horario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() + " - Endereco: " + this.getEndereco() + " - Categoria: " + this.getCategoria() + " - Horario: " + this.getHorario() + " - Descricao: " + this.getDescricao();
    }
}

class Eventos {
    ArrayList<Evento> eventos = new ArrayList<Evento>();
    public void Menu(){

        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        do{
            System.out.println(" 1 - Inserir");
            System.out.println(" 2 - Participar");
            System.out.println(" Digite sua opção: ");
            escolha = teclado.nextInt();
        }while (escolha != 1 && escolha != 2);

        Eventos meu_evento = new Eventos();
        if (escolha == 1)
        {
            meu_evento.Inserir();
        }
        if (escolha == 2)
        {
            meu_evento.Participar();
        }
    }
    public void Inserir(){

        String n, e, c, h, d;

        Scanner teclado = new Scanner(System.in);
        String[] categorias = {"1-Festa infantil", "2-Casamento", "3-Show"};

        char controle = 's';
        do{
            System.out.print("Entre com um Nome:");
            n = teclado.next();
            System.out.print("Entre com um Endereço:");
            e = teclado.next();
            System.out.print("Entre com uma Categoria: ");
            for(int i = 0 ; i < 3; i++){
                System.out.println(categorias[i]);
            }
            c = teclado.next();
            System.out.print("Entre com um Horario:");
            h = teclado.next();
            System.out.print("Entre com um Descrição:");
            d = teclado.next();

            Evento e1 = new Evento(n,e,c,h,d);
            eventos.add(e1);

            System.out.println("Deseja cadastrar outro evento? S-SiM N=Não");
            controle = teclado.next().charAt(0);
        }while (controle == 's' || controle == 'S');

        for (Evento i: eventos){
            System.out.println(i.toString());
        }

        Eventos meu_evento = new Eventos();
        meu_evento.Menu();
    }
    void Excluir(){
        Menu m_menu = new Menu();
        m_menu.MenuPrincipal();

    }
    public void Participar() {
        System.out.println("Entrou:");
        for (Evento e : eventos ) {
            System.out.println("Nome: " + e.getNome());
            System.out.println("Endereco: " + e.getEndereco());
            System.out.println("Categoria: " + e.getCategoria());
            System.out.println("Horario: " + e.getHorario());
            System.out.println("Descricao: " + e.getDescricao());
            System.out.println("Participar? S-SIM N-Não: ");

        }
    }
}