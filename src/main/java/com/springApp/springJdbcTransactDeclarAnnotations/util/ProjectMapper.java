package com.springApp.springJdbcTransactDeclarAnnotations.util;

import com.springApp.springJdbcTransactDeclarAnnotations.model.Project;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Garik on 31.10.2017.
 */
public class ProjectMapper implements RowMapper<Project> {

    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();

        project.setDevelopersId(rs.getInt("DEVELOPERS_ID"));
        project.setProjectName(rs.getString("NAME"));
        project.setCompanyName(rs.getString("COMPANY"));

        return project;
    }
}
