import java.util.Scanner;

public class Gerente extends Funcionario{
    private String senha;
    private int qntGerenciados;

    public Gerente(String nome, String cpf, float salario, String senha, int qntGerenciados){
        super(nome, cpf, salario);
        this.senha = senha;
        this.qntGerenciados = qntGerenciados;
    }
    public float getBonificacao(){
        return salario * 15/100;        
    }
    public void setQntGerenciados(int qtde){
        qntGerenciados = qtde;
    }
    public int getQntGerenciados(){
        return qntGerenciados;
    }
    public void setSenha(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a senha antiga: ");
        if (this.senha.equals(input.nextLine())){
            System.out.println("Digite a nova senha: ");
            this.senha = input.nextLine();
        }
        input.close();
    }
}
