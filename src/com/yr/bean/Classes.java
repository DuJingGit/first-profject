package com.yr.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * �༶ʵ����
 * 
 * @author liucong
 *
 * @date 2017��7��25��
 */
public class Classes {
	private Integer id;
	private String name;
	private Teacher teacher;
	private List<Student> stuList = new ArrayList<>();

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", teacher=" + teacher + ", stuList=" + stuList + "]";
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
}