package com.stickynote.mapper;

import org.modelmapper.PropertyMap;

import com.stickynote.entity.Noteuser;
import com.stickynote.model.NoteUserDTO;

public class NoteUserMap extends PropertyMap<Noteuser, NoteUserDTO> {

	@Override
	protected void configure() {
		map().setIdUser(source.getUser().getId());
	}

	

}
