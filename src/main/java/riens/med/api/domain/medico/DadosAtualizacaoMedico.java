package riens.med.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import riens.med.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {

}
