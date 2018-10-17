package com.how2java.springboot.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.how2java.springboot.pojo.Category;
 
@Mapper
public interface CategoryMapper {
    List<Category> findAll();
}