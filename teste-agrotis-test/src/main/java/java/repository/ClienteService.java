package repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmtest.dev.Cliente;

import exception.EntidadeNaoencontradaException;


@Service
public class ClienteService {
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// GET
	public List<Cliente> listar () {
		return clienteRepository.findAll();
	}
	
	// GET
	public Cliente getCliente(Long id) {
		return findOrFail(id);
	}
	
	//POST
	public Cliente salvarCliente(Cliente c) {
		c.getPropriedades().forEach(p -> p.setCliente(c));
		return clienteRepository.save(c);
	}
	
	// PUT
	public Cliente atualizarCliente(Long id, Cliente c) {
		Cliente clienteSalva = findOrFail(id);
		
		clienteSalva.getPropriedades().clear();
		clienteSalva.getPropriedades().addAll(c.getPropriedades());
		BeanUtils.copyProperties(c, clienteSalva, "id", "propriedades");
		return clienteRepository.save(clienteSalva);
	}
	
	// DELETE
	public void deletarCliente(Long id) {
		Cliente c = findOrFail(id);
		clienteRepository.delete(c);
	}
	
	
	
	
	
	private Cliente findOrFail(Long id) {
		return clienteRepository.findById(id).
				orElseThrow(() -> new EntidadeNaoencontradaException("Cliente não encontrado!"));
	}
	
	
}
