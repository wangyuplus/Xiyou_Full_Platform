package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.Express;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


/**
 * @author:罗云继
 * @date 2019/6/4 9:46
 */
@Mapper
@Repository
public interface ExpressMapper {
    /**查询所有快递单*/
    @Select("select * from tb_express_order")
    ArrayList<Express> findAll();

    /**查看已取货的快递*/
    @Select("select * from tb_express_order where express_status=1")
    ArrayList<Express> findAlreadyTakenExpress();

    /**查看已取货的快递*/
    @Select("select * from tb_express_order where express_status=1")
    ArrayList<Express> findNotTakenExpress();

    /**查询单个快递*/
    @Select("select * from tb_express_order where num=#{num}")
    Express findExpressByNum(String num);

//    /**下单后，修改快递状态*/
//    @Update("update tb_express_order set status=1,")
//    void updateExpress(Express express,@Param("couriername") String courier);

    /**新增快递单*/
    @Insert("insert into tb_express_order values(#{id},#{phonenumber},#{phonenumber},#{recivename},#{company},#{address},#{expressnum},#{courierid},#{couriername},#{status},#{price})")
    void addExpress(Express express);

    /**删除快递单*/
    @Delete("delete from tb_express_order where id=#{id}")
    void deleteExpress(@Param("id") String id);

    @Select("select * from tb_express_order where recivename LIKE concat(concat('%',#{name}),'%')")
    Express findByName(String name);
}
