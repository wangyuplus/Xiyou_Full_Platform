package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import com.fznsys.xiyou_full_platform.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository("orderFoodMapper")
public interface OrderFoodMapper  {

    @Select(" SELECT * FROM tb_takeout_order_food")
    ArrayList<OrderFood> select();

    @Insert(" insert into tb_takeout_order_food  values (#{orderFood})")
    ArrayList<OrderFood> insert(OrderFood orderFood);

    @Delete("delete from tb_takeout_order_food where id=#{id}")
    ArrayList<OrderFood> delete(String id);

    @Select(" SELECT * FROM tb_takeout_order_food where foodid=#{id}")
    OrderFood selectById(String id);
}
