package com.example.demo;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	
	private String id;
 	
	private String mail;
	private String name;
	private String tel;
	
	public MyDataMongo(String mail, String name, String tel) 
	{
        super();
        this.mail = mail;
        this.name = name;
        this.tel = tel;
	}
   
    public String getId() 
    {
        return id;
    }
    public String getMail() 
    {
        return mail;
    }
    public String getName() 
    {
        return name;
    }

    public String getTel() 
    {
        return tel;
    }

    
}