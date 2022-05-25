package com.medical.service;

import com.medical.entity.LbAppointment;
import com.medical.vo.QueryVo;
import com.medical.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

/**
 * @author: lixiang
 * @date: 2022/5/10
 * @version: 1.0版本
 */
public interface LbAppointmentService {
    //查集合
    PageQuery<LbAppointment> findList(QueryVo queryVo);

    //查询医生的患者预约记录
    PageQuery<LbAppointment> findListByDoctor(QueryVo queryVo);

    /**
     * 保存
     */
    ResponseResult insertAppointment(LbAppointment lbAppointment);

    /**
     * 更新记录
     */
    ResponseResult updateAppointment(LbAppointment lbAppointment);

    /**
     * 根据主键id查询
     */
    LbAppointment findOne(Integer id);

    /**
     * 删除
     */
    ResponseResult deleteById(Integer id);

    /**
     * 插入返回主键
     */
    Integer insertReturnId(LbAppointment appointment);

}
