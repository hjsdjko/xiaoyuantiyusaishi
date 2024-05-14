package com.entity.model;

import com.entity.SaishifenshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishifenshuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛事信息
     */
    private Integer saishiId;


    /**
     * 运动员
     */
    private Integer yonghuId;


    /**
     * 赛事成绩
     */
    private Integer saishifenshuChengji;


    /**
     * 详情信息
     */
    private String saishifenshuText;


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
	 * 获取：赛事信息
	 */
    public Integer getSaishiId() {
        return saishiId;
    }


    /**
	 * 设置：赛事信息
	 */
    public void setSaishiId(Integer saishiId) {
        this.saishiId = saishiId;
    }
    /**
	 * 获取：运动员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：运动员
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：赛事成绩
	 */
    public Integer getSaishifenshuChengji() {
        return saishifenshuChengji;
    }


    /**
	 * 设置：赛事成绩
	 */
    public void setSaishifenshuChengji(Integer saishifenshuChengji) {
        this.saishifenshuChengji = saishifenshuChengji;
    }
    /**
	 * 获取：详情信息
	 */
    public String getSaishifenshuText() {
        return saishifenshuText;
    }


    /**
	 * 设置：详情信息
	 */
    public void setSaishifenshuText(String saishifenshuText) {
        this.saishifenshuText = saishifenshuText;
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
