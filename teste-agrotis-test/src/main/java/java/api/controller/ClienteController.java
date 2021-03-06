package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmtest.dev.Cliente;

import repository.ClienteService;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	
	@GetMapping
	public List<Cliente> listar () {
		return clienteService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(clienteService.getCliente(id));
	}

	
	@PostMapping
	public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente) {
		Cliente c = clienteService.salvarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.atualizarCliente(id, cliente));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}
}
