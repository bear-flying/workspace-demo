package com.idsmanager.yhm_demo.infrastructure.mongodb;


import com.idsmanager.commons.utils.mongo.AbstractMongoSupport;
import com.idsmanager.yhm_demo.domain.security.SecurityUtils;
import com.idsmanager.yhm_demo.domain.security.User;
import com.idsmanager.yhm_demo.domain.security.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userRepositoryMongoDB")
public class UserRepositoryMongoDB extends AbstractMongoSupport implements UserRepository {


    @Autowired
    private MongoOperations mongoTemplate;


    @Override
    protected MongoOperations mongoTemplate() {
        return this.mongoTemplate;
    }

    @Override
    public void saveUser(User user) {
        mongoTemplate().save(user);
    }

    @Override
    public User findByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate().findOne(query, User.class);
    }

    @Override
    public void removeUser(User user) {
        mongoTemplate().remove(user);
    }

    @Override
    public User findByGuid(String guid) {
        Query query = createIDQuery(guid);
        return mongoTemplate().findOne(query, User.class);
    }

    @Override
    public User currentUser() {
        return findById(User.class, SecurityUtils.currentUserGuid());
    }


    @Override
    public List<User> findUserPaginated(Map<String, Object> map) {

        Query query = new Query();
        addPagination(query, map);

        addQueryConditions(map, query);

        return this.mongoTemplate().find(query, User.class);
    }

    private void addQueryConditions(Map<String, Object> map, Query query) {
        final String username = (String) map.get("username");
        if (StringUtils.isNotEmpty(username)) {
            addRegexCriteria(query, "username", username);
        }
    }

    @Override
    public long totalUserPaginated(Map<String, Object> map) {
        Query query = new Query();
        addPagination(query, map);

        addQueryConditions(map, query);
        return this.mongoTemplate().count(query, User.class);
    }

    @Override
    public void updateUserPassword(User user) {
        Update update = new Update();
        update.set("password", user.password());

        Query query = createIDQuery(user.uuid());
        this.mongoTemplate().updateFirst(query, update, User.class);
    }

    @Override
    public long countUsers() {
        final Query query = new Query();
        return this.mongoTemplate().count(query, User.class);
    }

    @Override
    public void updateUser(User user) {
        Update update = new Update();
        update.set("username", user.username());
        update.set("privileges", user.privileges());

        Query query = createIDQuery(user.uuid());
        this.mongoTemplate().updateFirst(query, update, User.class);
    }


}
