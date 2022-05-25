package com.medical.entity;
import java.util.Date;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;


/*
 *
 * gen by beetlsql 2022-05-5
 */
@Data
@Table(name="lb_news")
public class LbNews   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_content = "content";
	public static final String ALIAS_title = "title";
	public static final String ALIAS_create_time = "create_time";
	
	private Integer id ;
	private String content ;
	private String title ;
	private Date createTime ;

}
