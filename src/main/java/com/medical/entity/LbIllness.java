package com.medical.entity;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;


/*
 *
 * gen by beetlsql 2022-05-5
 */
@Data
@Table(name="lb_illness")
public class LbIllness   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_name = "name";
	public static final String ALIAS_text = "text";
	
	private Integer id ;
	private String name ;
	private String text ;
}
