package com.tt.potomemo.modules.poto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.potomemo.common.persistence.Page;
import com.tt.potomemo.common.service.CrudService;
import com.tt.potomemo.modules.poto.dao.CashDao;
import com.tt.potomemo.modules.poto.entity.Cash;

/**
 * cashService
 * @author dong
 * @version 2015-06-24
 */
@Service
@Transactional(readOnly = true)
public class CashService extends CrudService<CashDao, Cash> {

	public Cash get(String id) {
		return super.get(id);
	}
	
	public List<Cash> findList(Cash cash) {
		return super.findList(cash);
	}
	
	public Page<Cash> findPage(Page<Cash> page, Cash cash) {
		return super.findPage(page, cash);
	}
	
	@Transactional(readOnly = false)
	public void save(Cash cash) {
		super.save(cash);
	}
	
	@Transactional(readOnly = false)
	public void delete(Cash cash) {
		super.delete(cash);
	}
	
}