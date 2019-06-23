package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.LifePayment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Author:朱中雨
 * Date:2019-6-5
 * Target:
 */
@Mapper
@Repository
public interface LifePaymentMapper {

    @Delete("delete from tb_life_payment where id=#{id}")
    int DeleteByID(@Param("id") String id);//通过缴费单id删除记录

//    @Insert("insert into tb_life_payment values(#{id},#{userid},#{type},#{num},#{date},#{status},#{mark})")
//    int addPayment(@Param("id")String id,@Param("userid")String userid,@Param("type")String type,
//                    @Param("num")String num,@Param("date")String date,@Param("status")String status,
//                    @Param("mark")String mark);//添加缴费单记录
@Insert("insert into tb_life_payment values(#{id},#{userid},#{type},#{num},#{date},#{status},#{way},#{mark})")
    int addPayment(LifePayment lifePayment);//添加缴费单记录
    @Select("select * from tb_life_payment where id=#{id}")
    LifePayment getLifePaymentByid(@Param("id") String id);//通过缴费单ID获取缴费单

    @Select("select * from tb_life_payment where userid=#{userid}")
    ArrayList<LifePayment> getLifePaymentByuserid(@Param("userid") String userid);//获取用户的所有缴费单

    @Select("select * from tb_life_payment where userid=#{userid} and type=#{type}")
    ArrayList<LifePayment> getLifePaymentByuseridAndtype(@Param("userid") String userid,
                                                  @Param("type")String type);//获取用户某一类型的缴费单

    @Select("select * from tb_life_payment where userid=#{userid} and status=#{status}")
    ArrayList<LifePayment> getLifePaymentByuseridAndstatus(@Param("userid") String userid,
                                                         @Param("status")String status);//获取用户某一状态的缴费单
    @Update("update tb_life_payment set status=#{status} where id=#{id}")
    int updateStatusById(@Param("id") String id,@Param("status") String status);
}
