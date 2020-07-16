package com.wealth.mapper;

import com.wealth.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper {
    @Select("select count(*) from user")
    public Integer selectUserNumber();
    /**
     * 批量查询user表
     * @param startID   返回结果中的ID下限
     * @param number    返回的结果集中所包含数据数目的上限
     * @return
     */
    @Select("select * from user where user.id>=#{startID} limit #{number}")
    public List<User> selectUserAll(int startID,int number);

    @Select("select * from user where user.username=#{value}")
    public List<User> selectUserName(String value);

}
