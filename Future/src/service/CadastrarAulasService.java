package service;

import database.CadastrarAulasDatabase;
import model.CadastrarAulasModel;

public class CadastrarAulasService {
    private CadastrarAulasDatabase cadastrarAulasDatabase;

    public CadastrarAulasService() {
        this.cadastrarAulasDatabase = new CadastrarAulasDatabase();
    }

    public void cadastrarAula(CadastrarAulasModel aula) {
        cadastrarAulasDatabase.inserirAula(aula); // Passa o objeto diretamente
    }
}
