package com.stickynote.service;

import java.util.List;

import com.stickynote.entity.Noteuser;
import com.stickynote.model.NoteUserDTO;


public interface NoteUserService  {

	public List<NoteUserDTO> getAll() ;

	public NoteUserDTO getByid(Integer id);

	public boolean insert(NoteUserDTO objetc);

	public void update(NoteUserDTO noteUserDTO) ;

	public void delete(Integer id);

	public List<NoteUserDTO> getNoteForUser(int idUser);
	
	public int updateToComplete(int idNote); 
	
	public int updateToNotComplete(int idNote);
	
}
