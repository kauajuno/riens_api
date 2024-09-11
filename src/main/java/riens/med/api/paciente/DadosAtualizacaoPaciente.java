package riens.med.api.paciente;

import riens.med.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {

}
