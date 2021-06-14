package com.mp.demo.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.demo.dao.UserInfoDao;
import com.mp.demo.entity.UserInfoEntity;
import com.mp.demo.serivce.UserInfoService;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 用户业务实现
 * @Author Sans
 * @CreateTime 2019/6/8 16:26
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    /**
     * 查询大于该分数的学生
     * @Author Sans
     * @CreateTime 2019/6/9 14:27
     * @Param  page  分页参数
     * @Param  fraction  分数
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @Override
    public IPage<UserInfoEntity> selectUserInfoByGtFraction(IPage<UserInfoEntity> page, Long fraction) {
        return this.baseMapper.selectUserInfoByGtFraction(page,fraction);
    }

	@Override
	public UserInfoEntity get_By_Id(String id) {
		// TODO Auto-generated method stub
		return baseMapper.selectById(id);
		
	}

	@Override
	public UserInfoEntity insertById(UserInfoEntity user) {
		System.out.println(user.toString());
		baseMapper.insert(user);
		return null;
	}
	
	
	@Override
	public UserInfoEntity updateById2(UserInfoEntity user) {
		baseMapper.updateById(user);
		return null;
	}

	@Override
	public UserInfoEntity selectByAge(int age) {
		// TODO Auto-generated method stub
		   LambdaQueryWrapper<UserInfoEntity> roleWrapper = Wrappers.lambdaQuery();
	        roleWrapper.eq(UserInfoEntity::getAge, age);
	        UserInfoEntity user = baseMapper.selectOne(roleWrapper);
		return user;
	};
	
	
}
