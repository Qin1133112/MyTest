package com.springboot.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.springboot.user.domain.User;

@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserDao
{
	@Select("SELECT * FROM user")
    @ResultType(User.class)
	public List<User> findAll();
	
	@Select("SELECT * FROM user WHERE name=#{name}")
    @ResultType(User.class)
	public List<User> findByName(User user);
	
//	@ResultType(User.class)
	public List<User> findUsers(User user);
	
	@Insert("insert into user(name,sex,age) values(#{name},#{sex},#{age})")
	public boolean add(User user);
	
//	@Update("update user set name=#{name},age=#{age},sex=#{age} where id=#{id}")
	public boolean modify(User user);
	
	@Delete("delete from user where id=#{id}")
	public boolean delete(User user);

	public boolean deleteBatch(List<Integer> ids);
}
