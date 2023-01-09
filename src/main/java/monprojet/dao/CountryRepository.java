package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

import monprojet.dto.populationPays;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value= " SELECT SUM(population)"
            + " FROM city"
            +" WHERE country_id = :paysId", nativeQuery = true)
    public Integer populationPourPays(Integer paysId);
    @Query(value ="SELECT co.name as name, sum(ci.population) as population" +
            " FROM country co INNER JOIN city ci" +
             " ON(co.id= ci.country_id)"+
                " GROUP BY co.name", nativeQuery = true)
    public List<populationPays> populationParPays();
}
