package com.backend.proyclinicaodontologica.service;




import com.backend.proyclinicaodontologica.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.backend.proyclinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.proyclinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;

import java.util.List;

public interface IOdontologoService {
    List<OdontologoSalidaDto> listarOdontologos();


    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    OdontologoSalidaDto buscarOdontologoPorId(int id);

    void eliminarOdontologo(int id);

    OdontologoSalidaDto modificarOdontologo(OdontologoModificacionEntradaDto odontologoModificado);

}
