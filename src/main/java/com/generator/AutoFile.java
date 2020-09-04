package com.generator;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.List;

public class AutoFile {
    /**
     * 测试 run 执行 注意：不生成service接口 注意：不生成service接口 注意：不生成service接口
     * <p>
     * 配置方法查看 {@link ConfigGenerator}
     * </p>
     */
    @Test
    public void ttt() {
        AutoGenerator mpg = new AutoGenerator();
// 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("C://java");//代码生成存放位置
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
//        gc.setIdType(IdType.AUTO);          //id是自增的
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList         是否生成通用查询结果列
                                                                // <sql id="Base_Column_List">
                                                                //        id, cname, pid
                                                                //    </sql>

        gc.setOpen(true);                                   //是否打开输出目录
        gc.setAuthor("小明");//此处填写代码生成人姓名
// 自定义文件命名，注意 %s 会自动填充表实体属性！
// gc.setMapperName("%sDao");
// gc.setXmlName("%sDao");
        gc.setServiceImplName("%sServiceImp");          //设置service接口的名字格式，默认是"I"+实体类名+"ServiceImp"
        gc.setServiceName("%sService");                 //设置service接口的名字格式，默认是"I"+实体类名+"Service"
// gc.setServiceImplName("%sServiceDiy");
// gc.setControllerName("%sAction");
        gc.setEntityName("%sEntity");
        mpg.setGlobalConfig(gc);
// 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");//数据库用户名
        dsc.setPassword("root");//数据库密码
        dsc.setUrl("jdbc:mysql://localhost:3306/user_1?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8");//数据库连接地址
/*dsc.setTypeConvert(new SqlServerTypeConvert(){
// 自定义数据库表字段类型转换【可选】
@Override
public DbColumnType processTypeConvert(String fieldType) {
if (fieldType.contains("tinyint") ) {
return DbColumnType.BLOB;
}
// 注意！！processTypeConvert 存在默认类型转换，
//如果不是你要的效果请自定义返回、非如下直接返回。
return super.processTypeConvert(fieldType);
}
});*/
        mpg.setDataSource(dsc);
// 策略配置
        StrategyConfig strategy = new StrategyConfig();
// strategy.setTablePrefix("sys_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略

/**
 * 第一步
 * 代码生成需要改动这里，将待生成的表名替换到下面
 *
 * 2017.11.2
 */
        strategy.setInclude(new String[] { "aa" ,"bbb","dd","city"}); // 需要生成的表
/**
 * 第二步
 * 去掉表名前缀
 *
 * 2017.11.2
 */
//        strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
// strategy.setExclude(new String[]{"test"}); // 排除生成的表
// 自定义实体父类
//        strategy.setSuperEntityClass("com.mayi.test.base.BaseEntity");
// 自定义实体，公共字段
        strategy.setSuperEntityColumns(
                new String[] {});
// 自定义 mapper 父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
// 自定义 service 父类
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
// 自定义 controller 父类
//        strategy.setSuperControllerClass("com.mayi.test.base.BaseController");
//逻辑删除属性名称
        strategy.setLogicDeleteFieldName("is_deleted");
        strategy.setEntityLombokModel(true);
        List<TableFill> tableFillList= CollUtil.newArrayList();
        TableFill fill=new TableFill("update_time", FieldFill.INSERT_UPDATE);
        tableFillList.add(fill);

        fill=new TableFill("create_time", FieldFill.INSERT);
        tableFillList.add(fill);

        strategy.setTableFillList(tableFillList);


// 自定义 service 实现类父类
//strategy.setSuperServiceImplClass("org.ibase4j.core.base.BaseService");
// 自定义 controller 父类
//strategy.setSuperControllerClass("org.ibase4j.core.base.AbstractController");
// 【实体】是否生成字段常量（默认 false）
// public static final String ID = "test_id";
// strategy.setEntityColumnConstant(true);
// 【实体】是否为构建者模型（默认 false）
// public User setName(String name) {this.name = name; return this;}
// strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);
// 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mayi");       //此处填写父模块所在的groupId
/**
 * 第三步
 * 按模块调整代码放置目录
 *
 * 2017.11.2
 */
        pc.setEntity("sys.entity");
        pc.setMapper("sys.dao");
//        pc.setXml("sys.dao.mappers");         //注释掉生成就在目录最外面
        pc.setService("sys.service");
        pc.setServiceImpl("sys.service.impl");
        pc.setController("sys.web");
        mpg.setPackageInfo(pc);
// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
/*InjectionConfig cfg = new InjectionConfig() {
public void initMap() {
Map<String, Object> map = new HashMap<String, Object>();
map.put("providerClass", "ISysProvider");
map.put("providerClassPackage", "org.ibase4j.provider.ISysProvider");
this.setMap(map);
}
};
mpg.setCfg(cfg);*/
// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity("templates/entity.java.vm");
        tc.setMapper("templates/mapper.java.vm");
        tc.setXml("templates/mapper.xml.vm");
        tc.setServiceImpl("templates/serviceImp.java.vm");
        tc.setController("templates/controller.java.vm");
        tc.setService("templates/service.java.vm");
        mpg.setTemplate(tc);
// 执行生成
        mpg.execute();
        System.out.println("代码生成完毕");
    }
}
