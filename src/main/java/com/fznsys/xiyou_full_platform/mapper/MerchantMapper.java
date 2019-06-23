package com.fznsys.xiyou_full_platform.mapper;

import com.fznsys.xiyou_full_platform.pojo.Merchant;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository("mechantmapper")
public interface MerchantMapper {

    @Select(" SELECT * FROM tb_takeout_merchant")
    ArrayList<Merchant> select();




    @Delete("delete from tb_takeout_merchant where id=#{id}")
    void  delete(String id);

    @Select(" SELECT * FROM tb_takeout_merchant where id=#{id}")
    Merchant selectByMerchantId(String id);

    @Insert(" insert into tb_takeout_merchant  values (#{id},#{menuid},#{announcement},#{type},#{name})")
    void  insert(@Param("announcement") String announcement, @Param("name") String name, @Param("menuid") String menuid,@Param("type") String type, @Param("id") String id);

    @Select(" SELECT * FROM tb_takeout_merchant where id=#{id}")
    Merchant selectByMerchantId2(String id);

}
