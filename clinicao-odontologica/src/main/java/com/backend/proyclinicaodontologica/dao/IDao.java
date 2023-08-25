package com.backend.proyclinicaodontologica.dao;

import org.springframework.stereotype.Component;

import java.util.List;

public interface IDao <T>{

    T registrar(T t);
    T buscarPorId(int id);
    void eliminar(int id);
    List<T> listarTodos();

    T modificar(T t);
}
