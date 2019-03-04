package com.stickynote.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynote.constants.AppConstants;
import com.stickynote.dao.NoteUserDao;
import com.stickynote.entity.Noteuser;
import com.stickynote.ultils.timeUltil;

@Repository
@Transactional
public class NoteUserImpl extends AbstractDao<Integer, Noteuser> implements NoteUserDao {

	@Override
	public List<Noteuser> getNoteForUser(int idUser) {
		String sql="FROM Noteuser E WHERE E.user.id=:idUser";
		Query query=sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("idUser", idUser);
		return query.list();
	}

	@Override
	public int updateToComplete(int idNote) {
		String sql="Update Noteuser set isnoice=1,createdate=:currentDate WHERE id=:idNote";
		Query query=sessionFactory.getCurrentSession().createQuery(sql);
		try {
			query.setParameter("currentDate",timeUltil.CovertStringToDate(AppConstants.typeFormatTime, timeUltil.getCurrentTime()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		query.setParameter("idNote", idNote);
		
		return query.executeUpdate();	
	}

	@Override
	public int updateToNotComplete(int idNote) {
		String sql="Update Noteuser set isnoice=0,createdate=:currentDate WHERE id=:idNote";
		Query query=sessionFactory.getCurrentSession().createQuery(sql);
		try {
			query.setParameter("currentDate",timeUltil.CovertStringToDate(AppConstants.typeFormatTime, timeUltil.getCurrentTime()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		query.setParameter("idNote", idNote);
		
		return query.executeUpdate();
	}

	

}
