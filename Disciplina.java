public class Disciplina {
    private String nome;
    private Integer codigo, cargaHoraria;

    public Disciplina(String nome, Integer codigo, Integer cargaHoraria){
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }
    public String getNome(){
        return nome;
    }
    public Integer getCodigo(){
        return codigo;
    }
    public Integer getCargaHoraria(){
        return cargaHoraria;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }
    public void setCargaHoraria(Integer cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    public String toString(){
        return nome + " - " + cargaHoraria + "h.";
    }
}
