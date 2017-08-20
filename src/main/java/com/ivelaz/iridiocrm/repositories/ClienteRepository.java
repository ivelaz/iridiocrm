package com.ivelaz.iridiocrm.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ivelaz.iridiocrm.entities.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{

	public abstract Cliente findById(int id);
	
	// Lista todos los clientes cuyo nombre contenga la palabra clave:
	@Query(value = "SELECT * FROM clientes WHERE nombre LIKE %:palabraClave%",
			nativeQuery = true)
	public List<Cliente> buscarPorNombre(@Param("palabraClave") String palabraClave);
	
}
