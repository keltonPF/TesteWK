package br.com.wk.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wk.testejava.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findById(long id);
}
