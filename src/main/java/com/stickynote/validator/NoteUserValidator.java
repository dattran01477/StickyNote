package com.stickynote.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.stickynote.model.NoteUserDTO;



public class NoteUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return NoteUserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		NoteUserDTO noteUserDTO=(NoteUserDTO) target;
		if(noteUserDTO.getNote()==null||noteUserDTO.getNote().length()==0)
		{
			errors.rejectValue("note","filed.required.noteuser.note");
		}
		
	}

	
}
