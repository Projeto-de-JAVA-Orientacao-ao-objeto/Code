package strategy;

import database.AtividadesAlunoDatabase;

public class ValidacaoEntregueAluno implements ValidacaoAtividadeAluno {
    private AtividadesAlunoDatabase database;

    public ValidacaoEntregueAluno(AtividadesAlunoDatabase database) {
        this.database = database;
    }

    @Override
    public boolean validar(String nomeUsuario, String nomeAtividade) {
        String status = database.obterStatusEntrega(nomeUsuario, nomeAtividade);
        return !"entregue".equalsIgnoreCase(status); // Retorna `false` se já foi entregue
    }
}
