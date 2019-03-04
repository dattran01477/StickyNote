package com.stickynote.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stickynote.constants.AppConstants;
import com.stickynote.dao.NoteUserDao;
import com.stickynote.entity.Noteuser;
import com.stickynote.mapper.NoteUserMap;
import com.stickynote.model.NoteUserDTO;
import com.stickynote.service.NoteUserService;
import com.stickynote.ultils.timeUltil;

@Service
@Transactional
public class NoteUserServiceImpl implements NoteUserService {

	@Autowired
	private NoteUserDao noteUserDao;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<NoteUserDTO> getNoteForUser(int idUser) {
		
		NoteUserDTO noteUserDTO=null;
		List<NoteUserDTO> lsDTO=new ArrayList<>();
		List<Noteuser> lsEntity=noteUserDao.getNoteForUser(idUser);
		
		for (Noteuser noteuser : lsEntity) {
			noteUserDTO=new NoteUserDTO();		
			modelMapper.map(noteuser, noteUserDTO);
			lsDTO.add(noteUserDTO);
		}
		
		return lsDTO;
	}

	@Override
	public List<NoteUserDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteUserDTO getByid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(NoteUserDTO objetc) {
		
		Noteuser noteUserEntity=new Noteuser();
		
		try {
			objetc.setCreatedate(timeUltil.CovertStringToDate(AppConstants.typeFormatTime, timeUltil.getCurrentTime()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		modelMapper.map(objetc, noteUserEntity);
		
		try {
			noteUserDao.insert(noteUserEntity);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return false;	
	}

	@Override
	public void update(NoteUserDTO objetc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {

		noteUserDao.delete(id);
		
	}

	@Override
	public int updateToComplete(int idNote) {

		return noteUserDao.updateToComplete(idNote);
	}

	@Override
	public int updateToNotComplete(int idNote) {
	
		return noteUserDao.updateToNotComplete(idNote);
	}
	
	

}
