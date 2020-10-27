package com.dxc.Dao;


import javax.sql.DataSource;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {
  "com.zurich.pes.myprofile.account.repository"  
})
@EnableTransactionManagement
public class H2TestConfig {

 

    
    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver ");
        dataSource.setUrl("jdbc:mysql://localhost:3306/devops");
        dataSource.setUsername("root");
        dataSource.setPassword("Bmb@1905$");
 
        return dataSource;
    }
     
}