package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFacade;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)

public class TarefasAPI {

@Autowired
private TarefasFacade tarefasFacade;

@PostMapping
@ResponseBody
public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
	return tarefasFacade.criar(tarefaDTO);
}

@PutMapping ("/{tarefaId}")
@ResponseBody
public TarefaDTO atualizar(@PathVariable("tarefasId") Long tarefaId,
							@RequestBody TarefaDTO tarefaDTO) {
	return tarefasFacade.atualizar(tarefaDTO, tarefaId);
}

@GetMapping
@ResponseBody
public List<TarefaDTO> getAll(){
	return tarefasFacade.getAll();
}
@DeleteMapping("/{tarefaId}")
@ResponseBody
public String deletar(@PathVariable("tarefaId") Long tarefaId) {
	return tarefasFacade.delete(tarefaId);
}

}
