package riens.med.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import riens.med.api.domain.paciente.DadosAtualizacaoPaciente;
import riens.med.api.domain.paciente.DadosCadastroPaciente;
import riens.med.api.domain.paciente.DadosListagemPaciente;
import riens.med.api.domain.paciente.Paciente;
import riens.med.api.domain.paciente.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarPaciente(@PathVariable Long id, @RequestBody DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.desativar();
    }
}
