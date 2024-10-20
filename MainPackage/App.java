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

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDeo employeeDeo = context.getBean("employeeDeo", EmployeeDeo.class);
		// create object of Entity class
		// to update data in table you have two step first get data and update it.
		// here you data form database
		Entity entity = employeeDeo.getHibernateTemplate().get(Entity.class, 2);
		entity.setEmpName("employee04");
		entity.setEmpSalary(12050);
		// here you update data
		System.out.println(employeeDeo.updateData(entity));

	    ######################################################################  delete data in database ################################################################
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDeo employeeDeo = context.getBean("employeeDeo", EmployeeDeo.class);
		// create object of Entity class
		// to delete data in table you have two step first get data and update it.
		// here you get data form database
		Entity entity = employeeDeo.getHibernateTemplate().get(Entity.class, 2);
		// here you delete data
		System.out.println(employeeDeo.deleteData(entity));

	}

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
###########################################################################  get data from data by id   ######################################################
		EmployeeDeo employeeDeo = context.getBean("employeeDeo", EmployeeDeo.class);
		String data = employeeDeo.getSingleRecord(3);
		System.out.print(data);



#####################################################    get all data in table   #######################################################################
		HashMap<Integer, List<String>> Alldata = employeeDeo.getMultipleRecord();
		System.out.print(Alldata);
		


        

        
    }
}
