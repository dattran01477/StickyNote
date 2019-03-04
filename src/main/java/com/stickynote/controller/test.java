package com.stickynote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stickynote.dao.NoteUserDao;
import com.stickynote.dao.RoleDao;
import com.stickynote.dao.UserDao;
import com.stickynote.dao.impl.NoteUserImpl;
import com.stickynote.entity.Noteuser;
import com.stickynote.entity.Role;

@Controller
public class test {

@Autowired
NoteUserDao userDao;
@Autowired
UserDao user1;
	/*@Autowired
	SessionFactory sessionFactory;*/
	@RequestMapping("/hello")
	public String hello(Model model)
	{
		System.out.println("xin");
		
				
		
		
		List<Noteuser> list=userDao.getNoteForUser(1);
		
		for (Noteuser user : list) {
			System.out.println(user.getNote());
		}
		
		/*Criteria criteria=sessionFactory.getCurrentSession().createCriteria("User".getClass());
		System.out.println("hí");
		List<User> list= criteria.list();
		for (User user : list) {
			System.out.println(user.getUsername());
		}*/
		model.addAttribute("msg","xin chào");
		return "Note";
	}
}
