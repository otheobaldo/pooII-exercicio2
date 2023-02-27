import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private Integer matricula;
    private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

    public Aluno(String nome, Integer matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    public Integer getMatricula(){
        return matricula;
    }
    public String getNome(){
        return nome;
    }
    public void setMatricula(Integer matricula){
        this.matricula = matricula;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void cursarDisciplina(Disciplina x){
        listaDisciplinas.add(x);
    }
    public void exibirDisciplinas(){
        System.out.print(nome);
        for(Disciplina x : listaDisciplinas){
            System.out.println(x);
        }
    }
}
