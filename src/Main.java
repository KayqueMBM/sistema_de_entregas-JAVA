import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        opcoesIniciais();
    }

    public static void opcoesLogin(){
        System.out.println("""
                1- Participar de eventos
                2- Eventos já confirmados
                3- Cancelar participação em evento
                Escolha a ação:
                """);
        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }
    public static void opcoesIniciais() throws FileNotFoundException {
        System.out.println("Sistema de Eventos da Cidade Joinville - MENU");
        System.out.println("""
                1- Cadastro de Usuário
                2- Cadastro de Evento
                3- Login
                Escolha a ação:
                """);
        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                Usuarios meu_usuario = new Usuarios();
                meu_usuario.Inserir();
                opcoesIniciais();
                break;
            case 2:
                Eventos meu_evento = new Eventos();
                meu_evento.Inserir();
                opcoesIniciais();
                break;
            case 3:
                login();
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }
    public static void login() throws FileNotFoundException {
        System.out.println("Digite seu CPF:");
        String cpf = sc.next();
        System.out.println("Digite sua senha:");
        String senha = sc.next();

        Usuarios usuario = new Usuarios();
        if (usuario.Estalogado(cpf,senha)) {
            System.out.println("Login bem-sucedido.");
            opcoesLogin();
        } else {
            System.out.println("CPF ou senha incorretos.");
            opcoesIniciais();
        }
    }
}
class Arquivo{

    public void Gravar(String nomedoArquivo, String conteudo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomedoArquivo))) {
            writer.write(conteudo);
            System.out.println("Arquivo gravado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }

    //Ler o arquivo//
    public String Ler(String nomedoArquivo) throws FileNotFoundException
    {
        File file = new File(nomedoArquivo);
        Scanner scan = new Scanner(file);

        String conteudo = "";
        while(scan.hasNextLine()) {
            conteudo = conteudo.concat(scan.nextLine() + "\n");
        }
        return conteudo;
    }
}
class Usuario{

    private String Nome;
    private String CPF;
    private String Senha;

    public Usuario(String nome, String cpf, String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSenha(senha);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCpf() {
        return CPF;
    }

    public void setCpf(String cpf) {
        this.CPF = cpf;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() + " - CPF: " + this.getCpf() + " - Senha: " + this.getSenha();
    }

}
class Usuarios{

    public void Inserir(){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        System.out.println("Entre com Nome:");
        String nome = teclado.next();
        System.out.println("Entre com CPF:");
        String cpf = teclado.next();
        System.out.println("Entre com Senha:");
        String senha = teclado.next();
        Usuario p = new Usuario(nome,cpf,senha);
        lista.add(p);

        //Gravar usuario no arquivo texto
        Arquivo arq = new Arquivo();
        String texto = "";

        for (Usuario i: lista){
            texto = texto.concat(i.toString() + "\n");
        }
        arq.Gravar("c:\\temp\\usuarios.data.txt", texto);

    }

    public boolean Estalogado(String cpf, String senha) throws FileNotFoundException {

        Arquivo arq = new Arquivo();
        String texto = arq.Ler("c:\\temp\\usuarios.data.txt");
        Boolean temcpf = texto.contains(cpf);
        Boolean temsenha = texto.contains(cpf);

        Boolean ret = true;
        if (temcpf && temsenha){
            ret = true;
        }else{
            ret = false;
        }
        return ret;
    }
}
class Evento {
    public String Nome;
    public String Endereco;
    public String Categoria;
    public LocalDateTime DataHora;
    public String Descricao;

    public Evento(String nome, String endereco, String categoria, LocalDateTime datahora, String descricao) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setCategoria(categoria);
        this.setDataHora(datahora);
        this.setDescricao(descricao);
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

    public LocalDateTime getDataHora() {
        return DataHora;
    }

    public void setDataHora(LocalDateTime datahora) {
        this.DataHora = datahora;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() + " - Endereco: " + this.getEndereco() + " - Categoria: " + this.getCategoria() + " - Data/Hora: " + this.getDataHora() + " - Descricao: " + this.getDescricao();
    }
}

class Eventos {
    ArrayList<Evento> eventos = new ArrayList<Evento>();
    public void Inserir(){

        Scanner teclado = new Scanner(System.in);
        String[] categorias = {"1-Festa infantil", "2-Casamento", "3-Show"};

        char controle = 's';
        do{
            System.out.print("Entre com um Nome:");
            String nome = teclado.next();
            System.out.print("Entre com um Endereço:");
            String endereco = teclado.next();
            System.out.print("Entre com uma Categoria: ");
            for(int i = 0 ; i < 3; i++){
                System.out.println(categorias[i]);
            }
            String categoria = teclado.next();
            System.out.println("Entre com a data do evento no formato dd/MM/yyyy:");
            String dataEventoStr = teclado.next();
            System.out.println("Entre com o horário no seguinte formato HH:mm:ss");
            String horario = teclado.next();
            System.out.print("Entre com um Descrição:");
            String descricao = teclado.next();

            String dateTimeStr = dataEventoStr + " " + horario;
            LocalDateTime dataHora = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            Evento e1 = new Evento(nome,endereco,categoria,dataHora,descricao);
            eventos.add(e1);

            System.out.println("Deseja cadastrar outro evento? S-SiM N=Não");
            controle = teclado.next().charAt(0);
        }while (controle == 's' || controle == 'S');

        Arquivo arq = new Arquivo();
        String texto = "";
        for (Evento i: eventos){
            texto = texto.concat(i.toString() + "\n");
        }
        arq.Gravar("c:\\temp\\eventos.data.txt", texto);

    }

    public void Participar() throws FileNotFoundException {
        // Ler o arquivo eventos.data
        Arquivo arq = new Arquivo();
        String retorno;
        retorno = arq.Ler("c:\\temp\\eventos.data.txt");
        System.out.println(retorno);
        // mostrar na tela o conteudo do arquivo + opcao participar
    }
}