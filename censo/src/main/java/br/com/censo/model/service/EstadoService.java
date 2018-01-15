package br.com.censo.model.service;



import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.censo.model.Estado;
import br.com.censo.model.dao.AbstractDAO;
import br.com.censo.model.dao.EstadoDAO;

@Stateless
public class EstadoService extends AbstractService<String, Estado> {
    @Inject
    private EstadoDAO dao;

    @Override
    public AbstractDAO<String, Estado> getDAO() {
        return this.dao;
    }
}