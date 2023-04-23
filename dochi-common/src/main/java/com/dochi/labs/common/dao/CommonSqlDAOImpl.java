package com.dochi.labs.common.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("commonSql")
public class CommonSqlDAOImpl  implements CommonSqlDAO {

    private SqlSession sqlSession;

    private boolean externalSqlSession;

    @Autowired(required = false)
    public final void setSqlSessionFactory(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        if (!this.externalSqlSession) {
            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    @Autowired(required = false)
    public final void setSqlSessionTemplate(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
        this.externalSqlSession = true;
    }

    public int delete(String qName, Object parameter) throws SQLException {
        return this.sqlSession.delete(qName, parameter);
    }

    public int insert(String qName, Object parameter) throws SQLException {
        return this.sqlSession.insert(qName, parameter);
    }

    public int update(String qName, Object parameter) throws SQLException {
        return this.sqlSession.update(qName, parameter);
    }

    public <T> T selectOne(String qName, Object parameter) throws SQLException {
        return this.sqlSession.selectOne(qName, parameter);
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String qName, Object parameter)
            throws SQLException {
        return this.sqlSession.selectList(qName, parameter);
    }

    public int delete(String qName) throws SQLException {
        return delete(qName, null);
    }

    public int insert(String qName) throws SQLException {
        return insert(qName, null);
    }

    public int update(String qName) throws SQLException {
        return update(qName, null);
    }

    public <T> T selectOne(String qName) throws SQLException {
        return selectOne(qName, null);
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String qName) throws SQLException {
        return selectList(qName, null);
    }

}
