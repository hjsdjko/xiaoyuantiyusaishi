package com.entity.vo;

import com.entity.SaishibaomingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛事报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saishibaoming")
public class SaishibaomingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 赛事信息
     */

    @TableField(value = "saishi_id")
    private Integer saishiId;


    /**
     * 运动员
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名状态
     */

    @TableField(value = "saishibaoming_yesno_types")
    private Integer saishibaomingYesnoTypes;


    /**
     * 报名结果
     */

    @TableField(value = "saishibaoming_yesno_text")
    private String saishibaomingYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：赛事信息
	 */
    public Integer getSaishiId() {
        return saishiId;
    }


    /**
	 * 获取：赛事信息
	 */

    public void setSaishiId(Integer saishiId) {
        this.saishiId = saishiId;
    }
    /**
	 * 设置：运动员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：运动员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getSaishibaomingYesnoTypes() {
        return saishibaomingYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setSaishibaomingYesnoTypes(Integer saishibaomingYesnoTypes) {
        this.saishibaomingYesnoTypes = saishibaomingYesnoTypes;
    }
    /**
	 * 设置：报名结果
	 */
    public String getSaishibaomingYesnoText() {
        return saishibaomingYesnoText;
    }


    /**
	 * 获取：报名结果
	 */

    public void setSaishibaomingYesnoText(String saishibaomingYesnoText) {
        this.saishibaomingYesnoText = saishibaomingYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
