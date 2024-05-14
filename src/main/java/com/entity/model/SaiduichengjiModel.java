package com.entity.model;

import com.entity.SaiduichengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛队成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaiduichengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛队名称
     */
    private String saiduichengjiName;


    /**
     * 赛队人数
     */
    private Integer saiduichengjiNumbe;


    /**
     * 赛队所属地区
     */
    private String saiduichengjiaAddress;


    /**
     * 赛队所在地址
     */
    private String saiduichengjibAddress;


    /**
     * 赛队总成绩
     */
    private Integer saishifenshuChengji;


    /**
     * 参加的赛事
     */
    private String saiduichengjiaText;


    /**
     * 赛队详情
     */
    private String saiduichengjibText;


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
	 * 获取：赛队名称
	 */
    public String getSaiduichengjiName() {
        return saiduichengjiName;
    }


    /**
	 * 设置：赛队名称
	 */
    public void setSaiduichengjiName(String saiduichengjiName) {
        this.saiduichengjiName = saiduichengjiName;
    }
    /**
	 * 获取：赛队人数
	 */
    public Integer getSaiduichengjiNumbe() {
        return saiduichengjiNumbe;
    }


    /**
	 * 设置：赛队人数
	 */
    public void setSaiduichengjiNumbe(Integer saiduichengjiNumbe) {
        this.saiduichengjiNumbe = saiduichengjiNumbe;
    }
    /**
	 * 获取：赛队所属地区
	 */
    public String getSaiduichengjiaAddress() {
        return saiduichengjiaAddress;
    }


    /**
	 * 设置：赛队所属地区
	 */
    public void setSaiduichengjiaAddress(String saiduichengjiaAddress) {
        this.saiduichengjiaAddress = saiduichengjiaAddress;
    }
    /**
	 * 获取：赛队所在地址
	 */
    public String getSaiduichengjibAddress() {
        return saiduichengjibAddress;
    }


    /**
	 * 设置：赛队所在地址
	 */
    public void setSaiduichengjibAddress(String saiduichengjibAddress) {
        this.saiduichengjibAddress = saiduichengjibAddress;
    }
    /**
	 * 获取：赛队总成绩
	 */
    public Integer getSaishifenshuChengji() {
        return saishifenshuChengji;
    }


    /**
	 * 设置：赛队总成绩
	 */
    public void setSaishifenshuChengji(Integer saishifenshuChengji) {
        this.saishifenshuChengji = saishifenshuChengji;
    }
    /**
	 * 获取：参加的赛事
	 */
    public String getSaiduichengjiaText() {
        return saiduichengjiaText;
    }


    /**
	 * 设置：参加的赛事
	 */
    public void setSaiduichengjiaText(String saiduichengjiaText) {
        this.saiduichengjiaText = saiduichengjiaText;
    }
    /**
	 * 获取：赛队详情
	 */
    public String getSaiduichengjibText() {
        return saiduichengjibText;
    }


    /**
	 * 设置：赛队详情
	 */
    public void setSaiduichengjibText(String saiduichengjibText) {
        this.saiduichengjibText = saiduichengjibText;
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
