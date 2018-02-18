package com.springApp.springJdbcTransactDeclarAnnotations.util;

import com.springApp.springJdbcTransactDeclarAnnotations.model.Developer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperMapper implements RowMapper<Developer> {

    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getInt("id"));
        developer.setName(rs.getString("name"));
        developer.setSpeciality(rs.getString("speciality"));
        developer.setExperience(rs.getInt("experience"));
        return developer;
    }
}
