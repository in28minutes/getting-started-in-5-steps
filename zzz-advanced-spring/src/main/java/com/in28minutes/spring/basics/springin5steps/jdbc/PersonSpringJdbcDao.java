package com.in28minutes.spring.basics.springin5steps.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonSpringJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// new BeanPropertyRowMapper(Person.class)
	class PersonMapper implements RowMapper<Person> {
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("location"),
					rs.getTimestamp("birth_date"));
			return person;
		}
	}

	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());

	}

	public Person findById(int id) {

		return jdbcTemplate.queryForObject("SELECT * FROM person where id=?", new Object[] { id }, new PersonMapper());

	}

	public void insert(Person person) {
		jdbcTemplate.update("insert into person(id, birth_date,location, name) values(?,?,?,?)", person.getId(),
				new Timestamp(person.getBirthDate().getTime()), person.getLocation(), person.getName());

	}

	public void update(Person person) {
		jdbcTemplate.update("Update person set name=?, location=?, birth_date=? where id=?", person.getName(),
				person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId());

	}

	public void deleteById(int id) {
		jdbcTemplate.update("delete from person where id=?", id);
	}
}