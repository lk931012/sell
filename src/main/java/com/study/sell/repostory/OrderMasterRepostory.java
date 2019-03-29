package com.study.sell.repostory;

import com.study.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:05
 */
@Repository
public interface OrderMasterRepostory extends JpaRepository<OrderMaster, String> {

    /**
     * 通过买家微信号分页查询所有订单
     *
     * @param pageable
     * @param buyerOpenid
     * @return
     */
    Page<OrderMaster> findAllByBuyerOpenid(Pageable pageable, String buyerOpenid);


    /**
     * 通过买家微信号查询所有订单
     *
     * @param buyerOpenid
     * @return
     */
    List<OrderMaster> findAllByBuyerOpenid(String buyerOpenid);
}
