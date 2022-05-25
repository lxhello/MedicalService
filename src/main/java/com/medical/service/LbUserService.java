package com.medical.service;

import com.medical.entity.LbUser;
import com.medical.vo.ActiveUser;
import com.medical.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

import javax.servlet.http.HttpSession;

/**
 * @author: lixiang
 * @date: 2022/5/5
 * @version: 1.0版本
 */
public interface LbUserService {
    //校验登录
    ResponseResult checkUser(LbUser user, HttpSession session);

    /**
     * 注册用户
     */
    ResponseResult registUser(ActiveUser activeUser);

    //分页查询
    PageQuery<LbUser> findList(Integer pageNo, Integer pageSize, String username);

    /**
     * 保存
     */
    ResponseResult insertUser(LbUser lbUser);

    /**
     * 更新记录
     */
    ResponseResult updateUser(LbUser lbUser);

    /**
     * 根据主键id查询
     */
    LbUser findOne(Integer id);

    /**
     * 删除记录
     */
    ResponseResult deleteUser(Integer id);
}
