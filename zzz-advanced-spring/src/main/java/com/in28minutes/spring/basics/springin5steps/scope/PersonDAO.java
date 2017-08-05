package com.in28minutes.spring.basics.springin5steps.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PersonDAO {

	@Autowired
	private PersonJDBCConnection connection;

	public PersonJDBCConnection getConnection() {
		return connection;
	}

	public void setConnection(PersonJDBCConnection connection) {
		this.connection = connection;
	}

}
