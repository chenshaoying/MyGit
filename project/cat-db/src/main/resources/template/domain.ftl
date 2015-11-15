/*
 * Copyright 2015-2020 the original author Darren Chan.
 *
 */
package com.blackcat.${module}.domain.${package};

import java.io.Serializable;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * ${tableName}
 * 
 * @author Darren Chan
 * 
 */
public class ${fixName} implements Serializable {
	private static final long serialVersionUID = "${fixName}".hashCode();
	
	<#list meta as x>
	private ${x.columnType} ${x.columnName};//
	</#list>
	
	<#list meta as x>
	public ${x.columnType} get${x.columnName?cap_first}() {
		return this.${x.columnName};
	}
	public void set${x.columnName?cap_first}(${x.columnType} ${x.columnName}) {
		this.${x.columnName} = ${x.columnName};
	}
	</#list>

	public ${fixName}() {
	}

	<#if meta_pk?size != 0>
	public ${fixName}(<#list meta_pk as x>${x.columnType} ${x.columnName}<#if x_has_next>, </#if></#list>) {
		<#list meta_pk as x>
		this.${x.columnName} = ${x.columnName};
		</#list>
	}
	</#if>

	<#if meta?size != meta_pk?size>
	public ${fixName}(<#list meta as x>${x.columnType} ${x.columnName}<#if x_has_next>, </#if></#list>) {
		<#list meta as x>
		this.${x.columnName} = ${x.columnName};
		</#list>
	}
	</#if>
	
	public int hashCode() {
		int result = 17;
		<#if meta_pk?size != 0>
		<#list meta_pk as x>
		result = 37 * result + (this.${x.columnName} == null ? 0 : this.${x.columnName}.hashCode());
		</#list>
		</#if>
		<#if meta_pk?size == 0>
		<#list meta as x>
		result = 37 * result + (this.${x.columnName} == null ? 0 : this.${x.columnName}.hashCode());
		</#list>
		</#if>

		return result;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ${fixName}))
			return false;

		${fixName} castOther = (${fixName}) other;

		return
			<#if meta_pk?size != 0>
			<#list meta_pk as x>
			<#if x_index != 0>&& </#if>((this.${x.columnName} == castOther.get${x.columnName?cap_first}()) || (this.${x.columnName} != null && castOther.get${x.columnName?cap_first}() != null && this.${x.columnName}.equals(castOther.get${x.columnName?cap_first}())))
			</#list>
			</#if>
			<#if meta_pk?size == 0>
			<#list meta as x>
			<#if x_index != 0>&& </#if>((this.${x.columnName} == castOther.get${x.columnName?cap_first}()) || (this.${x.columnName} != null && castOther.get${x.columnName?cap_first}() != null && this.${x.columnName}.equals(castOther.get${x.columnName?cap_first}())))
			</#list>
			</#if>
		;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		<#list meta as x>
		builder.append("${x.columnName}:").append(${x.columnName}==null ? "" : ${x.columnName}.toString())<#if x_has_next>.append(",")</#if>;
		</#list>
		return builder.toString();
	}

	public Element toXml() {
		Element e = DocumentHelper.createElement("${fixName}");
		<#list meta_pk as x>
		e.addAttribute("${x.columnName}", ${x.columnName}==null ? "" : ${x.columnName}.toString());
		</#list>
		<#list meta as x>
		e.addElement("${x.columnName}").setText(${x.columnName}==null ? "" : ${x.columnName}.toString());
		</#list>
		return e;
	}
}
