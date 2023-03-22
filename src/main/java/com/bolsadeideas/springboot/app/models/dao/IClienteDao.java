package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	//Metodo para buscar por id 
	public Cliente findOne(Long id);
	
	//metodo eliminar
	public void delete(Long id);

}
