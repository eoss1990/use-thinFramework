package com.myframe.manager;

import com.myframe.annotation.Aop;

/**
 * Created by yangyu on 2017/2/10.
 */
@Aop
public class PeopleManager {

    public void peopleSay(){
        System.out.println("this is people say");
    }
}
