package com.adi.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adi.springboot.DAO.CommonDAO;
import com.adi.springboot.model.ModelForValidation;
import com.adi.springboot.model.Response;




@RestController
@CrossOrigin
@RequestMapping("/common")
public class CommonController {
	
	
	@Autowired
	private CommonDAO commonDao;
	
		@GetMapping("/embeded")
		public void embeded() {
		String s = null;
		s.toString();
		}

	
	  @GetMapping("/oneToOne")
	  public void oneToOne() {
		  commonDao.oneToOne(); 
	}
	  
	  @GetMapping("/getoneToOne")
	  public void getoneToOne() 
	  {
	  commonDao.getoneToOne(); 
	  }
	  
	  @GetMapping("/oneToMany") 
	  public void oneToMany() {
		  commonDao.oneToMany(); 
	  }
	  
	 /* @GetMapping("/loadOneToOne") public void loadOneToOne() {
	 * commonDao.loadOneToOne(); }
	 */ 
	  @GetMapping("/getOneToMany")
	  public void getOneToMany() 
	  {
		  commonDao.getOneToMany(); 
	  }
	  
	  @GetMapping("/getManyToMany")
	  public void getManyToMany() {
		  	commonDao.getManyToMany(); 
	  }
	 
	 /* @GetMapping("/joinQuery") public void joinQuery() { commonDao.joinQuery(); }
	 * 
	 * @GetMapping("/criteriaSearch") public void criteriaSearch() {
	 * commonDao.criteriaSearch(); }
	 */

	@GetMapping("/manyToMany")
	public void manyToMany() {
		//System.out.println("manyToMany Controller");
		commonDao.manyToMany();
	}

	@GetMapping("/query")
	public List<Map> query(@RequestParam Integer deptId,@RequestParam Integer leadId) {
		System.out.println("Dept Id ::  "+deptId+" :: lead Id ==>  "+leadId );
		 try {
			 List<Map> data=commonDao.query(deptId,leadId);
			 return data;
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return null;
	}

	/*
	 * @RequestMapping(value = "/xmlRes", method = RequestMethod.GET, produces = {
	 * "application/json", "application/xml" }) public XmlRes xmlRes() {
	 * System.out.println("**********  xmlRes ************"); XmlRes xr = new
	 * XmlRes(); xr.setName("emp1"); // emp.setDesignation("manager"); xr.setId(1);
	 * // emp.setSalary(3000); return xr; }
	 */
	
	@PostMapping("validation")
	public Response ModelForValidation(@Valid @RequestBody  ModelForValidation modelForValidation) {
		Response res=new Response();
		System.out.println("********  ModelForValidation************");
		  try { 
			  String s=null; 
			  s.toString();
		  } catch (Exception e) { 
		   throw new NullPointerException(); 
		   }
		 //throw new NullPointerException();
		  System.out.println("********  ModelForValidation After ************");
		return res;
	}
	
	@PostMapping("validationEx")
	//public ResponseEntity<String> validationEx(@Valid @RequestBody  ModelForValidation modelForValidation) {
	public Response validationEx(@Valid @RequestBody  ModelForValidation modelForValidation) {
		Response res=new Response();
		System.out.println("modelForValidation ::  "+modelForValidation);
		return res;
	}
	
	@GetMapping("criteria")
	public void criteria() {
		commonDao.criteria();
	}
	
	@GetMapping("joinQuery")
	public void joinQuery() {
		commonDao.joinQuery();
	}

}
