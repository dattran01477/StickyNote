package com.stickynote.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stickynote.algorithm.NoteUserQuickSortIncre;
import com.stickynote.algorithm.NoteUserQuickSortReduce;
import com.stickynote.dao.NoteUserDao;
import com.stickynote.dao.UserDao;
import com.stickynote.entity.Noteuser;
import com.stickynote.entity.User;
import com.stickynote.model.NoteUserDTO;
import com.stickynote.service.NoteUserService;
import com.stickynote.validator.NoteUserValidator;

@Controller
public class NoteUserController {

	@Autowired
	NoteUserService noteUserService;
	@Autowired
	UserDao userDao;
	@Autowired
	NoteUserValidator noteUserValidator;
	@Autowired
	NoteUserQuickSortIncre noteUserQuickSortIncre;
	@Autowired
	NoteUserQuickSortReduce noteUserQuickSortReduce;

	@RequestMapping(value = "/list-note", method = RequestMethod.GET)
	public String loadNote(Model model, HttpSession session) {

		List<NoteUserDTO> lsComple = new ArrayList<>();
		List<NoteUserDTO> lsNotComple = new ArrayList<>();

		// get user save in httpsession
		User user = (User) session.getAttribute("user");
		List<NoteUserDTO> list = noteUserService.getNoteForUser(user == null ? 1 : user.getId());/**/

		for (NoteUserDTO noteuser : list) {
			if (noteuser.getIsnoice() == 0) {
				lsNotComple.add(noteuser);
				System.out.println("comple" + noteuser.getNote());
			} else {
				lsComple.add(noteuser);
				System.out.println(noteuser.getNote());
			}
		}
		
		noteUserQuickSortIncre.quickSort(lsComple, 0,lsComple.size()-1);
		noteUserQuickSortReduce.quickSort(lsNotComple, 0,lsNotComple.size()-1);	
		
		model.addAttribute("lsComple",lsComple );
		model.addAttribute("lsNotComple", lsNotComple);
		model.addAttribute("noteUser", new NoteUserDTO());

		return "Todotolist";
	}

	@RequestMapping(value="/addNote",method=RequestMethod.POST)
	public String addNote(Model model,@ModelAttribute(value="noteUser") NoteUserDTO noteUserDTO,
			HttpSession session,BindingResult bindingResult)
	{
		//validata noteuser
		noteUserValidator.validate(noteUserDTO, bindingResult);
		if(bindingResult.hasErrors())
		{
			return "redirect:/list-note";/**/
		}
		
		User user=(User)session.getAttribute("user");
		if(user != null)
		{
			noteUserDTO.setUser(user);
		}
		else
		{
			noteUserDTO.setUser(userDao.getByid(1));
		}
		noteUserService.insert(noteUserDTO);
		
		return "redirect:/list-note";
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteNoteuser(Model model,
			@PathVariable(value="id") int id)
	{
		try {
			noteUserService.delete(id);
			
			return "redirect:/list-note";
		} catch (Exception e) {
			
			return "redirect:/list-note";
		}
		
	}
	
	@RequestMapping(value="/complete/{id}",method=RequestMethod.GET)
	public String complete(Model model,
			@PathVariable(value="id") int id)
	{
		try {
			noteUserService.updateToComplete(id);
			
			return "redirect:/list-note";
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			
			return "redirect:/list-note";
		}
	}
	
	@RequestMapping(value="/notcomplete/{id}",method=RequestMethod.GET)
	public String notComplete(Model model,
			@PathVariable(value="id") int id)
	{
		try {
			noteUserService.updateToNotComplete(id);
			
			return "redirect:/list-note";
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			
			return "redirect:/list-note";
		}
	}


}
