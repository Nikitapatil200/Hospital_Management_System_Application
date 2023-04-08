package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.PersonDaoImpl;
import com.ty.hospital_app.dto.Person;

public class PersonService 
{
	public void savePerson(int bid,Person person)
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		Person person1=daoImpl.savePerson(bid, person);
		if(person1!=null)
		{
			System.out.println("Data Saved Successfullt");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Person getPersonById(int pid)
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		Person person1=daoImpl.getPersonById(pid);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public void deletePersonById(int pid)
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		boolean flag=daoImpl.deletePersonById(pid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed To Delete Data");
		}
	}
	public Person updatePersonById(int pid,Person person)
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		Person person1=daoImpl.updatePersonById(pid,person);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getAllPerson() 
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		List<Person> person1=daoImpl.getAllPerson();
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getPersonByGender(String gender)
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		List<Person> person1=daoImpl.getPersonByGender(gender);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getPersonByAge(int age) 
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		List<Person> person1=daoImpl.getPersonByAge(age);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getPersonByPhone(long phone) 
	{
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		List<Person> person1=daoImpl.getPersonByPhone(phone);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
}
