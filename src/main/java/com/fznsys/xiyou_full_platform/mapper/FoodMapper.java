package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository("foodmapper")
public interface FoodMapper {
    @Select(" SELECT * FROM tb_takeout_food")
    ArrayList<Food> select();

    @Insert(" insert into tb_takeout_food  values (#{food})")
    ArrayList<Food> insert(Food food);

    @Delete("delete from tb_takeout_food where id=#{id}")
    ArrayList<Food> delete(String id);

    @Select(" SELECT * FROM tb_takeout_food where id=#{id}")
    ArrayList<Food> selectByFoodId(String id);


}
