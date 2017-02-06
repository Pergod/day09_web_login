package junit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.itcast.bean.User;
import com.itcast.dao.impl.UserDaoImpl;

public class Daotest {
	
	@Test
	public void testAdd() throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=format.parse("1994-09-21");
		User user=new User("4512", "Liki", "cde", "Liki@163.com", "run", birthday);
		UserDaoImpl daoImpl=new UserDaoImpl();
		daoImpl.add(user);
	}
	
	@Test
	public void testFind1() throws Exception {
		UserDaoImpl daoImpl=new UserDaoImpl();
		Boolean flag=daoImpl.find("jack");
		System.out.println(flag);
	}
	
	@Test
	public void testFind2() throws DocumentException, ParseException{
		UserDaoImpl daoImpl=new UserDaoImpl();
		User user=daoImpl.find("mike", "456");
		System.out.println(user.getEmail());
	}
}
