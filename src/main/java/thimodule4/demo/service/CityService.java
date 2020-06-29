package thimodule4.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thimodule4.demo.model.City;

public interface CityService {
//    public Iterable<City> findAll();

    public Page<City> findAll(Pageable pageable);

    public City findById(int id);

    public void save(City city);

    public void delete(City city);
}