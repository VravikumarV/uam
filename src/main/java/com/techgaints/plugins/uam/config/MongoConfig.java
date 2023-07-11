package com.techgaints.plugins.uam.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoAuditing
//@EnableReactiveMongoAuditing
@EnableMongoRepositories(basePackages = {"com.techgaints.plugins.uam.repository.mongo"})
public class MongoConfig {
}
