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

##################################################### create method to save multiple object at one time in database #######################################


	
	@Transactional
	public List<Integer> insertMultipleData(List<Entity> entities) {
		List<Integer> idList = new ArrayList<>();  
		entities.forEach(e->{
			this.hibernateTemplate.save(e);
			idList.add(e.getEmpId());
			
		});
		return idList;
		
	}

######################################################################  update data in database ################################################################

	@Transactional
	public String updateData(Entity entity) {
		this.hibernateTemplate.update(entity);
		return "data update successFully!!";
	}

######################################################################  delete data in database ################################################################
	@Transactional
	public String deleteData(Entity entity) {
		
		// to update data
		this.hibernateTemplate.delete(entity);
		
		return "data delete successFully!!";
	}
	
	######################################################################  get Single data ion database ################################################################

	public String getSingleRecord(Integer id) {
		
		
		Entity entity = this.hibernateTemplate.get(Entity.class, id);
		
		return entity.getEmpName() + " " + entity.getEmpSalary();
	}

	######################################################################  get all data in database ################################################################

	public HashMap<Integer, List<String>> getMultipleRecord(Integer id) {
	
			HashMap<Integer, List<String>> tableadata = new HashMap<>();
		List<Entity> entitiesList = this.hibernateTemplate.loadAll(Entity.class);
		entitiesList.forEach(e->{
			List<String> StringList = new ArrayList<>();
			StringList.add(e.getEmpName());
			StringList.add(e.getEmpSalary().toString());
			tableadata.put(e.getEmpId(),StringList);
			
		});
		
		return tableadata;
	}


}
