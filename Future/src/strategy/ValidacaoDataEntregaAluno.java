package strategy;

import database.AtividadesAlunoDatabase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidacaoDataEntregaAluno implements ValidacaoAtividadeAluno {
    private AtividadesAlunoDatabase database;

    public ValidacaoDataEntregaAluno(AtividadesAlunoDatabase database) {
        this.database = database;
    }

    @Override
    public boolean validar(String nomeUsuario, String nomeAtividade) {
        String dataEntregaStr = database.obterDataEntrega(nomeAtividade);
        if (dataEntregaStr != null) {
            LocalDate dataEntrega = LocalDate.parse(dataEntregaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return !LocalDate.now().isAfter(dataEntrega); // Retorna `false` se a data já passou
        }
        return true; // Permite se não houver data definida
    }
}
