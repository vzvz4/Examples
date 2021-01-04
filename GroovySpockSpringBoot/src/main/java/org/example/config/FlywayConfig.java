//package org.example.config;
//
//import org.flywaydb.core.Flyway;
//import org.flywaydb.core.api.configuration.ClassicConfiguration;
//import org.flywaydb.core.api.configuration.FluentConfiguration;
//import org.springframework.boot.autoconfigure.data.jpa.EntityManagerFactoryDependsOnPostProcessor;
//import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//class FlywayConfig {
//
//    @Bean
//    public Flyway flyway(DataSource dataSource) {
//        org.flywaydb.core.api.configuration.Configuration configuration = new ClassicConfiguration();
//        configuration = new FluentConfiguration()
//        return new Flyway(configuration);
//    }
//
//    @Bean
//    public FlywayMigrationInitializer flywayInitializer(Flyway flyway){
//        return new FlywayMigrationInitializer(flyway, null);
//    }
//
//    /**
//     * Additional configuration to ensure that [EntityManagerFactory] beans depend on the
//     * `flywayInitializer` bean.
//     */
//    @Configuration
//    public static class FlywayInitializerJpaDependencyConfiguration extends EntityManagerFactoryDependsOnPostProcessor {
//        public FlywayInitializerJpaDependencyConfiguration() {
//            super("flywayInitializer");
//        }
//    }
//}
