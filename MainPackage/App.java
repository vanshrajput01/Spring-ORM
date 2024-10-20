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
        entity.setEmpId(103);
        entity.setEmpName("emp03");
        entity.setEmpSalary(14000);
        System.out.println(employeeDeo.insertData(entity));

        
    }
}
