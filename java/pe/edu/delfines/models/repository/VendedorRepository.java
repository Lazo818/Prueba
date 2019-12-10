package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
	
	List<Vendedor> findByNombre(String nombre);
	/*
	@Query("Select cl from clientes cl where cl.sueldo > :sueldo")
	List<Vendedor> fetchMayorsueldo(float sueldo);*/
}
