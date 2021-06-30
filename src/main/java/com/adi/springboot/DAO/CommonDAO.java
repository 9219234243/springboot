package com.adi.springboot.DAO;

import java.util.List;
import java.util.Map;

public interface CommonDAO {

	void manyToMany();

	void oneToOne();

	void getoneToOne();

	void oneToMany();

	void getOneToMany();


	void getManyToMany();

	void query();

	List<Map> query(Integer deptId, Integer leadId);

}
