package com.hyders.persistence;


import com.hyders.persistence.jpa.IUserDao;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@ComponentScan({"com.hyders.persistence" })
@EnableJpaRepositories(basePackages = "com.hyders.persistence.jpa")
public class PersistenceConfigTest {

    @Autowired
    Environment environment;

    @Autowired
    private IUserDao userDao;


    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(restDataSource());
        sessionFactoryBean.setPackagesToScan(new String[] {"com.hyders.persistence.model"});
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
}

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    @Bean
    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto",
                        environment.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect",
                        environment.getProperty("hibernate.dialect"));
                setProperty("hibernate.globally_quoted_identifiers",
                        "true");
            }
        };
    }

    @Bean
    public DataSource restDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
