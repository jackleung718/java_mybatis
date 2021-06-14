package com.mp.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.demo.entity.UserInfoEntity;
import com.mp.demo.serivce.UserInfoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description UserInfoPlusController
 * @Author Sans
 * @CreateTime 2019/6/9 14:52
 */
@RestController
@RequestMapping("/userInfoPlus")
public class UserInfoPlusController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * MP扩展演示
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return Map<String,Object> 返回数据
     */
   
    /**
     * MP自定义SQL
     * @Author Sans
     * @CreateTime 2019/6/9 14:37
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @RequestMapping("/getById")
    public UserInfoEntity getById(){
        //查询大于60分以上的学生,并且分页
        final UserInfoEntity news = userInfoService.get_By_Id("1");

        return news;
    }
    
    @RequestMapping("/insertById")
    public UserInfoEntity insertById(@RequestBody UserInfoEntity user) throws ParseException{
        //查询大于60分以上的学生,并且分页
         
    	userInfoService.insertById(user);
System.out.println("success insert..");
        return null;
    }
    
    
    @RequestMapping("/updateById")
    public UserInfoEntity updateById(@RequestBody UserInfoEntity user){
        //查询大于60分以上的学生,并且分页
         userInfoService.updateById2(user);
System.out.println("success update.....");
return null;
    }
    
    @RequestMapping("/getInfoListSQL")
    public IPage<UserInfoEntity> getInfoListSQL(){
        //查询大于60分以上的学生,并且分页
        IPage<UserInfoEntity> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        page = userInfoService.selectUserInfoByGtFraction(page,60L);
        return page;
    }
    
    @RequestMapping("/selectByAge")
    public List<UserInfoEntity> selectByAge(@RequestBody  UserInfoEntity user){
 List<UserInfoEntity> user2 =        userInfoService.selectByAge(user.getAge());
 System.out.println("success get sucess.....");
return user2;
    }
    
    
    
}