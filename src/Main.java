import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

    public String Codigo;
    public String Nome;
    public String Fone;
}
class Usuarios{

    Usuario s1 = new Usuario();
    public void Inserir(){

        s1.Codigo = "1";
        s1.Nome = "Marcelo";
        s1.Fone = "999156237";

        Consultar();
    }
    public void Consultar(){
        System.out.println(s1.Nome);
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
    public void Menu(){

        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        do{
            System.out.println(" 1 - Inserir");
            System.out.println(" 2 - Consultar");
            System.out.println(" 3 - Consultar");
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
    void Inserir(){}
    void Excluir(){}

}