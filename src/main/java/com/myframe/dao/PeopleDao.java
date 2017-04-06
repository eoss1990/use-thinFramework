package com.myframe.dao;

import thin.framework.annotation.Service;
import thin.framework.database.BaseDao;
import thin.framework.transaction.annotation.Transaction;

import java.sql.SQLException;

/**
 * Created by yangyu on 2017/2/12.
 */
@Service
public class PeopleDao extends BaseDao{

    @Transaction
    public void executeSql(String[] sqlArray) throws SQLException {
        for (String sql : sqlArray){
            insertOrUpdateOrDelete(sql);
        }
    }
}
