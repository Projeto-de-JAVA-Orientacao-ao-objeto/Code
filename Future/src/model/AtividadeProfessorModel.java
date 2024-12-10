package model;

public class AtividadeProfessorModel {
    private String idMateria;
    private String materia;
    private String professor;
    private String nomeAtividade;
    private String pergunta;
    private String dataEntrega;
    private String nota;

    // Construtor
    public AtividadeProfessorModel(String idMateria, String materia, String professor,
                                   String nomeAtividade, String pergunta, String dataEntrega, String nota) {
        this.idMateria = idMateria;
        this.materia = materia;
        this.professor = professor;
        this.nomeAtividade = nomeAtividade;
        this.pergunta = pergunta;
        this.dataEntrega = dataEntrega;
        this.nota = nota;
    }

    // Getters e Setters
    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
