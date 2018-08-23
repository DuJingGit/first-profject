package com.yr.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.bean.Classes;
import com.yr.bean.Teacher;

/**
 * ����:һ��һ�������ѯ
 * 
 * @author liucong
 *
 * @date 2017��7��25��
 */
public class ClassesTest {
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		//new ClassesTest().add();
		new ClassesTest().query();
		System.out.println("teste");
	}

	/**
	 * �õ�SessionFactory
	 * 
	 * @return
	 */
	private SqlSessionFactory getFactory() {
		// mybatis�������ļ�
		String resource = "conf.xml";
		Reader reader;// ʹ��MyBatis�ṩ��Resource�����mybatis�������ļ�,Ҳ���ع�����ӳ���ļ�
		SqlSessionFactory sessionFactory = null;// ����sqlSession�Ĺ���
		try {
			reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public void querys() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Classes> classesList = mapper.getAllClass();
		for (Classes classes : classesList) {
			System.out.println(classes);
		}
		session.close();
	}

	public void query() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Classes classes = mapper.getOneClass(1);
		System.out.println(classes);
		session.close();
	}
	
	public void query1() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Classes classes = mapper.getOneClasses(1);
		System.out.println(classes);
		session.close();
	}
	public void add() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		Classes classes=new Classes();
		Teacher teacher=new Teacher();
		teacher.setId(3);
		teacher.setName("teacher3");
		classes.setName("class3");
		classes.setTeacher(teacher);
		mapper.addClasses(classes);
		session.close();
	}

}