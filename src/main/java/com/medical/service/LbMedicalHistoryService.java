package com.medical.service;

import com.medical.entity.LbMedicalHistory;
import com.medical.vo.QueryVo;
import com.medical.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

/**
 * @author: lixiang
 * @date: 2022/5/13
 * @version: 1.0版本
 */
public interface LbMedicalHistoryService {
    //查集合
    PageQuery<LbMedicalHistory> findList(QueryVo queryVo);

    /**
     * 保存
     */
    ResponseResult insertMedicalHistory(LbMedicalHistory lbMedicalHistory);

    /**
     * 更新记录
     */
    ResponseResult updateMedicalHistory(LbMedicalHistory lbMedicalHistory);

    /**
     * 根据主键id查询
     */
    LbMedicalHistory findOne(Integer id);

    /**
     * 删除
     */
    ResponseResult deleteById(Integer id);
}
