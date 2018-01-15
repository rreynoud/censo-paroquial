package br.com.censo.model.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.censo.model.Person;
import br.com.censo.model.dao.AbstractDAO;
import br.com.censo.model.dao.PersonDAO;

@Stateless
public class PersonService extends AbstractService<Integer, Person> {

	@Inject
	PersonDAO dao;

	@Override
	public AbstractDAO<Integer, Person> getDAO() {
		return dao;
	}

}
