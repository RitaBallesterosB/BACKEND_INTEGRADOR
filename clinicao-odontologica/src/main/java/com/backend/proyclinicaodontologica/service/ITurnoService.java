package com.backend.proyclinicaodontologica.service;




import com.backend.proyclinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.proyclinicaodontologica.dto.salida.turno.TurnoSalidaDto;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto);
    List<TurnoSalidaDto> listarTurnos();
    TurnoSalidaDto buscarTurnoPorId(int id);
    void eliminarTurno(int id);
    //TurnoSalidaDto modificarTurno(completaraquieldto);

}


