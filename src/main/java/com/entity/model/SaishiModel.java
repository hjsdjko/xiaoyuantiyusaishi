package com.entity.model;

import com.entity.SaishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛事名称
     */
    private String saishiName;


    /**
     * 赛事类型
     */
    private Integer saishiTypes;


    /**
     * 日程
     */
    private Integer richengId;


    /**
     * 赛事负责人
     */
    private String saishiFuzeren;


    /**
     * 赛事资料
     */
    private String saishiFile;


    /**
     * 场地信息
     */
    private String saishiAddress;


    /**
     * 赛事状态
     */
    private Integer saishiStatusTypes;


    /**
     * 项目信息
     */
    private String saishiContent;


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
	 * 获取：赛事名称
	 */
    public String getSaishiName() {
        return saishiName;
    }


    /**
	 * 设置：赛事名称
	 */
    public void setSaishiName(String saishiName) {
        this.saishiName = saishiName;
    }
    /**
	 * 获取：赛事类型
	 */
    public Integer getSaishiTypes() {
        return saishiTypes;
    }


    /**
	 * 设置：赛事类型
	 */
    public void setSaishiTypes(Integer saishiTypes) {
        this.saishiTypes = saishiTypes;
    }
    /**
	 * 获取：日程
	 */
    public Integer getRichengId() {
        return richengId;
    }


    /**
	 * 设置：日程
	 */
    public void setRichengId(Integer richengId) {
        this.richengId = richengId;
    }
    /**
	 * 获取：赛事负责人
	 */
    public String getSaishiFuzeren() {
        return saishiFuzeren;
    }


    /**
	 * 设置：赛事负责人
	 */
    public void setSaishiFuzeren(String saishiFuzeren) {
        this.saishiFuzeren = saishiFuzeren;
    }
    /**
	 * 获取：赛事资料
	 */
    public String getSaishiFile() {
        return saishiFile;
    }


    /**
	 * 设置：赛事资料
	 */
    public void setSaishiFile(String saishiFile) {
        this.saishiFile = saishiFile;
    }
    /**
	 * 获取：场地信息
	 */
    public String getSaishiAddress() {
        return saishiAddress;
    }


    /**
	 * 设置：场地信息
	 */
    public void setSaishiAddress(String saishiAddress) {
        this.saishiAddress = saishiAddress;
    }
    /**
	 * 获取：赛事状态
	 */
    public Integer getSaishiStatusTypes() {
        return saishiStatusTypes;
    }


    /**
	 * 设置：赛事状态
	 */
    public void setSaishiStatusTypes(Integer saishiStatusTypes) {
        this.saishiStatusTypes = saishiStatusTypes;
    }
    /**
	 * 获取：项目信息
	 */
    public String getSaishiContent() {
        return saishiContent;
    }


    /**
	 * 设置：项目信息
	 */
    public void setSaishiContent(String saishiContent) {
        this.saishiContent = saishiContent;
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
