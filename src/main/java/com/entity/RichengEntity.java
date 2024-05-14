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
 * 日程信息
 *
 * @author 
 * @email
 */
@TableName("richeng")
public class RichengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RichengEntity() {

	}

	public RichengEntity(T t) {
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
     * 日程标题
     */
    @TableField(value = "richeng_name")

    private String richengName;


    /**
     * 场次
     */
    @TableField(value = "richeng_changci")

    private String richengChangci;


    /**
     * 时间段
     */
    @TableField(value = "shijianduan_types")

    private Integer shijianduanTypes;


    /**
     * 时间信息
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "richeng_time")

    private Date richengTime;


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
	 * 设置：日程标题
	 */
    public String getRichengName() {
        return richengName;
    }
    /**
	 * 获取：日程标题
	 */

    public void setRichengName(String richengName) {
        this.richengName = richengName;
    }
    /**
	 * 设置：场次
	 */
    public String getRichengChangci() {
        return richengChangci;
    }
    /**
	 * 获取：场次
	 */

    public void setRichengChangci(String richengChangci) {
        this.richengChangci = richengChangci;
    }
    /**
	 * 设置：时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }
    /**
	 * 获取：时间段
	 */

    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 设置：时间信息
	 */
    public Date getRichengTime() {
        return richengTime;
    }
    /**
	 * 获取：时间信息
	 */

    public void setRichengTime(Date richengTime) {
        this.richengTime = richengTime;
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
        return "Richeng{" +
            "id=" + id +
            ", richengName=" + richengName +
            ", richengChangci=" + richengChangci +
            ", shijianduanTypes=" + shijianduanTypes +
            ", richengTime=" + richengTime +
            ", createTime=" + createTime +
        "}";
    }
}
