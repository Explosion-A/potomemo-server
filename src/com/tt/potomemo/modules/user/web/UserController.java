package com.tt.potomemo.modules.user.web;

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
import com.tt.potomemo.modules.user.entity.User;
import com.tt.potomemo.modules.user.service.UserService;

/**
 * 用户模块Controller
 * @author dong
 * @version 2015-07-20
 */
@Controller
@RequestMapping(value = "${adminPath}/user/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public User get(@RequestParam(required=false) String id) {
		User entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = userService.get(id);
		}
		if (entity == null){
			entity = new User();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<User> page = userService.findPage(new Page<User>(request, response), user); 
		System.out.println(page.getList().size());
		model.addAttribute("page", page);
		return "modules/user/userList";
	}

	@RequestMapping(value = "form")
	public String form(User user, Model model) {
		model.addAttribute("user", user);
		return "modules/user/userForm";
	}

	@RequestMapping(value = "save")
	public String save(User user, Model model, RedirectAttributes redirectAttributes) {
		/*if (!beanValidator(model, user)){
			return form(user, model);
		}*/
		userService.save(user);
		addMessage(redirectAttributes, "保存用户成功");
		return "redirect:"+Global.getAdminPath()+"/user/user/?repage";
	}
	
	@RequestMapping(value = "register")
	public String register(User user, Model model, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		int register = userService.register(user);
		return renderString(response, register);
	}
	
	@RequestMapping(value = "login")
	public String login(User user, Model model, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		User login = userService.login(user);
		return renderString(response, login);
	}
	
	@RequestMapping(value = "delete")
	public String delete(User user, RedirectAttributes redirectAttributes) {
		userService.delete(user);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/user/user/?repage";
	}

}