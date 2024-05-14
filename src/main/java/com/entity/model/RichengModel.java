package com.entity.model;

import com.entity.RichengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 日程信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RichengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 日程标题
     */
    private String richengName;


    /**
     * 场次
     */
    private String richengChangci;


    /**
     * 时间段
     */
    private Integer shijianduanTypes;


    /**
     * 时间信息
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    private Date richengTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：日程标题
	 */
    public String getRichengName() {
        return richengName;
    }


    /**
	 * 设置：日程标题
	 */
    public void setRichengName(String richengName) {
        this.richengName = richengName;
    }
    /**
	 * 获取：场次
	 */
    public String getRichengChangci() {
        return richengChangci;
    }


    /**
	 * 设置：场次
	 */
    public void setRichengChangci(String richengChangci) {
        this.richengChangci = richengChangci;
    }
    /**
	 * 获取：时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }


    /**
	 * 设置：时间段
	 */
    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 获取：时间信息
	 */
    public Date getRichengTime() {
        return richengTime;
    }


    /**
	 * 设置：时间信息
	 */
    public void setRichengTime(Date richengTime) {
        this.richengTime = richengTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
