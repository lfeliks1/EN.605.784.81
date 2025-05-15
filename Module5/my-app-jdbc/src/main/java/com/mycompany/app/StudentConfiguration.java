package com.mycompany.app;

import javax.sql.DataSource;
import org.h2.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import com.mycompany.app.JdbcStudentDao;
import com.mycompany.app.StudentDao;

@Configuration
public class StudentConfiguration {

@Bean
public StudentDao StudentDao(DataSource dataSource) {
    return new JdbcStudentDao(dataSource);
}

@Bean
public DataSource dataSource() {
    var dataSource = new SimpleDriverDataSource();
    dataSource.setDriverClass(org.h2.Driver.class);

    // next line deifines the DB URL using embedded JDBC driver and forcing H2 DB to run in Embedded (single-thread) mode 
    /*
    dataSource.setUrl("jdbc:h2:~/605784_development/784-SpringBoot-Enterprise-Computing-with-Java/assignments/Module5/SRS_H2_DB");
    */
    // next line deifines the DB URL using H2 DB runnig in Server(multi-thread) mode 
     
    dataSource.setUrl("jdbc:h2:tcp://localhost:9092/~/605784_development/784-SpringBoot-Enterprise-Computing-with-Java/assignments/Module5/SRS_H2_DB");
    
       
    // to use next 2 lines only of your DB is secured
    // dataSource.setUsername("my-user-name");
    // dataSource.setPassword("my-password");

    return dataSource;
}

}