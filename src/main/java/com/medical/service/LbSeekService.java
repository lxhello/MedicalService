package com.medical.service;

import com.medical.entity.LbSeek;
import com.medical.vo.ResponseResult;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: lixiang
 * @date: 2022/5/19
 * @version: 1.0版本
 */
public interface LbSeekService {
    //保存记录
    ResponseResult save(Map map, HttpSession session);

    //更新记录
    ResponseResult update(Map map, HttpSession session);

    //获取一条记录
    LbSeek findOneByPatientId(Integer patientId,Integer appointmentId,HttpSession session);
}
