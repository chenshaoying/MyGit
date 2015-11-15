<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-2.dtd">
<sqlMap namespace="${fixName}">

	<typeAlias alias="${fixName}" type="com.sunline.suncard.db.domain.${package}.${fixName}" />
	
	<insert id="insert" parameterClass="${fixName}">
		insert into ${tableName} (<#list meta as x>${x.columnName}<#if x_has_next>, </#if></#list>)
		values (<#list meta as x>#${x.columnName}:${x.columnJdbcType}#<#if x_has_next>, </#if></#list>)
	</insert>

	<select id="detail" parameterClass="${fixName}" resultClass="${fixName}">
		select <#list meta as x>${x.columnName}<#if x_has_next>, </#if></#list>
			from ${tableName}
			where 
			<#if meta_pk?size != 0>
			<#list meta_pk as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next> and </#if>
			</#list>
			</#if>
			<#if meta_pk?size == 0>
			<#list meta as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next> and </#if>
			</#list>
			</#if>
	</select>
	
	<delete id="delete" parameterClass="${fixName}">
		delete ${tableName}
			where 
			<#if meta_pk?size != 0>
			<#list meta_pk as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next> and </#if>
			</#list>
			</#if>
			<#if meta_pk?size == 0>
			<#list meta as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next> and </#if>
			</#list>
			</#if>
	</delete>

	<update id="update" parameterClass="${fixName}">
		update ${tableName} set
				<#if meta_pk?size != 0>
				<#list meta_npk as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next>, </#if>
				</#list>
				</#if>
				<#if meta_pk?size == 0>
				<#list meta as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next>, </#if>
				</#list>
				</#if>
			where
			<#if meta_pk?size != 0>
			<#list meta_pk as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next> and </#if>
			</#list>
			</#if>
			<#if meta_pk?size == 0>
			<#list meta as x>
				${x.columnName} = #${x.columnName}:${x.columnJdbcType}#<#if x_has_next> and </#if>
			</#list>
			</#if>
	</update>
	
	<select id="query" parameterClass="java.util.Map" resultClass="${fixName}">
		select <#list meta as x>${x.columnName}<#if x_has_next>, </#if></#list>
			from ${tableName}
			where 1=1
			<#list meta as x>
			<dynamic prepend="and">
				<isNotNull property="${x.columnName}">
			 		${x.columnName} = #${x.columnName}:${x.columnJdbcType}#
				</isNotNull>
			</dynamic>
			</#list>
	</select>

</sqlMap>
