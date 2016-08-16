package br.com.fiveseconds.quiz.model;

public class Alternativas {
    
    private int id;
    
    private String descricao;
    
    private String alterCorreta;
    
    private int idPerguntaFK;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAlterCorreta() {
        return alterCorreta;
    }

    public void setAlterCorreta(String alterCorreta) {
        this.alterCorreta = alterCorreta;
    }

    public int getIdPerguntaFK() {
        return idPerguntaFK;
    }

    public void setIdPerguntaFK(int idPerguntaFK) {
        this.idPerguntaFK = idPerguntaFK;
    }
    
    

}
