package com.yr.test;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yr.bean.User;

public interface UserMappers {
	// ���
	@Insert("insert into users(name,age)values(#{name},#{age})")
	public Integer add(User user);

	// ɾ��
	@Delete("delete from users where id = #{id}")
	public Integer del(Integer id);

	// �޸�
	@Update("update users set name=#{name},age=#{age} where id = #{id}")
	public Integer update(User user);

	// ��ѯ
	@Select("select * from users")
	public List<User> getAll();
}