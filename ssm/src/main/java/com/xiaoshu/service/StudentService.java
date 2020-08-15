package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.JiyunStudentMapper;
import com.xiaoshu.entity.JiyunStudent;
import com.xiaoshu.entity.JiyunStudentExample;
import com.xiaoshu.entity.JiyunStudentExample.Criteria;

@Service
public class StudentService {

	@Autowired
	JiyunStudentMapper studentMapper;


	// 通过ID查询
	public JiyunStudent findOneUser(Integer id) throws Exception {
		return studentMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addUser(JiyunStudent t) throws Exception {
		t.setCreatetime(new Date());
		studentMapper.insert(t);
	};

	// 修改
	public void updateUser(JiyunStudent t) throws Exception {
		studentMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		studentMapper.deleteByPrimaryKey(id);
	};


	// 通过用户名判断是否存在，（新增时不能重名）
	public JiyunStudent existUserWithUserName(String userName) throws Exception {
		JiyunStudentExample example = new JiyunStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(userName);
		List<JiyunStudent> userList = studentMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过角色判断是否存在
	public JiyunStudent existUserWithRoleId(Integer roleId) throws Exception {
		JiyunStudentExample example = new JiyunStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(roleId);
		List<JiyunStudent> userList = studentMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}

	public PageInfo<JiyunStudent> findUserPage(JiyunStudent student, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		List<JiyunStudent> userList = studentMapper.findPage(student);
		PageInfo<JiyunStudent> pageInfo = new PageInfo<JiyunStudent>(userList);
		return pageInfo;
	}

	public List<JiyunStudent> findLog(JiyunStudent jiyunStudent) {
		return studentMapper.findPage(jiyunStudent);
	}

	public List<JiyunStudent> echartsStudent() {
		return studentMapper.echartsStudent();
	}


}

