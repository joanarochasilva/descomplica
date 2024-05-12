package com.descomplica.escola.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
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

import com.descomplica.escola.entity.Turma;
import com.descomplica.escola.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

	@Operation(summary="Lista todas as turmas cadastradas no sistema.", description  = "Lista turmas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @GetMapping
    public ResponseEntity<List<Turma>> getAll(){
        List<Turma> turma = turmaService.getAll();

        if(!turma.isEmpty()) {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

	@Operation(summary="Retorna uma turma de acordo com um id fornecido.", description  = "Retorna turma.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@GetMapping("/{id}")
	public ResponseEntity<Turma> getById(@PathVariable Integer id) {
		Turma turma = turmaService.getById(id);
		if(turma != null)
			return new ResponseEntity<>(turma, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}

	@Operation(summary="Adiciona uma turma não cadastrada ao sistema.", description  = "Adiciona turma")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
	}

	@Operation(summary="Atualiza uma turma cadastrada no sistema de acordo com um id.", description  = "Atualiza turma")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@PutMapping("/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable Integer id, @RequestBody Turma turma) {
		Turma turmaAtualizada = turmaService.updateTurma(id, turma);
		if(turmaAtualizada != null)
			return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary="Deleta uma turma de acordo com um id fornecido.", description  = "Deleta turma.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Requisição Inválida"),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTurma(@PathVariable Integer id) {
		if(turmaService.deleteTurma(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}