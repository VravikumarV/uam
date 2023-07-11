package com.techgaints.plugins.uam.config;

import com.techgaints.plugins.uam.repository.AuditorAwareImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableAspectJAutoProxy
@EnableJpaRepositories(
        basePackages = {"com.techgaints.plugins.uam.repository.jpa"},
        entityManagerFactoryRef = "entityManagerFactory1",
        transactionManagerRef = "transactionManager1"
        //,queryLookupStrategy =
        //,namedQueriesLocation =
        //,bootstrapMode = BootstrapMode.DEFERRED
        //,enableDefaultTransactions = true
        )
@EnableTransactionManagement
@Configuration
public class JPAConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.
                create().
                driverClassName("org.hibernate.dialect.PostgreSQLDialect").
                url("jdbc:postgresql://postgresdb:5432/techgaints").
                username("postgres").
                password("VhrS!fKt@123456").
                build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.techgaints.plugins.uam.model.jpa");
        factory.setDataSource(dataSource());
        /*factory.setPersistenceUnitName();
        factory.setJtaDataSource();
        factory.setPersistenceUnitManager();
        factory.setSharedCacheMode();
        factory.setValidationMode();
        factory.getPersistenceUnitInfo()
        factory.setPersistenceUnitPostProcessors();
        factory.setPersistenceUnitRootLocation();
        factory.setBootstrapExecutor();
        factory.setSharedCacheMode();
        factory.setJpaProperties();
        factory.setJpaVendorAdapter();
        factory.setEntityManagerInitializer();
        factory.setEntityManagerInterface();*/
        return factory;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager1(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        /*txManager.setDataSource();
        txManager.setJpaProperties();
        txManager.setJpaPropertyMap();
        txManager.setJpaDialect();
        txManager.setPersistenceUnitName();
        txManager.setDefaultTimeout();
        txManager.setFailEarlyOnGlobalRollbackOnly();
        txManager.setGlobalRollbackOnParticipationFailure();
        txManager.setNestedTransactionAllowed();
        txManager.setEntityManagerInitializer();
        txManager.setDataSource();
        txManager.setRollbackOnCommitFailure();
        txManager.setPersistenceUnitName();
        txManager.setTransactionSynchronization();
        txManager.setEntityManagerInitializer();*/

        return txManager;
    }

    @Bean
    public AuditorAware <String> auditorProvider() {
        return new AuditorAwareImpl();
    }

}
