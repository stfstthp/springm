package com.stt.mybatis.mapper;

import com.stt.mybatis.entities.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: 梦学谷
 */
//@Mapper 或 @MapperScan
public interface BillMapper {
    @Select("select * from bill where bid=#{bid}")
    Bill getBillByBid(Integer bid);

    @Options(useGeneratedKeys = true, keyProperty = "bid")
    @Insert("insert into bill(bill_Name) values(#{bill_Name})")
    int addBill(Bill bill);


}
