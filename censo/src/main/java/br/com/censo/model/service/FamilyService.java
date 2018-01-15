package br.com.censo.model.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.censo.model.Family;
import br.com.censo.model.dao.AbstractDAO;
import br.com.censo.model.dao.FamilyDAO;

@Stateless
public class FamilyService extends AbstractService<Integer, Family> {

	@Inject
	FamilyDAO dao;

	@Override
	public AbstractDAO<Integer, Family> getDAO() {
		return this.dao;
	}

}
