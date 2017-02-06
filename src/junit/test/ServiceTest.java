package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.itcast.bean.User;
import com.itcast.exception.UserExistException;
import com.itcast.service.Service;
import com.itcast.service.impl.ServiceImpl;
import com.itcast.utils.ServiceUtils;

public class ServiceTest {
	
	@Test
	public void testRegister() throws ParseException, DocumentException, UserExistException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=format.parse("1989-06-11");
		Service serviceImpl=new ServiceImpl();
		User user=new User("4353", "gg", "987", "gg@163.com", "ji", birthday);
		serviceImpl.regsiter(user);
	}
	
	@Test
	public void testLogin() throws DocumentException, ParseException {
		String username="gg";
		String password="987";
		Service serviceImpl=new ServiceImpl();
		User user=serviceImpl.login(username, password);
		System.out.println(user.getBirthday());
	}
}
