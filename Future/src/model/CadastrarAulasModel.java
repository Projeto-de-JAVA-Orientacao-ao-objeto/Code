package model;

public class CadastrarAulasModel {
    private String idMateria;
    private String materia;
    private String horarioInicio;
    private String horarioFim;
    private String dia;
    private String periodo;
    private String linkSaladeAula;

    // Construtor
    public CadastrarAulasModel(String idMateria, String materia, String horarioInicio, String horarioFim, String dia, String periodo, String linkSaladeAula) {
        this.idMateria = idMateria;
        this.materia = materia;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.dia = dia;
        this.periodo = periodo;
        this.linkSaladeAula = linkSaladeAula;
    }

    // Getters e setters
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

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getlinkSaladeAula() {
        return linkSaladeAula;
    }

    public void setlinkSaladeAula(String linkSaladeAula) {
        this.linkSaladeAula = linkSaladeAula;
    }

    @Override
    public String toString() {
        return "CadastrarAulasModel{" +
                "idMateria='" + idMateria + '\'' +
                ", materia='" + materia + '\'' +
                ", horarioInicio='" + horarioInicio + '\'' +
                ", horarioFim='" + horarioFim + '\'' +
                ", dia='" + dia + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
