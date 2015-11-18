package com.blackcat.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtil {

	private Configuration cfg;
	private static String outputPath = new File("").getAbsolutePath()+"\\gen\\";
	
	private static final String url = "jdbc:mysql://localhost:3306/test" ;    
	private static final String username = "root" ;   
	private static final String password = "root" ;
	
	public void init() throws Exception {
		// 初始化FreeMarker配置
		// 创建一个Configuration实例
		cfg = new Configuration();
		// 设置FreeMarker的模版文件位置
		cfg.setDirectoryForTemplateLoading(new File(
				FreemarkerUtil.class.getResource("").getFile()));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(FreemarkerUtil hf) throws Exception {

		Map root = new HashMap();

		String Module = "";
		String model_name = "User";
		String model_name_list = "Users";
		String instant = "user";
		String model_name_cn = "用户";
		String author = "张何兵";
		String link = "<a href=http://www.media999.com.cn>北京华亚美科技有限公司</a>";// 模块开发公司网地址
		Date date = new Date();

		root.put("module", Module);
		root.put("model_name", model_name);
		root.put("model_name_list", model_name_list);
		root.put("instant", instant);
		root.put("model_name_cn", model_name_cn);
		root.put("author", author);
		root.put("link", link);
		root.put("date", date);

		String projectPath = "D://Workspaces//MyEclipse75//s2sh//";

		String fileName = "I" + model_name + "DAO.java";

		String savePath = "src//com//media//dao//";

		Template template = cfg.getTemplate("IDAO.ftl");

		hf.buildTemplate(root, projectPath, savePath, fileName, template);

		fileName = model_name + "DAOHibernate.java";
		savePath = "src//com//media//dao//hibernate//";
		template = cfg.getTemplate("DAOHibernate.ftl");
		hf.buildTemplate(root, projectPath, savePath, fileName, template);

		fileName = model_name + "Service.java";
		savePath = "src//com//media//service//";
		template = cfg.getTemplate("Service.ftl");
		hf.buildTemplate(root, projectPath, savePath, fileName, template);

		fileName = model_name + "ServiceImpl.java";
		savePath = "src//com//media//service//impl//";
		template = cfg.getTemplate("ServiceImpl.ftl");
		hf.buildTemplate(root, projectPath, savePath, fileName, template);

	}

	public void buildTemplate(Map root, String projectPath, String savePath,
			String fileName, Template template) {
		String realFileName = projectPath + savePath + fileName;

		String realSavePath = projectPath + "/" + savePath;

		File newsDir = new File(realSavePath);
		if (!newsDir.exists()) {
			newsDir.mkdirs();
		}

		try {
			// SYSTEM_ENCODING = "UTF-8";
			Writer out = new OutputStreamWriter(new FileOutputStream(
					realFileName), "UTF-8");

			template.process(root, out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void gen() throws Exception {
		FreemarkerUtil hf = new FreemarkerUtil();
		hf.init();
		hf.process(hf);
	}

	//获取需要生成代码的表
	private Element getTableCfgs() throws Throwable {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(FreemarkerUtil.class.getResourceAsStream("gencfg.xml"));
		//System.out.println(doc.getRootElement().asXML());
		return doc.getRootElement();
	}
}
