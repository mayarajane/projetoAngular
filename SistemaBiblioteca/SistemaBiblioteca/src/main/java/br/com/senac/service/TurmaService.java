package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repo;


	//criar metodo de listar todas as turmas
	public List<Turma> listaTodasTurmas(){
		return repo.findAll();
	}


	public Page<Turma> buscaPorPaginacao(int pagina,int linhasPorPagina,String direction,String orderBy){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return new PageImpl<>(repo.findAll(),pageRequest,linhasPorPagina);
	}



	//criar um metodo para trazer uma turma por id
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = repo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(null, "Turma não encontrada"));
	}



	//criar um metodo para inserir a turma
	public Turma salvar(Turma turma) {
		return repo.save(turma);
	}




	//criar um metodo para fazer update da turma
	public Turma alterar(Turma objTurma) {
		Turma turma = buscaPorID(objTurma.getId());
		turma.setNome(objTurma.getNome());
		return salvar(turma);
	}


	//criar um metodo para excluir a turma
	public void excluir(Integer id) {
		repo.deleteById(id);
	}




}
