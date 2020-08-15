package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "jiyun_student")
public class JiyunStudent implements Serializable {
    @Id
    private Integer id;

    @Column(name = "course_id")
    private Integer courseId;

    private String name;

    private Integer age;

    private Integer code;

    private String grade;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date entrytime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @Transient
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date b1;
    @Transient
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date b2;
    @Transient
    private String cname;
    @Transient
    private Integer num;
    

    private static final long serialVersionUID = 1L;

    public Date getB1() {
		return b1;
	}

	public void setB1(Date b1) {
		this.b1 = b1;
	}

	public Date getB2() {
		return b2;
	}

	public void setB2(Date b2) {
		this.b2 = b2;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return course_id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * @return entrytime
     */
    public Date getEntrytime() {
        return entrytime;
    }

    /**
     * @param entrytime
     */
    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


}