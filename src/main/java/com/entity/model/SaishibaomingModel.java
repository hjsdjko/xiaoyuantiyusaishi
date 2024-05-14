package com.entity.model;

import com.entity.SaishibaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishibaomingModel implements Serializable {
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
     * 报名状态
     */
    private Integer saishibaomingYesnoTypes;


    /**
     * 报名结果
     */
    private String saishibaomingYesnoText;


    /**
     * 创建时间
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
	 * 获取：报名状态
	 */
    public Integer getSaishibaomingYesnoTypes() {
        return saishibaomingYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setSaishibaomingYesnoTypes(Integer saishibaomingYesnoTypes) {
        this.saishibaomingYesnoTypes = saishibaomingYesnoTypes;
    }
    /**
	 * 获取：报名结果
	 */
    public String getSaishibaomingYesnoText() {
        return saishibaomingYesnoText;
    }


    /**
	 * 设置：报名结果
	 */
    public void setSaishibaomingYesnoText(String saishibaomingYesnoText) {
        this.saishibaomingYesnoText = saishibaomingYesnoText;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
