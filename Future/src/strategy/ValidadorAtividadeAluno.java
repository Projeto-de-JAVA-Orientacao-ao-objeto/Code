package strategy;

import java.util.ArrayList;
import java.util.List;

public class ValidadorAtividadeAluno {
    private List<ValidacaoAtividadeAluno> validacoes;

    public ValidadorAtividadeAluno() {
        this.validacoes = new ArrayList<>();
    }

    public void adicionarValidacao(ValidacaoAtividadeAluno validacao) {
        validacoes.add(validacao);
    }

    public boolean validar(String nomeUsuario, String nomeAtividade) {
        for (ValidacaoAtividadeAluno validacao : validacoes) {
            if (!validacao.validar(nomeUsuario, nomeAtividade)) {
                return false;
            }
        }
        return true; // Retorna `true` se todas as validações passarem
    }
}
