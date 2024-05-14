package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 赛事报名
 *
 * @author 
 * @email
 */
@TableName("saishibaoming")
public class SaishibaomingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishibaomingEntity() {

	}

	public SaishibaomingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Saishibaoming{" +
            "id=" + id +
            ", saishiId=" + saishiId +
            ", yonghuId=" + yonghuId +
            ", saishibaomingYesnoTypes=" + saishibaomingYesnoTypes +
            ", saishibaomingYesnoText=" + saishibaomingYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
