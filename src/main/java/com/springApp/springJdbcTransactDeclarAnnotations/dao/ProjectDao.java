package com.springApp.springJdbcTransactDeclarAnnotations.dao;

/**
 * Interface for Project DAO
 * @author Ihor Savchenko
 * @version 1.0
 */
public interface ProjectDao {

    void createProject(Integer developersId, String projectName, String companyName);
}
