package bb.repository;

import bb.model.Device;
import bb.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by bartosz on 07.07.16.
 */
@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>
{
    List<Person> findByName(@Param("name")String name);
    //Person findByName(@Param("name")String name);
    Person findByLogin(@Param("login")String login);

}
