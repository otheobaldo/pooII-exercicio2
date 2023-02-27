public class Funcionario{
    private String nome, cpf;
    protected float salario;

    public Funcionario(String nome, String cpf, float salario){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario; 
    }
    public float getBonificacao(){
        return salario*10/100;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }
    public float getSalario(){
        return salario;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
}