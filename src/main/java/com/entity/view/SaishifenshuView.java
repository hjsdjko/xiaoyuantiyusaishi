package com.entity.view;

import com.entity.SaishifenshuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 赛事成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("saishifenshu")
public class SaishifenshuView extends SaishifenshuEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 saishi
			/**
			* 赛事名称
			*/
			private String saishiName;
			/**
			* 赛事类型
			*/
			private Integer saishiTypes;
				/**
				* 赛事类型的值
				*/
				private String saishiValue;
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
				* 赛事状态的值
				*/
				private String saishiStatusValue;
			/**
			* 项目信息
			*/
			private String saishiContent;

		//级联表 yonghu
			/**
			* 运动员姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public SaishifenshuView() {

	}

	public SaishifenshuView(SaishifenshuEntity saishifenshuEntity) {
		try {
			BeanUtils.copyProperties(this, saishifenshuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















				//级联表的get和set saishi

					/**
					* 获取： 赛事名称
					*/
					public String getSaishiName() {
						return saishiName;
					}
					/**
					* 设置： 赛事名称
					*/
					public void setSaishiName(String saishiName) {
						this.saishiName = saishiName;
					}

					/**
					* 获取： 赛事类型
					*/
					public Integer getSaishiTypes() {
						return saishiTypes;
					}
					/**
					* 设置： 赛事类型
					*/
					public void setSaishiTypes(Integer saishiTypes) {
						this.saishiTypes = saishiTypes;
					}


						/**
						* 获取： 赛事类型的值
						*/
						public String getSaishiValue() {
							return saishiValue;
						}
						/**
						* 设置： 赛事类型的值
						*/
						public void setSaishiValue(String saishiValue) {
							this.saishiValue = saishiValue;
						}


					/**
					* 获取： 赛事负责人
					*/
					public String getSaishiFuzeren() {
						return saishiFuzeren;
					}
					/**
					* 设置： 赛事负责人
					*/
					public void setSaishiFuzeren(String saishiFuzeren) {
						this.saishiFuzeren = saishiFuzeren;
					}

					/**
					* 获取： 赛事资料
					*/
					public String getSaishiFile() {
						return saishiFile;
					}
					/**
					* 设置： 赛事资料
					*/
					public void setSaishiFile(String saishiFile) {
						this.saishiFile = saishiFile;
					}

					/**
					* 获取： 场地信息
					*/
					public String getSaishiAddress() {
						return saishiAddress;
					}
					/**
					* 设置： 场地信息
					*/
					public void setSaishiAddress(String saishiAddress) {
						this.saishiAddress = saishiAddress;
					}

					/**
					* 获取： 赛事状态
					*/
					public Integer getSaishiStatusTypes() {
						return saishiStatusTypes;
					}
					/**
					* 设置： 赛事状态
					*/
					public void setSaishiStatusTypes(Integer saishiStatusTypes) {
						this.saishiStatusTypes = saishiStatusTypes;
					}


						/**
						* 获取： 赛事状态的值
						*/
						public String getSaishiStatusValue() {
							return saishiStatusValue;
						}
						/**
						* 设置： 赛事状态的值
						*/
						public void setSaishiStatusValue(String saishiStatusValue) {
							this.saishiStatusValue = saishiStatusValue;
						}

					/**
					* 获取： 项目信息
					*/
					public String getSaishiContent() {
						return saishiContent;
					}
					/**
					* 设置： 项目信息
					*/
					public void setSaishiContent(String saishiContent) {
						this.saishiContent = saishiContent;
					}










				//级联表的get和set yonghu

					/**
					* 获取： 运动员姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 运动员姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
