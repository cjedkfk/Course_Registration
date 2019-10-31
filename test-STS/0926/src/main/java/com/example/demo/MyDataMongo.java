package com.example.demo;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	
	private String id;
 	
	private String mail;
	private String name;
	private String tel;
	private String check;

	public MyDataMongo(String mail, String name, String tel,String check) 
	{
        super();
        this.mail = mail;
        this.name = name;
        this.tel = tel;
        this.check = check;
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
    
    public String getCheck() 
    {
        return check;
    }

    
}