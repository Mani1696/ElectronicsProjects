package com.example.Electronics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AcDao {
	@Autowired
	AcRepo ar;
	String PostAll(List<Ac> a) {
		ar.saveAll(a);
		return "Successfuly saved";
	}	
	public List<Ac> getByBrand(String b) {
		return ar.getByBrand(b);
	}
	
	public List<Ac> getByPrice(int a) {
		return ar.getByPrice(a);
	}
	
	public List<Ac> getByPriceRange(int a,int b) {
		return ar.getByPriceRange(a,b);
		}
	
	public Ac getByMaxPrice() {
		return ar.getByMaxPrice();
	}
	

	public Ac getByMinPrice() {
		return ar.getByMinPrice();
	}
	
//	public List<Ac> getMinPrice() {
//		return ar.getByMinPrice();
//	}
	
	public Ac getByModel(String b)throws ModelNotFoundException {
		if(ar.getByModel(b).isEmpty()) {
			throw new ModelNotFoundException("This model is not available");
		}
		else {
			return ar.getByModel(b).get();
		}
		
	}
	
	public String post(Ac a) throws PriceNotFoundException{
			ar.save(a);
			return "Data saved";
		}
	public List<Ac> getByColor(String a) {
		return ar.getByColor(a);
	}
	
//	public String postObject(List<Ac> a) {
//		ar.save(a);
//		return "Data saved";
//	}
	
	public String posts(List<Ac> a) {
		ar.saveAll(a);
		return "Data Saved";
	}
	
	public List<Ac> getByBrands(String a,int b) throws BrandsNotFoundException {
		return ar.getByBrands(a,b);
	}
	
	
	
	
	
	}
	


