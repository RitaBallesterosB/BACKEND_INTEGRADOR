package com.backend.proyclinicaodontologica.controller;

import com.backend.proyclinicaodontologica.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.backend.proyclinicaodontologica.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.backend.proyclinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.proyclinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.proyclinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.proyclinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.proyclinicaodontologica.entity.Odontologo;
import com.backend.proyclinicaodontologica.service.IOdontologoService;
import com.backend.proyclinicaodontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    private final IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //POST
    @PostMapping("registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody OdontologoModificacionEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.modificarOdontologo(odontologo), HttpStatus.OK);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<OdontologoSalidaDto> obtenerOdontologoPorId(@PathVariable int id){
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologos(){
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable int id){
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo eliminado correctamente", HttpStatus.NO_CONTENT);
    }

}
