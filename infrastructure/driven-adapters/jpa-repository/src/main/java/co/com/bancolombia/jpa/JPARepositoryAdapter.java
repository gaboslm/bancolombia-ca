package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<User, UserEntity, String, JPARepository>
implements UserRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public User getUser(String id) {
        return this.toEntity(this.repository.findById(id).orElse(new UserEntity()));
    }

    @Override
    public User updateUser(User user) {
        return this.toEntity(this.repository.save(this.toData(user)));
    }

    @Override
    public void deleteUser(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public User saveUser(User user) {
        return this.toEntity(this.repository.save(this.toData(user)));
    }
}
