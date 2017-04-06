package com.myframe.controller;

import com.myframe.bean.People;
import com.myframe.dao.PeopleDao;
import com.myframe.manager.PeopleManager;
import thin.framework.annotation.Action;
import thin.framework.annotation.Controller;
import thin.framework.annotation.Inject;
import thin.framework.request.Param;
import thin.framework.response.Data;
import thin.framework.response.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by yangyu on 2017/2/7.
 */
@Controller
public class ThinController {

    @Inject
    private PeopleManager peopleManager;

    @Inject
    private PeopleDao peopleDao;

    @Action(value = "get:/index")
    public Data index(Param param){
        People people = new People();
        people.setName("yangyu");
        people.setSex("nan");
        people.setAge(27);
        return new Data(people);
    }

    @Action(value = "get:/jsp")
    public View indexJsp(Param param){
        return new View("index.jsp");
    }

    @Action(value = "get:/aop")
    public String aop(Param param){
        peopleManager.peopleSay();
        return "this is aop";
    }

    @Action(value = "get:/database")
    public void insertPeople(Param param){
        String sql = "insert into people values ('10009','yangyu','chengdu','188777','nan')";
        try {
            peopleDao.insertOrUpdateOrDelete(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Action(value = "get:/transaction")
    public void transaction(Param param){
        String[] sql = {
                "update people set name='yangyu' where id = '10009'",
                "insert into people values ('10009','yangyu','chengdu','188777','nan')"};
        try {
            peopleDao.executeSql(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        URL url = ClassLoader.getSystemResource("application.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(url.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.toString());
    }
}
