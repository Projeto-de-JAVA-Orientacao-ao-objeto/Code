package service;

import database.CadastrarUsuariosDatabase;
import model.CadastrarUsuariosModel;

public class CadastrarUsuariosService {
    private CadastrarUsuariosDatabase CadastrarUsuariosDatabase;

    public CadastrarUsuariosService() {
        this.CadastrarUsuariosDatabase = new CadastrarUsuariosDatabase();
    }

    public void cadastrarUsuario(CadastrarUsuariosModel usuarios) {

        CadastrarUsuariosDatabase.inserirUsuario(usuarios); 

    }
}
