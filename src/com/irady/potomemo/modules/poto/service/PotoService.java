package com.irady.potomemo.modules.poto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irady.potomemo.common.persistence.Page;
import com.irady.potomemo.common.service.CrudService;
import com.irady.potomemo.modules.poto.dao.PotoDao;
import com.irady.potomemo.modules.poto.entity.Poto;

/**
 * potoService
 * @author dong
 * @version 2015-07-26
 */
@Service
@Transactional(readOnly = true)
public class PotoService extends CrudService<PotoDao, Poto> {

	public Poto get(String id) {
		return super.get(id);
	}
	
	public List<Poto> findList(Poto poto) {
		return super.findList(poto);
	}
	
	public Page<Poto> findPage(Page<Poto> page, Poto poto) {
		return super.findPage(page, poto);
	}
	
	@Transactional(readOnly = false)
	public void save(Poto poto) {
		super.save(poto);
	}
	
	@Transactional(readOnly = false)
	public void delete(Poto poto) {
		super.delete(poto);
	}
	
}