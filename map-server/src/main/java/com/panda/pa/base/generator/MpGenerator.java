package com.panda.pa.base.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * @Auther: wl
 * @Date: 2020/2/27 13:51
 * @Description:
 */

@Slf4j
public class MpGenerator {

 public static void main(String[] args) {

  final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
  log.info("开始生成表{}实体类及接口",rb.getString("tableName"));
  // 代码生成器
  AutoGenerator mpg = new AutoGenerator();
  GlobalConfig gc = new GlobalConfig();
  gc.setOutputDir(rb.getString("OutputDir"));
  gc.setOpen(false);
  gc.setBaseResultMap(true);
  gc.setBaseColumnList(true);
  gc.setAuthor(rb.getString("author"));
  gc.setMapperName("%sMapper");
  gc.setXmlName("%sMapper");
  gc.setServiceName("%sService");
  gc.setServiceImplName("%sServiceImpl");
  gc.setControllerName("%sController");
  mpg.setGlobalConfig(gc);

// 数据源配置
  DataSourceConfig dsc = new DataSourceConfig();
  dsc.setDbType(DbType.MYSQL);
  dsc.setUrl(rb.getString("url"));
  dsc.setDriverName("com.mysql.jdbc.Driver");
  dsc.setUsername(rb.getString("userName"));
  dsc.setPassword(rb.getString("password"));
  mpg.setDataSource(dsc);

  // 包配置
  PackageConfig pc = new PackageConfig();
  pc.setParent(rb.getString("parent"));
  pc.setController("controller." + rb.getString("className"));
  pc.setService("service." + rb.getString("className"));
  pc.setServiceImpl("service." + rb.getString("className") + ".impl");
  pc.setEntity("entity." + rb.getString("className"));
  pc.setMapper("mapper." + rb.getString("className"));
  mpg.setPackageInfo(pc);

  // 自定义配置
  InjectionConfig cfg = new InjectionConfig() {
   @Override
   public void initMap() {
    // to do nothing
   }
  };
  List<FileOutConfig> focList = new ArrayList<>();
  focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
   @Override
   public String outputFile(TableInfo tableInfo) {
    // 自定义输入文件名称
    return rb.getString("OutputDirXml") + "/mapper/" + rb.getString("className") + "/" + tableInfo.getEntityName()+"Mapper" + StringPool.DOT_XML;
   }
  });
  cfg.setFileOutConfigList(focList);
  mpg.setCfg(cfg);
  mpg.setTemplate(new TemplateConfig().setXml(null));

  // 策略配置
  StrategyConfig strategy = new StrategyConfig();
  strategy.setNaming(NamingStrategy.underline_to_camel);
  strategy.setColumnNaming(NamingStrategy.underline_to_camel);
  strategy.setEntityLombokModel(true);
  strategy.setInclude(new String[]{rb.getString("tableName")});
  mpg.setStrategy(strategy);
  mpg.setTemplateEngine(new FreemarkerTemplateEngine());
  mpg.execute();
  log.info("生成表{}实体类及接口成功",rb.getString("tableName"));
  log.info("生成接口路径{} ,xml路径{}",rb.getString("OutputDir"),rb.getString("OutputDirXml"));

 }


}

