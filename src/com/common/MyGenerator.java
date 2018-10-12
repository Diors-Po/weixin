package com.common;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;
import com.wxConfig.MyConfig;

public class MyGenerator {
	public static DataSource getDataSource() {
		PropKit.use("db.config");
		DruidPlugin druidPlugin = MyConfig.createDruidPlugin();
		druidPlugin.start();
		return druidPlugin.getDataSource();
	}
	
	public static void main(String[] args){
		// base model ��ʹ�õİ���
				String baseModelPackageName = "com.demo.common.model.base";
				// base model �ļ�����·��
				String baseModelOutputDir = PathKit.getWebRootPath() + "/../src/com/demo/common/model/base";
				
				// model ��ʹ�õİ��� (MappingKit Ĭ��ʹ�õİ���)
				String modelPackageName = "com.demo.common.model";
				// model �ļ�����·�� (MappingKit �� DataDictionary �ļ�Ĭ�ϱ���·��)
				String modelOutputDir = baseModelOutputDir + "/..";
				
				// ����������
				Generator generator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
				// �����Ƿ�������ʽ setter ����
				generator.setGenerateChainSetter(false);
				// ��Ӳ���Ҫ���ɵı���
				generator.addExcludedTable("adv");
				// �����Ƿ��� Model ������ dao ����
				generator.setGenerateDaoInModel(false);
				// �����Ƿ�������ʽ setter ����
				generator.setGenerateChainSetter(true);
				// �����Ƿ������ֵ��ļ�
				generator.setGenerateDataDictionary(false);
				// ������Ҫ���Ƴ��ı���ǰ׺��������modelName��������� "osc_user"���Ƴ�ǰ׺ "osc_"�����ɵ�model��Ϊ "User"���� OscUser
				generator.setRemovedTableNamePrefixes("t_");
				// ����
				generator.generate();
	}
}
