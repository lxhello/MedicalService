package com.medical.dao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.medical.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface LbPatientDao extends BaseMapper<LbPatient> {
    //查询病人关联查询医生（分页）
    void selectList(PageQuery<LbPatient> page);
}