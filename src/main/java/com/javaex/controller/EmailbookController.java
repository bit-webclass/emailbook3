package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.EmailBookDao;
import com.javaex.vo.EmailBookVo;

@Controller
public class EmailbookController {
	
	private EmailBookDao dao = new EmailBookDao();
	
	@RequestMapping(value="/writeform", method=RequestMethod.GET)
	public String writeForm() {
		System.out.println("writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String write(@ModelAttribute EmailBookVo emailBookVo) {
		
		System.out.println(emailBookVo.toString());
		
		dao.insert(emailBookVo);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<EmailBookVo> list = dao.getList();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	
}
