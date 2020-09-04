# MybatisPlus-generator
mybatis-plus代码生成器简易版
只生成一个文件，内部并没有任何方法。

在AutoFile类中标注数据库地址，用户名，密码，以及要生成的表名集合，即可生成相关代码，
主要生成内容是controller、service、serviceImp、dao、mapper文件、entity实体类，
代码文件存放位置可以通过gc.setOutputDir("")来修改。
