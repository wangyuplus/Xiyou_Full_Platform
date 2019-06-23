package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository("orderMapper")
public interface OrderMapper  {

    @Select(" SELECT * FROM tb_takeout_order")
    ArrayList<Order> findAll();

    @Insert(" insert into tb_takeout_order values (#{id},#{userid},#{date},#{sum},#{mark})")
    void insert(Order order);

   @Delete("delete from tb_takeout_order where id=#{id}")
    ArrayList<Order> delete(String id);

    @Select(" SELECT * FROM tb_takeout_order where id=#{id}")
   Order selectById(String id);

}
