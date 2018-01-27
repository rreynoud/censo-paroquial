package br.com.censo.model.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.censo.model.Familia;
import br.com.censo.model.dao.AbstractDAO;
import br.com.censo.model.dao.FamilyDAO;

@Stateless
public class FamilyService extends AbstractService<Integer, Familia> {

	@Inject
	FamilyDAO dao;

	@Override
	public AbstractDAO<Integer, Familia> getDAO() {
		return this.dao;
	}

}
