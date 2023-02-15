/**
 * 
 */
package com.buenmaestro.project.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.buenmaestro.project.entity.Empleado;
import com.buenmaestro.project.services.EmpleadoService;


/**
 * @author dvs25 Clase controller se encarga de procesar la informacio para la
 *         pantalla principal.xhtml
 */

@ManagedBean
@ViewScoped//para mantener la informacion del contenido de mi pantalla
public class PrincipalController {
	/**
	 * 
	 * Lista de empleados para la tabla
	 *
	 */
	private List<Empleado> empleados;
	/**
	 * 
	 * SErvicio con los metodos que realizan la logica de negocio de empleados
	 *
	 */
	
	private EmpleadoService empleadoService = new EmpleadoService();
	
	@PostConstruct
	public void init() {
		this.consultarEmpleados();
		
	}
	
	/**
	 * 
	 * Metodo que consulta la lista de empleados
	 *
	 */
	public void consultarEmpleados() {
		this.empleados = this.empleadoService.consultarEmpleados();
		
	}
	

	/**
	 * @return the empleados
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	

}
