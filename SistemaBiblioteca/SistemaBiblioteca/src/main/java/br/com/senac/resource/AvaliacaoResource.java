package br.com.senac.resource;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoDisciplina;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Disciplina;
import br.com.senac.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService service;


	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> listarAvaliacao(){
		List<Avaliacao> listaAvaliacao = service.findAll();
		return ResponseEntity.ok().body(listaAvaliacao);

	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir (@RequestBody Avaliacao objAvaliacao){

		Map<String,Object> params = new HashMap();

		objAvaliacao = service.save(objAvaliacao);
		UriComponentsBuilder uriBuilder = ServletUriComponentsBuilder.fromCurrentContextPath();
		uriBuilder.path("/{idAluno}/{idDisciplina}");
		params.put("idAluno",objAvaliacao.getAlunoDisciplina().getAluno().getId());
		params.put("idDisciplina", objAvaliacao.getAlunoDisciplina().getDisciplina().getId());
		URI uri = uriBuilder.buildAndExpand(params).toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value="/{idAluno}/{idDisciplina}" , method=RequestMethod.GET)
	public ResponseEntity<Avaliacao> buscarAvaliacaoAlunoPorDisciplina(@PathVariable Integer idAluno,@PathVariable Integer idDisciplina){
		Aluno aluno = new Aluno();
		aluno.setId(idAluno);

		Disciplina disciplina = new Disciplina();
		disciplina.setId(idDisciplina);


		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		alunoDisciplina.setAluno(aluno);
		alunoDisciplina.setDisciplina(disciplina);

		Avaliacao avaliacao = service.buscarNotaAlunoDisciplina(alunoDisciplina);

		return ResponseEntity.ok().body(avaliacao);

	}





}
