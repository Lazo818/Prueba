package pe.edu.delfines;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;

@SpringBootTest
class DelfinesApplicationTests {
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	void contextLoads() {
		try {
			Cliente cliente1 = new Cliente();
			cliente1.setDocumento("C10584");
			cliente1.setId(1);
			cliente1.setFechaNacimiento(new Date(1996,4,4));
			cliente1.setNombre("Samuel");
			cliente1.setObservacion("OK");
			cliente1.setLugarNacimiento("LIMA");
			
			
			Cliente cliente2 = new Cliente();
			cliente1.setDocumento("C17567777");
			cliente2.setId(2);
			cliente1.setFechaNacimiento(new Date(1996,7,7));
			cliente2.setNombre("Juan");
			cliente2.setObservacion("OK");
			
		
			
			cliente1 = clienteRepository.save(cliente1);
			cliente2 = clienteRepository.save(cliente2);
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setId(1);
			alquiler1.setPrecio(100.0f);
			alquiler1.setFechaEntrada(new Date(2019,12,8));
			alquiler1.setFechaSalida(new Date(2019,12,8));
			alquiler1.setEstado("Activo");
			alquiler1.setObservacion("OK");
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setId(1);
			alquiler2.setPrecio(150.0f);
			alquiler2.setFechaEntrada(new Date(2020,10,5));
			alquiler2.setFechaSalida(new Date(2020,10,1));
			alquiler2.setEstado("Activo");
			alquiler2.setObservacion("OK");
			
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);
			
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
