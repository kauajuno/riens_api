package riens.med.api.domain.paciente;

import riens.med.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
                String nome,
                String email,
                String telefone,
                DadosEndereco endereco) {

}
