package com.vic.mapper;

import com.vic.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from FRONT_DATA_TYPE_NEW")
    public List<User> getall();
}