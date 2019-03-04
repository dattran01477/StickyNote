package com.stickynote.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stickynote.dao.UserDao;
import com.stickynote.entity.User;
import com.stickynote.ultils.timeUltil;

public class test {
	@Autowired
	static UserDao userDao;

	@Autowired
	static SessionFactory sessionFactory;
	

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=timeUltil.CovertStringToDate("yyyy-MM-dd hh:mm:ss",timeUltil.getCurrentTime());
		Date date1=sdf.parse("2019-03-03 09:23:00");
		
		
		System.out.println(date.compareTo(date1));
	}

}
