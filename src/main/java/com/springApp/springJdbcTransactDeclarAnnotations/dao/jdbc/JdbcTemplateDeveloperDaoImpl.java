package com.springApp.springJdbcTransactDeclarAnnotations.dao.jdbc;

import com.springApp.springJdbcTransactDeclarAnnotations.dao.DeveloperDao;
import com.springApp.springJdbcTransactDeclarAnnotations.model.Developer;
import com.springApp.springJdbcTransactDeclarAnnotations.model.Project;
import com.springApp.springJdbcTransactDeclarAnnotations.util.DeveloperMapper;
import com.springApp.springJdbcTransactDeclarAnnotations.util.ProjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation Developer DAO based on JdbcTemplate and  @Transactional
 * @author Ihor Savchenko
 * @version 1.0
 */
public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void createDeveloper(String name, String speciality, Integer experience) {

        String SQL = "INSERT INTO DEVELOPERS (name, speciality, experience) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, speciality, experience);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpeciality: " +
                speciality + ";\nExperience: " + experience + "\n");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Developer> listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        List<Developer> developers = jdbcTemplate.query(SQL, new DeveloperMapper());
        return developers;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Project> listDevelopersProjects(Integer id) {
        String SQL = "SELECT * FROM PROJECTS WHERE DEVELOPERS_ID = " + id;
        List<Project> projectList = jdbcTemplate.query(SQL, new ProjectMapper());
        return projectList;
    }


}
