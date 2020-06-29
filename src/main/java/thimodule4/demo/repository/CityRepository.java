package thimodule4.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import thimodule4.demo.model.City;

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {
    public City findById(int id);
}