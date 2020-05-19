package com.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.dao.EstudianteDAO;
import com.capas.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.findOne(code);
	}

	@Override
	public void save(Estudiante es) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDAO.save(es);
	}

	@Override
	public void delete(Integer c_estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDAO.delete(c_estudiante);
	}

}
