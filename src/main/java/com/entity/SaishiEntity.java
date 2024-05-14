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
 * 赛事信息
 *
 * @author 
 * @email
 */
@TableName("saishi")
public class SaishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishiEntity() {

	}

	public SaishiEntity(T t) {
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
     * 赛事名称
     */
    @TableField(value = "saishi_name")

    private String saishiName;


    /**
     * 赛事类型
     */
    @TableField(value = "saishi_types")

    private Integer saishiTypes;


    /**
     * 日程
     */
    @TableField(value = "richeng_id")

    private Integer richengId;


    /**
     * 赛事负责人
     */
    @TableField(value = "saishi_fuzeren")

    private String saishiFuzeren;


    /**
     * 赛事资料
     */
    @TableField(value = "saishi_file")

    private String saishiFile;


    /**
     * 场地信息
     */
    @TableField(value = "saishi_address")

    private String saishiAddress;


    /**
     * 赛事状态
     */
    @TableField(value = "saishi_status_types")

    private Integer saishiStatusTypes;


    /**
     * 项目信息
     */
    @TableField(value = "saishi_content")

    private String saishiContent;


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
	 * 设置：赛事名称
	 */
    public String getSaishiName() {
        return saishiName;
    }
    /**
	 * 获取：赛事名称
	 */

    public void setSaishiName(String saishiName) {
        this.saishiName = saishiName;
    }
    /**
	 * 设置：赛事类型
	 */
    public Integer getSaishiTypes() {
        return saishiTypes;
    }
    /**
	 * 获取：赛事类型
	 */

    public void setSaishiTypes(Integer saishiTypes) {
        this.saishiTypes = saishiTypes;
    }
    /**
	 * 设置：日程
	 */
    public Integer getRichengId() {
        return richengId;
    }
    /**
	 * 获取：日程
	 */

    public void setRichengId(Integer richengId) {
        this.richengId = richengId;
    }
    /**
	 * 设置：赛事负责人
	 */
    public String getSaishiFuzeren() {
        return saishiFuzeren;
    }
    /**
	 * 获取：赛事负责人
	 */

    public void setSaishiFuzeren(String saishiFuzeren) {
        this.saishiFuzeren = saishiFuzeren;
    }
    /**
	 * 设置：赛事资料
	 */
    public String getSaishiFile() {
        return saishiFile;
    }
    /**
	 * 获取：赛事资料
	 */

    public void setSaishiFile(String saishiFile) {
        this.saishiFile = saishiFile;
    }
    /**
	 * 设置：场地信息
	 */
    public String getSaishiAddress() {
        return saishiAddress;
    }
    /**
	 * 获取：场地信息
	 */

    public void setSaishiAddress(String saishiAddress) {
        this.saishiAddress = saishiAddress;
    }
    /**
	 * 设置：赛事状态
	 */
    public Integer getSaishiStatusTypes() {
        return saishiStatusTypes;
    }
    /**
	 * 获取：赛事状态
	 */

    public void setSaishiStatusTypes(Integer saishiStatusTypes) {
        this.saishiStatusTypes = saishiStatusTypes;
    }
    /**
	 * 设置：项目信息
	 */
    public String getSaishiContent() {
        return saishiContent;
    }
    /**
	 * 获取：项目信息
	 */

    public void setSaishiContent(String saishiContent) {
        this.saishiContent = saishiContent;
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
        return "Saishi{" +
            "id=" + id +
            ", saishiName=" + saishiName +
            ", saishiTypes=" + saishiTypes +
            ", richengId=" + richengId +
            ", saishiFuzeren=" + saishiFuzeren +
            ", saishiFile=" + saishiFile +
            ", saishiAddress=" + saishiAddress +
            ", saishiStatusTypes=" + saishiStatusTypes +
            ", saishiContent=" + saishiContent +
            ", createTime=" + createTime +
        "}";
    }
}
