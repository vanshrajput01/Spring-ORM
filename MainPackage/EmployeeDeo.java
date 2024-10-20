package com.SpringORM.Project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDeo {


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private HibernateTemplate hibernateTemplate;
 #################################################  create method to save object in database ##################################################################
  
	@Transactional
	public String insertData(Entity entity) {
		this.hibernateTemplate.save(entity);
		return "Data save successFully!!";

	}
	
	@Transactional
	public List<Integer> insertMultipleData(List<Entity> entities) {
		List<Integer> idList = new ArrayList<>();  
		entities.forEach(e->{
			this.hibernateTemplate.save(e);
			idList.add(e.getEmpId());
			
		});
		return idList;
		
	}

}
