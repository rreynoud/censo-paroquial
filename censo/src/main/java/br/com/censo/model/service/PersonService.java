package br.com.censo.model.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.censo.model.Pessoa;
import br.com.censo.model.dao.AbstractDAO;
import br.com.censo.model.dao.PersonDAO;

@Stateless
public class PersonService extends AbstractService<Integer, Pessoa> {

	@Inject
	PersonDAO dao;

	@Override
	public AbstractDAO<Integer, Pessoa> getDAO() {
		return dao;
	}

}
