package com.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request,Class<T> class1) {
		try {
			//创建用来封装数据的bean
			T bean=class1.newInstance();
			Enumeration<String> enumeration=request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String ParamName=enumeration.nextElement();
				String ParamValue=request.getParameter(ParamName);
				BeanUtils.copyProperty(bean, ParamName, ParamValue);
			}
			return bean;
		}catch(Exception exception){
			throw new RuntimeException();
		}
	}
	
	//复制bean
	public static void copyBean(Object src,Object dest) {
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class type, Object value) {
				if (value==null) {
					return null;
				}
				String string=(String) value;
				if (string.trim().equals("")) {
					return null;
				}
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return format.parse(string);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			
		}
	}
	
	//产生ID
	public static String generateID() {
		return UUID.randomUUID().toString();
	}
}
