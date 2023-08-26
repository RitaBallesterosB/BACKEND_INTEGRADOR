package com.backend.proyclinicaodontologica.service.impl;



import com.backend.proyclinicaodontologica.dao.IDao;
import com.backend.proyclinicaodontologica.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.backend.proyclinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.proyclinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.proyclinicaodontologica.entity.Odontologo;
import com.backend.proyclinicaodontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OdontologoService implements IOdontologoService {
    private final IDao<Odontologo> odontologoIDao;
    private final ModelMapper modelMapper;

    public OdontologoService(IDao<Odontologo> odontologoIDao, ModelMapper modelMapper) {
        this.odontologoIDao = odontologoIDao;
        this.modelMapper = modelMapper;
    }

    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {
        return modelMapper.map(odontologoIDao.registrar(modelMapper.map(odontologo, Odontologo.class)), OdontologoSalidaDto.class);
    }

    public OdontologoSalidaDto buscarOdontologoPorId(int id) {
        return modelMapper.map(odontologoIDao.buscarPorId(id), OdontologoSalidaDto.class);
    }

    public List<OdontologoSalidaDto> listarOdontologos() {
        return odontologoIDao.listarTodos().stream().map(o -> modelMapper.map(o, OdontologoSalidaDto.class)).toList();
    }

    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }

    @Override
    public OdontologoSalidaDto modificarOdontologo(OdontologoModificacionEntradaDto odontologoModificado) {
        OdontologoSalidaDto odontologoSalidaDto = null;
        Odontologo odontologoAModificar = odontologoIDao.buscarPorId(odontologoModificado.getId());

        if (odontologoAModificar != null) {
            odontologoAModificar = dtoModificadoAEntidad(odontologoModificado);
            odontologoSalidaDto = entidadADtoSalida(odontologoIDao.modificar(odontologoAModificar));
        }
            return odontologoSalidaDto;
        }
    public Odontologo dtoEntradaAEntidad(OdontologoEntradaDto odontologoEntradaDto) {

        return modelMapper.map(odontologoEntradaDto, Odontologo.class);
    }

    public OdontologoSalidaDto entidadADtoSalida(Odontologo odontologo) {
        return modelMapper.map(odontologo, OdontologoSalidaDto.class);
    }

    public Odontologo dtoModificadoAEntidad(OdontologoModificacionEntradaDto odontologEntradaDto) {
        return modelMapper.map(odontologEntradaDto, Odontologo.class);
    }



}

