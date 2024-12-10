package model;

public class CadastrarCursosModel {
    private String idCurso;
    private String idMateria;
    private String curso;
    private String materia;
    private String modulo;

    public CadastrarCursosModel(String idCurso, String idMateria, String curso, String materia, String modulo) {
        this.idCurso = idCurso;
        this.idMateria = idMateria;
        this.curso = curso;
        this.materia = materia;
        this.modulo = modulo;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}
