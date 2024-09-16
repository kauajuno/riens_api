package riens.med.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import riens.med.api.domain.endereco.DadosEndereco;

// DTO
public record DadosCadastroMedico(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{8,9}") String telefone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco) {

}
