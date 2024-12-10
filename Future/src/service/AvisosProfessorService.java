package service;

import database.AvisosProfessorDatabase;
import model.AvisosProfessorModel;

public class AvisosProfessorService {
    private AvisosProfessorDatabase database;

    public AvisosProfessorService() {
        this.database = new AvisosProfessorDatabase();
    }

    public AvisosProfessorModel buscarDadosProfessor(String nomeUsuario) {
        String[] data = database.buscarDadosProfessor(nomeUsuario); // Aqui a variável data é String[]
        if (data != null) {
            AvisosProfessorModel model = new AvisosProfessorModel();
            model.setIdMateria(data[0]);
            model.setMateria(data[1]);
            model.setProfessor(data[2]);
            return model; // Retorna o modelo, não o array de Strings
        }
        return null;
    }

    public boolean inserirAviso(AvisosProfessorModel aviso, String titulo, String mensagem) {
        return database.inserirAviso(
            aviso.getIdMateria(),
            aviso.getMateria(),
            aviso.getProfessor(),
            titulo,
            mensagem
        );
    }
}
