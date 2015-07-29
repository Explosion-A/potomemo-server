package com.tt.potomemo.modules.poto.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tt.potomemo.common.config.Global;
import com.tt.potomemo.common.persistence.Page;
import com.tt.potomemo.common.utils.StringUtils;
import com.tt.potomemo.common.web.BaseController;
import com.tt.potomemo.modules.poto.entity.Poto;
import com.tt.potomemo.modules.poto.service.PotoService;

/**
 * potoController
 * @author dong
 * @version 2015-07-26
 */
@Controller
@RequestMapping(value = "${adminPath}/poto/poto")
public class PotoController extends BaseController {

	@Autowired
	private PotoService potoService;
	
	@ModelAttribute
	public Poto get(@RequestParam(required=false) String id) {
		Poto entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = potoService.get(id);
		}
		if (entity == null){
			entity = new Poto();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Poto poto, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Poto> page = potoService.findPage(new Page<Poto>(request, response), poto); 
		model.addAttribute("page", page);
		return "modules/poto/potoList";
	}

	@RequestMapping(value = "form")
	public String form(Poto poto, Model model) {
		model.addAttribute("poto", poto);
		return "modules/poto/potoForm";
	}

	@RequestMapping(value = "save")
	public String save(Poto poto, Model model, RedirectAttributes redirectAttributes) {
		/*if (!beanValidator(model, poto)){
			return form(poto, model);
		}*/
		potoService.save(poto);
		addMessage(redirectAttributes, "保存poto成功");
		return "redirect:"+Global.getAdminPath()+"/poto/poto/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Poto poto, RedirectAttributes redirectAttributes) {
		potoService.delete(poto);
		addMessage(redirectAttributes, "删除poto成功");
		return "redirect:"+Global.getAdminPath()+"/poto/poto/?repage";
	}

}