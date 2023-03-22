package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
	if (cliente.getId() != null && cliente.getId() > 0) {
		em.merge(cliente); // El metodo merge realiza actualizacion de datos existentes
	}else {
		em.persist(cliente); // metodo persist crea un nuevo cliente
	}
		
		
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	
	
	@Override
	public void delete(Long id) {
		//obtener el cliente con el metodo findOne
		Cliente cliente = findOne(id);
		em.remove(cliente);
		
		//mas sinplificado serioa
		//em.remove(findOne(id));
		
	}

}