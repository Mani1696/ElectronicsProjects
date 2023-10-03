package com.example.Electronics;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AcRepo extends JpaRepository<Ac,Integer> {
@Query(value="select * from actable where brand like ?",nativeQuery=true)
public List<Ac> getByBrand(String b);

@Query(value="select * from actable where price > ?",nativeQuery=true)
public List<Ac> getByPrice(int a);

@Query(value="select * from actable where price >? and price<?",nativeQuery=true)
public List<Ac>getByPriceRange(int a,int b);

@Query(value="select * from actable where price=(select max(price) from actable)",nativeQuery=true)
public Ac getByMaxPrice();

@Query(value="select * from actable where price=(select min(price) from actable)",nativeQuery=true)
public Ac getByMinPrice();

//@Query(value="select max(price) from actable ")

@Query(value="select * from actable where model like ?",nativeQuery=true)
public Optional<Ac> getByModel(String model);

//@Query(value="select * from actable Where ")

@Query(value="select * from actable where color like ?",nativeQuery=true)
public List<Ac> getByColor(String a);

@Query(value="select * from actable where brand like ? and price ?",nativeQuery=true)
public List<Ac> getByBrands(String a,int b);


}
