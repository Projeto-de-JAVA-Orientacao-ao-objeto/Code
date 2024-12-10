package service;

import database.CadastrarCursosDatabase;
import model.CadastrarCursosModel;

public class CadastrarCursosService {
    private CadastrarCursosDatabase cadastrarCursosDatabase;

    public CadastrarCursosService() {
        this.cadastrarCursosDatabase = new CadastrarCursosDatabase();
    }

    public void cadastrarCurso(CadastrarCursosModel curso) {

        cadastrarCursosDatabase.inserirCurso(curso); 
        
    }
}
