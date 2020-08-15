package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.CourseMapper;
import com.xiaoshu.entity.Course;
import com.xiaoshu.entity.CourseExample;
import com.xiaoshu.entity.CourseExample.Criteria;

@Service
public class CourseService {

	@Autowired
	CourseMapper courseMapper;

	public List<Course> findCourse() {
		return courseMapper.selectAll();
	}
	
	@Autowired
	RedisTemplate redisTemplate;

	public void insertCourse(Course course) {
		course.setCreatetime(new Date());
		courseMapper.insertCourse(course);
		redisTemplate.boundHashOps("course").put(course.getId(), course);
		System.out.println("从redis中读取："+redisTemplate.boundHashOps("course").get(course.getId()));
	}
	// 通过角色判断是否存在
		public Course existUserWithRoleId(Integer roleId) throws Exception {
			CourseExample example = new CourseExample();
			Criteria criteria = example.createCriteria();
			criteria.andCodeEqualTo(roleId);
			List<Course> userList = courseMapper.selectByExample(example);
			return userList.isEmpty()?null:userList.get(0);
	}

}
