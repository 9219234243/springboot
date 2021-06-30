package com.adi.springboot.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adi.springboot.model.AadharDetail;
import com.adi.springboot.model.Citizen;
import com.adi.springboot.model.MobileNo;
import com.adi.springboot.model.Person;
import com.adi.springboot.model.Student;
import com.adi.springboot.model.Subject;



@Repository
@Transactional
public class CommonDAOImpl implements CommonDAO {
	@Autowired
	private EntityManager sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.unwrap(Session.class);
	}

	public void oneToOne() {
		try {
			Session s=getCurrentSession();
			Citizen ct=new Citizen();
			ct.setName("Aditya");
			AadharDetail ad=new AadharDetail();
			ad.setUid("10101");
			ct.setAdharDetail(ad);
			s.save(ct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getoneToOne() {
		System.out.println("getoneToOne");
		try {
			Session s=getCurrentSession();
			Citizen ct=(Citizen)s.load(Citizen.class, 1);
			System.out.println(ct.getName());
			System.out.println(ct.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void oneToMany() {
		try {
			Session s=getCurrentSession();
			Person p=new Person();
			p.setName("Aditya");
			
			MobileNo m=new MobileNo();
			m.setMobNo("9971944577");
			
			MobileNo m1=new MobileNo();
			m1.setMobNo("9219234243");
			
			m.setPerson(p);
			m1.setPerson(p);
			
			List<MobileNo> mobList=new ArrayList<>();
			mobList.add(m);
			mobList.add(m1);
			
			p.setMobileNo(mobList);
			
			s.save(p);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void getOneToMany() {
		System.out.println("getOneToMany");
		try {
			Session s=getCurrentSession();
			Person p=s.load(Person.class, 1);
			//System.out.println(p.getName());
			
			//System.out.println(p.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	
	@Override
	public void manyToMany() {
		System.out.println("***** Many TO Many ******");
		try {
			Session s = getCurrentSession();
			Student st = new Student();
			st.setName("Aditya");

			Student st1 = new Student();
			st1.setName("Deepali");

			Subject sb = new Subject();
			sb.setSubject("Java");

			Subject sb1 = new Subject();
			sb1.setSubject("Python");

			List<Subject> sbList = new ArrayList<>();
			sbList.add(sb);
			sbList.add(sb1);

			st.setSubject(sbList);
			st1.setSubject(sbList);

			List<Student> stList = new ArrayList<>();
			stList.add(st);
			stList.add(st1);
			
			sb.setStudent(stList);
			sb1.setStudent(stList);

			s.save(st);
			s.save(st1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getManyToMany() {
		try {
			System.out.println("getManyToMany");
			Session s=getCurrentSession();
			Student st=s.load(Student.class, 1);
			System.out.println(st.getName());
			System.out.println(st.getSubject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void query() {}
	
	public List<Map> query(Integer deptId, Integer leadId) {
		List<Map> data=new ArrayList<>();
		try {
			Session session=getCurrentSession();
			String q1="CALL getDcoLeadNextStatusBySubSeq("+deptId+","+leadId+")";
			List<Map> data1=session.createSQLQuery(q1).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
			System.out.println("data1 :: "+data1);
			if(!data1.isEmpty()) {
				data=data1;
			}else {
				System.out.println("******* Else ******8");
				String q2="CALL getDcoLeadNextStatus("+deptId+","+leadId+")";
				List<Map> data2=session.createSQLQuery(q2).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
				System.out.println("data2 :: "+data2);
				data=data2;
			}
			
			System.out.println("DATA ::  "+data); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}

}
