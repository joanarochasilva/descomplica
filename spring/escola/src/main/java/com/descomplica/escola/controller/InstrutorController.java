package com.descomplica.escola.controller;
import java.util.List;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
import org.springframework.web.bind.annotation.RestController;

import com.descomplica.escola.entity.Instrutor;
import com.descomplica.escola.service.InstrutorService;

import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
	@Autowired
    InstrutorService instrutorService;


	@GetMapping
	@Operation(summary="Listar todas as categorias", description  = "Listagem de Categorias")
	@ApiResponses(value = {
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})

    public ResponseEntity<List<Instrutor>> getAll(){
        List<Instrutor> instrutor = instrutorService.getAll();

        if(!instrutor.isEmpty()) {
            return new ResponseEntity<>(instrutor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


	@GetMapping("/{id}")
	@Operation(summary="Retorna o instrutor pelo seu id", description  = "Retorna instrutor pelo id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
		Instrutor turma = instrutorService.getById(id);
		if(turma != null)
			return new ResponseEntity<>(turma, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}

	@Operation(summary="Adiciona novo instrutor", description  = "Adiciona o Instrutor")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@PostMapping
	public ResponseEntity<Instrutor> saveInstrutor(@RequestBody Instrutor instrutor) {
		return new ResponseEntity<>(instrutorService.saveInstrutor(instrutor), HttpStatus.CREATED);
	}

	@Operation(summary="Atualiza um instrutor existente no sistema ao fornecer seu id.", description  = "Atualiza instrutor.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@PutMapping("/{id}")
	public ResponseEntity<Instrutor> updateInstrutor(@PathVariable Integer id, @RequestBody Instrutor instrutor) {
		Instrutor instrutorAtualizada = instrutorService.updateInstrutor(id, instrutor);
		if(instrutorAtualizada != null)
			return new ResponseEntity<>(instrutorAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary="Deleta um instrutor da lista de instrutores ao fornecer seu id.", description  = "Deleta Instrutor")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteInstrutor(@PathVariable Integer id) {
		if(instrutorService.deleteInstrutor(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}


}
