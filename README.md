# MybatisPlus-generator
mybatis-plus代码生成器简易版
只生成文件，相关类内部并没有任何方法。
也可以对vm模版文件进行修改，生成指定格式的文件

在AutoFile类中标注数据库URL，用户名，密码，以及要生成的表名集合，即可生成相关代码，
主要生成内容是controller、service、serviceImp、dao、mapper文件、entity实体类，
代码文件存放位置可以通过gc.setOutputDir("")来修改。
