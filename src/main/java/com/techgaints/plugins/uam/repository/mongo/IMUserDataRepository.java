package com.techgaints.plugins.uam.repository.mongo;

import com.techgaints.plugins.uam.model.mongo.MUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IMUserDataRepository extends MongoRepository<MUser, String> {
/*    @Query("{name:'?0'}")
    MUser findItemByName(String name);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<MUser> findAll(String category);*/

    public long count();
}

