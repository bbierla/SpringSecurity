package bb.repository;

import bb.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by bartosz on 08.07.16.
 */
@RepositoryRestResource(collectionResourceRel = "device", path = "device")
public interface DeviceRepository extends PagingAndSortingRepository<Device, Integer>
{
    //List<Device> findByName(@Param("name") String name);

    Device findByName(@Param("name") String name);


}
