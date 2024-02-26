import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Usuario meusuario = new Usuario();
        meusuario.Inserir();
        meusuario.Excluir();

        Evento meuevento = new Evento();
        meuevento.Inserir();
        meuevento.Excluir();
    }
}

class Usuario{
    public String Nome;
    public String Endereco;
    public String Senha;
    void Inserir(){}
    void Excluir(){}

    public Usuario(String Nome, String Endereco, String Senha) {
        this.Nome = nome;
        this.Endereco = endereco;
        this.Senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getSenha() {
        return senha;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereco: " + endereco ", Senha: " + senha;
    }
}
class Evento{
    public String Nome;
    public String Endereco;
    public String Categoria;
    public String Horario;
    public String Descricao;
    void Inserir(){}
    void Excluir(){}

    public Evento(String Nome, String Endereco, String Categoria, String Horario, String Descricao) {
        this.Nome = nome;
        this.Endereco = endereco;
        this.Categoria = categoria;
        this.Horario = horario;
        this.Descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getCategoria() {
        return senha;
    }
    public String getHorario() {
        return horario;
    }
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereco: " + endereco ", Senha: " + senha ", Horario: " + horario ", Descricao: " + descricao;
    }
}