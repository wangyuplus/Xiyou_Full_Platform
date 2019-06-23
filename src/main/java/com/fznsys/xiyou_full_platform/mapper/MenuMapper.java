package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.Menu;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository("menuMapper")
public interface MenuMapper {

    @Select(" SELECT * FROM tb_takeout_menu")
    ArrayList<Menu> select();

    @Insert(" insert into tb_takeout_menu  values (#{menu})")
    ArrayList<Menu> insert(Menu menu);

    @Delete("delete from tb_takeout_menu where id=#{id}")
    ArrayList<Menu> delete(String id);

    @Select(" SELECT * FROM tb_takeout_menu where id=#{id}")
    Menu selectByMenuId(String id);

    @Select(" SELECT * FROM tb_takeout_menu where foodid=#{id}")
    Menu selectByFoodId(String id);
}
