package bb.repository;

import bb.model.Card;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by bartosz on 08.07.16.
 */
@RepositoryRestResource(collectionResourceRel = "card", path = "card")
public interface CardRepository extends PagingAndSortingRepository<Card, Integer>
{
    List<Card> findByName(@Param("name") String name);
    //Card findByValue(@Param("value") String value);
    Card findById(@Param("id") int id);
}
