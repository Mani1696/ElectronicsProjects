package com.example.Electronics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcService {
	@Autowired
	AcDao ad;
	String PostAll(List<Ac> a) {
		return ad.PostAll(a);
	}
	public List<Ac> getByBrand(String b) {
		return ad.getByBrand(b);
	}
	
	public List<Ac> getByPrice(int a) {
		return ad.getByPrice(a);
	}
	
	public List<Ac> getByPriceRange(int a,int b) {
		return ad.getByPriceRange(a,b);
		}
	
	public Ac getByMaxPrice() {
		return ad.getByMaxPrice();
	}
	

	public Ac getByMinPrice() {
		return ad.getByMinPrice();
	}
	
//	public List<Ac> getMinPrice() {
//		return ad.getMinPrice();
//	}
	
	public Ac getByModel(String b) throws ModelNotFoundException {
		return ad.getByModel(b);
	}
	
	public String post(Ac a) throws PriceNotFoundException{
		try {
		if(a.getPrice()>50000) {
          throw new PriceNotFoundException("Above 500000");
		}
		else {
		return ad.post(a);
		}
		}
		catch(PriceNotFoundException b) {
			return "Wrong data";
		}
	}
	
	public List<Ac> getByColor(String  a) throws ColorNotFoundException {
		if(!ad.getByColor(a).equals(a)) {
			throw new ColorNotFoundException("Color not Available");
		}
		else {
			return ad.getByColor(a);
		}
	}
	
//	public String postObject(List<Ac> a) {
//	 if(ad.getByModelYear(a)>2020) {
//		 throw new ModelYearNotFoundException("Year out of range");
//	 }
//	 else {
//		 return ad.postObject(a);
//	 }
//	}
	
	public String posts(List<Ac> a) throws ModelYearNotFoundException {
		Ac g=new Ac();
			if(g.getModelYear()>2020) {
			return ad.posts(a);
			}
			else {
			 throw new ModelYearNotFoundException("Below 2020");
			}
	}
	
	public List<Ac> getByBrands(String a,int b) throws BrandsNotFoundException {
		List<Ac> ab=ad.getByBrands(a, b);
		if(ab.size()==0) {
			throw new BrandsNotFoundException("Brand and Price not match");
		}
		else {
			return ad.getByBrands(a,b);
		}
	}

}
