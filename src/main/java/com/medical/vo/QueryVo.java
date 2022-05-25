package com.medical.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 患者查询条件
 * @author: lixiang
 * @date: 2022/5/6
 * @version: 1.0版本
 */
@Data
public class QueryVo {
    private long pageNo = 1;
    private long pageSize = 5;
    private String patientName;
    private String doctorName;
    private Integer userId;
    private Integer patientId;
    private String certId;
    private Integer doctorId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
}
