package com.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import com.capas.dao.EstudianteDAO;
import com.capas.domain.Estudiante;
import com.capas.service.EstudianteService;


@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante es ,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		if(!result.hasErrors()) {
			estudianteService.save(es);
		}
		return mav;
		
	}
	
	@RequestMapping("/listado")
	public ModelAndView mostrarEstudiantes() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante>estudiantes = null;
		try {
			estudiantes = estudianteService.findAll();
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("estudiante");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="/eliminar", method=RequestMethod.POST)
	public ModelAndView eliminarEstudiante(@RequestParam(value="codigo")int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		estudiantes = estudianteService.findAll();
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("estudiante");
		return mav;
	}
	
}
