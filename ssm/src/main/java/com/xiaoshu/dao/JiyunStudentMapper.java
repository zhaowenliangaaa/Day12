package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.JiyunStudent;
import com.xiaoshu.entity.JiyunStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JiyunStudentMapper extends BaseMapper<JiyunStudent> {
    long countByExample(JiyunStudentExample example);

    int deleteByExample(JiyunStudentExample example);

    List<JiyunStudent> selectByExample(JiyunStudentExample example);

    int updateByExampleSelective(@Param("record") JiyunStudent record, @Param("example") JiyunStudentExample example);

    int updateByExample(@Param("record") JiyunStudent record, @Param("example") JiyunStudentExample example);

	List<JiyunStudent> findPage(JiyunStudent student);

	List<JiyunStudent> echartsStudent();
}