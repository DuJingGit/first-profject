package com.yr.test;

import java.util.List;
import java.util.Map;

import com.yr.bean.Classes;
import com.yr.bean.User;

/**
 * ������ķ�������Ҫ�������ļ�����sql��Ӧ
 * 
 * @author liucong
 *
 * @date 2017��7��24��
 */
public interface UserMapper {

	public Map<String, Integer> getCount(Map<String, Integer> map);

	// ��ѯ
	public List<User> getAll(User user);

	// ���
	public Integer addUser(User user);

	// �޸�
	public Integer updateUser(User user);

	// ɾ��
	public Integer deleteUser(Integer id);

	// ��ѯ
	public List<Classes> getAllClass();

	public Classes getOneClass(Integer id);

	// ���
	public Integer addClasses(Classes user);

	// �޸�
	public Integer updateClasses(Classes user);

	// ɾ��
	public Integer deleteClasses(Integer id);

	public Classes getOneClasses(Integer id);

}