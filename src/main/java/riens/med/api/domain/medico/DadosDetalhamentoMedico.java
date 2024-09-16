package riens.med.api.domain.medico;

import riens.med.api.domain.endereco.DadosEndereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone,
        Especialidade especialidade, DadosEndereco endereco) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
                medico.getEspecialidade(), new DadosEndereco(medico.getEndereco()));
    }

}
