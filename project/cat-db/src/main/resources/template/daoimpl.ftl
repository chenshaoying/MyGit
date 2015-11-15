/*
 * Copyright 2009-2010 the original author jollyja.
 *
 */
package com.sunline.suncard.db.dao.${package};


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sunline.suncard.db.dao.DefaultDaoImpl;
import com.sunline.suncard.db.domain.${package}.${fixName};

/**
 * @author Darren Chan
 * 
 */
@Repository("${fixName?uncap_first}Dao")
@Scope("singleton")
public class ${fixName}DaoImpl extends DefaultDaoImpl<${fixName}> implements ${fixName}Dao {

}
