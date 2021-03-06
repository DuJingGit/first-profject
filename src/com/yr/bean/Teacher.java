package com.yr.bean;

/**
 * 教师实体类
 * 
 * @author liucong
 *
 * @date 2017年7月25日
 */
public class Teacher {

	private Integer id;
	private String name;

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
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

}