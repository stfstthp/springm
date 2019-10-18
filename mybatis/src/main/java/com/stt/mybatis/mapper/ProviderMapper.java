package com.stt.mybatis.mapper;

import com.stt.mybatis.entities.Provider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 使用MYBATIS注解版本
 */

//@Mapper//操作数据的MAPPER
public interface ProviderMapper {
    @Select("select * from provider where pid=#{pid}")
    Provider getProviderByPid(Integer pid);

    //useGeneratedKeys是否使用自增主键,keyProperty实体类中的哪一个
    @Options(useGeneratedKeys = true, keyProperty = "pid")
    @Insert("insert into provider(providerName) values(#{providerName})")
    int addProvider(Provider provider);

    @Delete("delete from provider where pid=#{pid}")
    int deleProviderByPid(Integer pid);

    @Update("update provider set providerName=#{providerName} where pid=#{pid}")
    int updateProvider(Provider provider);

    @Select("select * from provider")
    List<Provider> getProvider();

    @Update("update provider set people=#{i} where pid=#{i}")
    int updatePro(int i);
}
