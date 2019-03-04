package com.stickynote.dao;

import java.util.List;

import com.stickynote.entity.Noteuser;

public interface NoteUserDao extends GenericDao<Integer,Noteuser> {	
	
		public List<Noteuser> getNoteForUser(int idUser);
		
		public int updateToComplete(int idNote);
		
		public int updateToNotComplete(int idNote);
}
