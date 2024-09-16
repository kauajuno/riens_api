package riens.med.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import riens.med.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid DadosEndereco endereco,
        @NotBlank @Pattern(regexp = "\\d{8,9}") String telefone) {

}
