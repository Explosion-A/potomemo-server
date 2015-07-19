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

import redis.clients.jedis.Jedis;

import com.tt.potomemo.common.config.Global;
import com.tt.potomemo.common.persistence.Page;
import com.tt.potomemo.common.utils.CacheUtils;
import com.tt.potomemo.common.utils.JedisUtils;
import com.tt.potomemo.common.utils.StringUtils;
import com.tt.potomemo.common.web.BaseController;
import com.tt.potomemo.modules.poto.entity.Cash;
import com.tt.potomemo.modules.poto.service.CashService;

/**
 * cashController
 * @author dong
 * @version 2015-06-24
 */
@Controller
@RequestMapping(value = "${adminPath}/cash/cash")
public class CashController extends BaseController {

	@Autowired
	private CashService cashService;
	
	@ModelAttribute
	public Cash get(@RequestParam(required=false) String id) {
		Cash entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cashService.get(id);
		}
		if (entity == null){
			entity = new Cash();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Cash cash, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Cash> page = cashService.findPage(new Page<Cash>(request, response), cash); 
		
		JedisUtils.set("dongwangcheng", "18826410895", 24*60*60);
		System.out.println(JedisUtils.get("dongwangcheng"));
		
		model.addAttribute("page", page);
		return "modules/cash/cashList";
	}

	@RequestMapping(value = "form")
	public String form(Cash cash, Model model) {
		model.addAttribute("cash", cash);
		return "modules/cash/cashForm";
	}

	@RequestMapping(value = "save")
	public String save(Cash cash, Model model, RedirectAttributes redirectAttributes) {
		/*if (!beanValidator(model, cash)){
			return form(cash, model);
		}*/
		cashService.save(cash);
		addMessage(redirectAttributes, "保存cash成功");
		return "redirect:"+Global.getAdminPath()+"/cash/cash/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Cash cash, RedirectAttributes redirectAttributes) {
		cashService.delete(cash);
		addMessage(redirectAttributes, "删除cash成功");
		return "redirect:"+Global.getAdminPath()+"/cash/cash/?repage";
	}

}