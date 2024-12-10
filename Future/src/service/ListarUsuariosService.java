package service;

import database.ListarUsuariosDatabase;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ListarUsuariosModel;

public class ListarUsuariosService {
    private ListarUsuariosDatabase listarUsuariosDatabase;

    public ListarUsuariosService() {
        this.listarUsuariosDatabase = new ListarUsuariosDatabase();
    }

    public void preencherTabelaUsuarios(DefaultTableModel model) {
        List<ListarUsuariosModel> usuarios = listarUsuariosDatabase.obterTodosUsuarios();

        for (ListarUsuariosModel usuario : usuarios) {
            model.addRow(new Object[]{
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getUsuario(),
                usuario.getSenha(),
                usuario.getIdentificacao(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getIdCurso(),
                usuario.getCurso(),
                usuario.getIdMateria(),
                usuario.getMateria()
            });
        }
    }
}
