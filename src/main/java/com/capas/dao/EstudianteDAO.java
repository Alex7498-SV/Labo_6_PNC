package com.capas.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.capas.domain.Estudiante;


public interface EstudianteDAO {

	public List<Estudiante> findAll() throws DataAccessException;
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void insertarEstudiante(Estudiante es) throws DataAccessException;
}
