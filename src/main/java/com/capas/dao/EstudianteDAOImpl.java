package com.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.capas.dao.EstudianteDAO;
import com.capas.domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resulset = query.getResultList();
		return resulset;
		
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		return estudiante;
	}

	@Override
	@Transactional
	public void insertarEstudiante(Estudiante es) throws DataAccessException {
		entityManager.persist(es);		
	}

	@Override
	@Transactional
	public void save(Estudiante es) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(es.getC_usuario() == null) {
				entityManager.persist(es);
			}
			else {
				entityManager.merge(es);
				entityManager.flush();
			}
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer c_estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class, c_estudiante);
		entityManager.remove(estudiante);
		
	}
	
	
}
