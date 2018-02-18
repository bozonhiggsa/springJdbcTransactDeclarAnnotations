package com.springApp.springJdbcTransactDeclarAnnotations.dao.jdbc;

import com.springApp.springJdbcTransactDeclarAnnotations.dao.ProjectDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Implementation Project DAO based on JdbcTemplate
 * @author Ihor Savchenko
 * @version 1.0
 */
public class JdbcTemplateProjectDaoImpl implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createProject(Integer developerId, String projectName, String companyName) {

        String SQL = "INSERT INTO PROJECTS (DEVELOPERS_ID, NAME, COMPANY) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, developerId, projectName, companyName);
        System.out.println("Project record created successfully. Project name: " +
                projectName + ", Company: " + companyName + "\n");
    }
}
