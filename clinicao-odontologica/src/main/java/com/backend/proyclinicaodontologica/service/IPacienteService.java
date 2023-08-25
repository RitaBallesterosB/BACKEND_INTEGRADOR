package com.backend.proyclinicaodontologica.service;

import com.backend.proyclinicaodontologica.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.backend.proyclinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.proyclinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.proyclinicaodontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    PacienteSalidaDto buscarPacientePorId(int id);

    void eliminarPaciente(int id);

    PacienteSalidaDto modificarPaciente(PacienteModificacionEntradaDto pacienteModificado);



}
