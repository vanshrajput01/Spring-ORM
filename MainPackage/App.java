package com.SpringORM.Project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDeo employeeDeo =  context.getBean("employeeDeo",EmployeeDeo.class);
        ############################################################### create object of Entity class  ##########################################################

        Entity entity = new Entity();
        entity.setEmpName("emp03");
        entity.setEmpSalary(14000);
        //                            save data
        System.out.println(employeeDeo.insertData(entity));


        ##########################################################  to multiple objects at time in database #############################################
         ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDeo employeeDeo =  context.getBean("employeeDeo",EmployeeDeo.class);
        // create object of Entity class
        Entity entity = new Entity();
        entity.setEmpName("emp04");
        entity.setEmpSalary(14000);
        
        Entity entity01 = new Entity();
        entity01.setEmpName("emp05");
        entity01.setEmpSalary(15000);
        
        Entity entity02 = new Entity();
        entity02.setEmpName("emp05");
        entity02.setEmpSalary(15000);
        
        List entitiesList = List.of(entity,entity01,entity02);
        
//                                     save multiple object
        System.out.println(employeeDeo.insertMultipleData(entitiesList) + "These ids data add in database..");


        ############################################################## how to update data in database #####################################################

    @Transactional
	public String updateData(Entity entity) {
		
		// to update data
		this.hibernateTemplate.update(entity);
		
		return "data update successFully!!";
	}


        

        
    }
}
