package com.yr.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.bean.User;

public class UserTest {
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		// Class<?> c = Class.forName("com.yr.test.UserTest");
		// UserTest test = (UserTest) c.newInstance();
		// test.query();
		// new UserTest().addUser();
		// new UserTest().updUser();
		//new UserTest().querycall();
		new UserTest().querys();
		// �������������
		/*CacheManager cacheManager = new CacheManager();
		// ����һ������ʵ��
		Cache cache = cacheManager.getCache("helloworld1");
		// ����һ����������
		Element element = new Element("key", "Hello Word!");
		// �����ݷŵ�����ʵ����
		cache.put(element);
		System.out.println(element.getObjectValue());*/
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

	/**
	 * ��ѯ
	 * 
	 * @throws Exception
	 */
	public void querys() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User usera = new User();
		usera.setId(10);
		usera.setName("%��%");
		usera.setAge(18);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		usera.setList(list);
		System.out.println("��һ�β�ѯ:");
		List<User> userList = mapper.getAll(usera);
		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("�ڶ��β�ѯ(��ȡ����)<һ������>:");
		List<User> userLists = mapper.getAll(usera);
		for (User user : userLists) {
			System.out.println(user);
		}
		session.clearCache();
		System.out.println("�����β�ѯ(���������,���������Ķ�ȡ):");
		List<User> userListse = mapper.getAll(usera);
		for (User user : userListse) {
			System.out.println(user);
		}
		session.close();// ����commit();
		// Thread.sleep(60000);//��ʱ֮�󻺴��Զ����
		System.out.println("���Ĵβ�ѯ(�������������棬��һ�������в鿴�Ƿ������ͬ��ѯ�����Ľ����������У���ֱ�Ӵ�һ�������ж�ȡ,�������������ȡ)<��������>:");
		session = sessionFactory.openSession();
		UserMapper mappers = session.getMapper(UserMapper.class);
		// usera.setId(1);
		List<User> userListe = mappers.getAll(usera);
		for (User user : userListe) {
			System.out.println(user);
		}
		System.out.println("����β�ѯ(��һ�������ȡ����):");
		List<User> userListses = mappers.getAll(usera);
		for (User user : userListses) {
			System.out.println(user);
		}
		System.out.println("�����β�ѯ(��һ�������ȡ����,���Ի����������Ƿ����):");
		List<User> userListsese = mappers.getAll(usera);
		for (User user : userListsese) {
			System.out.println(user);
		}
		System.out.println("���ߴβ�ѯ(��һ�������ȡ����,��һ�����Ի����������Ƿ����ȡ�������������):");
		List<User> userListseses = mappers.getAll(usera);
		for (User user : userListseses) {
			System.out.println(user);
		}
		session.close();
	}

	public void querycall() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Map<String, Integer> map = new HashMap<>();
		map.put("sex_id", 1);
		mapper.getCount(map);
		System.out.println(map.get("user_count"));
		session.close();
	}

	public void addUser() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User("���۴�������", 28);
		mapper.addUser(user);
		session.close();
	}

	public void updUser() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User(5, "���ｫ��", 28);
		mapper.updateUser(user);
		session.commit();
		session.close();
	}

	public void delUserById(Integer id) throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUser(id);
		session.close();
	}

	public void query() throws Exception {
		// mybatis�������ļ�
		String resource = "conf.xml";
		/**
		 * ʹ�������������mybatis�������ļ�(������ص�ӳ���ļ�) InputStream is =
		 * Test.class.getClassLoader().getResourceAsStream(resource);
		 * ����sqlSession�Ĺ��� SqlSessionFactory sessionFactory = new
		 * SqlSessionFactoryBuilder().build(is);
		 */
		// ʹ��MyBatis�ṩ��Resource�����mybatis�������ļ�(������ص�ӳ���ļ�)
		Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession(true);
		// ӳ��sql�ı�ʾ�ַ���
		String statement = "com.yr.mapper.userMapper.getUserList";
		String statement1 = "com.yr.mapper.userMapper.getUser";
		/**
		 * selectOne:����id��ѯһ����¼
		 */
		User users = new User("�°���", 25);
		session.insert("com.yr.mapper.userMapper.addUser", users);
		User user1 = session.selectOne(statement1, 1);
		System.out.println("����id��ѯһ��:" + user1);

		System.out.println("=============");

		/**
		 * selectList:��ѯ���з���list
		 */
		List<User> userList = session.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
	}
}