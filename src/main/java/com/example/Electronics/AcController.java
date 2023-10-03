package com.example.Electronics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcController {
	@Autowired
	AcService as;
	@PostMapping(value="/postAll")
	String PostAll(@RequestBody List<Ac> a) {
		return as.PostAll(a);
	}
	@GetMapping(value="getByBrand/{b}")
	public List<Ac> getByBrand(@PathVariable String b) {
//		String brand=b.toLowerCase();
		return as.getByBrand(b);
	}
	@GetMapping(value="getByPrice/{a}")
	public List<Ac> getByPrice(@PathVariable int a) {
		return as.getByPrice(a);
	}
	
	@GetMapping(value="getByPriceRange/{a}/{b}")
	public List<Ac> getByPriceRange(@PathVariable int a, @PathVariable int b) {
		return as.getByPriceRange(a,b);
	}
	
	@GetMapping(value="getByMaxPrice")
	public Ac getByMaxPrice() {
		return as.getByMaxPrice();
	}
	
	@GetMapping(value="getByMinPrice")
	public Ac getByMinPrice() {
		return as.getByMinPrice();
	}
	
//	@GetMapping(value="getMinPrice")
//	public List<Ac> getMinPrice() {
//		return as.getMinPrice();
//	}
	
	@GetMapping(value="getByModel/{b}") 
	public Ac getByModel(@PathVariable String b) throws ModelNotFoundException {
		return as.getByModel(b);
	}
	
	@PostMapping(value="postNewAc")
	public String postvalues(@RequestBody Ac a) throws PriceNotFoundException {
		return as.post(a);
	}
	
	@GetMapping(value="/getByColor/{a}")
	public List<Ac> getByColor(@PathVariable String a) throws ColorNotFoundException {
		return as.getByColor(a);
	}
	
//	@PostMapping(value="postObject")
//	public String postObject(List<Ac> a) {
//		return as.post(a);
//	}
	
	@PostMapping(value="/postNewBrand")
	public String posts(@RequestBody List<Ac> a) throws ModelYearNotFoundException {
		return as.posts(a);
	}
	
	@GetMapping(value="getByBrands/{a}/{b}")
	public List<Ac> getByBrands(@PathVariable String a,@PathVariable int b) throws BrandsNotFoundException {
		return as.getByBrands(a,b);
	}

}
