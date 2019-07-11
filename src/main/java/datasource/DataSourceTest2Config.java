package datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configurable //注册到Springboot容器中
@MapperScan(basePackages = "test02.dao", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSourceTest2Config {
    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        return bean.getObject();
    }

    @Bean(name = "test2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
