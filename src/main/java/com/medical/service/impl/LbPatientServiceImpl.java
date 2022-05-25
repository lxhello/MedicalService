package com.medical.service.impl;

import com.medical.common.Global;
import com.medical.dao.LbDoctorDao;
import com.medical.dao.LbDrugsDao;
import com.medical.dao.LbIllnessDao;
import com.medical.dao.LbPatientDao;
import com.medical.entity.LbDoctor;
import com.medical.entity.LbDrugs;
import com.medical.entity.LbIllness;
import com.medical.entity.LbPatient;
import com.medical.service.LbPatientService;
import com.medical.vo.QueryVo;
import com.medical.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.LambdaQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lixiang
 * @date: 2022/5/6
 * @version: 1.0版本
 */
@Service
public class LbPatientServiceImpl implements LbPatientService {
    @Autowired
    private LbPatientDao lbPatientDao;
    @Autowired
    private LbIllnessDao lbIllnessDao;
    @Autowired
    private LbDrugsDao lbDrugsDao;
    @Autowired
    private LbDoctorDao lbDoctorDao;

    @Override
    public PageQuery<LbPatient> findList(QueryVo queryVo) {
        PageQuery<LbPatient> query = new PageQuery(queryVo.getPageNo(),queryVo.getPageSize());
        if (!StringUtils.isEmpty(queryVo.getPatientName())) {
            query.setPara("name",queryVo.getPatientName());
        }
        if (!StringUtils.isEmpty(queryVo.getCertId())) {
            query.setPara("certId",queryVo.getCertId());
        }
        if (queryVo.getDoctorId() != null) {
            query.setPara("doctorId", queryVo.getDoctorId());
        }
        lbPatientDao.selectList(query);
        return query;
    }

    @Override
    public List<LbPatient> findAll() {
        return lbPatientDao.all();
    }

    @Override
    public ResponseResult insertPatient(LbPatient lbPatient) {
        ResponseResult result = new ResponseResult();
        LambdaQuery<LbPatient> query = lbPatientDao.createLambdaQuery();
        if (!StringUtils.isEmpty(lbPatient.getCertId())) {
            query.andEq(LbPatient::getCertId,lbPatient.getCertId());
        }
        LbPatient sysPatient = query.single();
        if (sysPatient != null) {
            result.setCode(Global.SAVE_CODE_ERROR);
            result.setMessage(Global.SAVE_MSG_ERROR);
        } else {
            lbPatientDao.insert(lbPatient);
            result.setCode(Global.SAVE_CODE_SUCCESS);
            result.setMessage(Global.SAVE_MSG_SUCCESS);
        }
        return result;
    }

    @Override
    public ResponseResult updatePatient(LbPatient lbPatient) {
        ResponseResult result = new ResponseResult();
        lbPatientDao.updateTemplateById(lbPatient);
        result.setCode(Global.SAVE_CODE_SUCCESS);
        result.setMessage(Global.SAVE_MSG_SUCCESS);
        return result;
    }

    @Override
    public LbPatient findOne(Integer id) {
        return lbPatientDao.single(id);
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        ResponseResult result = new ResponseResult();

        int rows = lbPatientDao.deleteById(id);
        if (rows > 0) {
            result.setCode(Global.DEL_CODE_SUCCESS);
            result.setMessage(Global.DEL_MSG_SUCCESS);
        } else {
            result.setCode(Global.DEL_CODE_ERROR);
            result.setMessage(Global.DEL_MSG_ERROR);
        }
        return result;
    }

    @Override
    public LbPatient findOneByUserId(Integer userId) {
        Query<LbPatient> query = lbPatientDao.createQuery();
        query.andEq("user_id",userId);
        return query.single();
    }

    @Override
    public Map<String, List> findInfo(String type, String name) {
        Map<String,List> map = new HashMap<>();
        List list = null;
        switch (type){
            case "illness":
                list = getIllness(name);
                map.put(type,list);
                break;
            case "doctor":
                list = getDoctors(name);
                map.put(type, list);
                break;
            case "drugs":
                list = getDrugs(name);
                map.put(type, list);
                break;
            default:
                break;
        }
        return map;
    }

    private List<LbIllness> getIllness(String name) {
        Query<LbIllness> query = lbIllnessDao.createQuery();
        if(!StringUtils.isEmpty(name)) {
            query.andEq("name",name);
        }
        return query.select();
    }

    private List<LbDoctor> getDoctors(String name) {
        Query<LbDoctor> query = lbDoctorDao.createLambdaQuery();
        if(!StringUtils.isEmpty(name)) {
            query.andEq("name",name);
        }
        return query.select();
    }

    private List<LbDrugs> getDrugs(String name) {
        Query<LbDrugs> query = lbDrugsDao.createLambdaQuery();
        if(!StringUtils.isEmpty(name)) {
            query.andEq("name",name);
        }
        return query.select();
    }
}
