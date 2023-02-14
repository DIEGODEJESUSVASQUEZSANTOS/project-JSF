/**
 * 
 */
package com.buenmaestro.project.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Diego de Jesus Vasquez Santos
 * Clase que nos permite controlar funcionamiento de la pantalla del login.xhtml
 *
 */
@ManagedBean
public class LoginController {
	/**
	 * usuario que ingresa en el login
	 */
	private String usuario;
	
	/**
	 * contraseñ usada en el login
	 */
	private String password;
	
	public void ingresar() {
		System.out.println("Usario: " + usuario);
		//FacesContext es una clase del API de JSF
		if(usuario.equals("depredador") && password.equals("12345")) {
			/*FacesContext.getCurrentInstance().addMessage("fornLogin: txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario correcto", ""));*/
			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("fornLogin: txtUsuario",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La pagina no existe", ""));
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			FacesContext.getCurrentInstance().addMessage("fornLogin: txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña son incorrecto", ""));
		}
			
	}
	
	private void redireccionar(String pagina) throws IOException  {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
