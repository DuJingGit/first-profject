package com.yr.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * users������Ӧ��ʵ����
 * 
 * @author liucong
 *
 * @date 2017��7��24��
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ʵ��������Ժͱ��ֶ�����һһ��Ӧ
	 */
	private Integer id;
	private String name;
	private Integer age;
	private List<Integer> list = new ArrayList<>();

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public User(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", list=" + list + "]";
	}

}