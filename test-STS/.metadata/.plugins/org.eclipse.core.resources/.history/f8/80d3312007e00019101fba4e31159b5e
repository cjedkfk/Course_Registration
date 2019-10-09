package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.repositories.MyDataMongoRepository;
import java.util.List;

@Controller
public class HeloController {
        
    @Autowired
    MyDataMongoRepository repository;
    
    /**
    *
    * @fn 		public ModelAndView index(ModelAndView mav) 
    * 
    * @brief 	저장된 정보를 볼 수 있는 페이지
    *
    * @author 	최지은
    * @date 	2019-06-19
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   index페이지를 불러옴
    * 			저장되어 있는 값을 모두 불러옴
    */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) 
    {
        mav.setViewName("index");
        mav.addObject("title","Find Page");
        mav.addObject("msg","MyDataMongo의 예제입니다.");
        Iterable<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
        
    /**
    *
    * @fn 		public ModelAndView insert(ModelAndView mav) 
    * 
    * @brief 	정보를 입력하는 페이지
    *
    * @author 	최지은
    * @date 	2019-06-19
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   insert페이지를 불러옴
    * 			area,name,address,tel값들을 DB에 저장
    */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert(ModelAndView mav) 
    {
        mav.setViewName("insert");
        return mav;
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView add(
		            @RequestParam("area") String area,
		            @RequestParam("name") String name,
		            @RequestParam("address") String address,
		            @RequestParam("tel") String tel,
		            ModelAndView mov) 
    {
	   
    	 MyDataMongo mydata = new MyDataMongo(area,name,address,tel);
         repository.save(mydata);
         return new ModelAndView("redirect:/");
	    
    }
    
    /**
    *
    * @fn 		public ModelAndView edit(ModelAndView mav) 
    * 
    * @brief 	저장된 정보 중 선택된 한가지의 정보를 호출하는 페이지
    *
    * @author 	최지은
    * @date 	2019-06-19
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   edit페이지를 불러옴
    * 			저장되어 있는 값을 id로 찾아와서 모든 정보를 불러옴
    */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView mav) 
    {
        mav.setViewName("edit");
        mav.addObject("title","eidt Page");
        mav.addObject("msg","MyData의 예제입니다.");
        List<MyDataMongo> list = repository.findAll();
        mav.addObject("list", list);
        return mav;
    }
    
    /**
    *
    * @fn 		public ModelAndView update(ModelAndView mav) 
    * 
    * @brief 	입력되어있는 정보를 수정하는 페이지
    *
    * @author 	최지은
    * @date 	2019-06-19
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   update페이지를 불러옴
    * 			저장되어 있는 값을 id로 찾아와서 모든 정보를 불러온 후 새롭게 입력되는 정보로 수정하여 저장함
    */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mav) 
    {
        mav.setViewName("update");
        mav.addObject("title","update Page");
        mav.addObject("msg","MyData의 예제입니다.");
        List<MyDataMongo> getlist = repository.findAll();
        mav.addObject("datalist", getlist);
        return mav;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(
	            @RequestParam("area") String area,
	            @RequestParam("name") String name,
	            @RequestParam("address") String address,
	            @RequestParam("tel") String tel,
	            ModelAndView mav) 
    {
 	   
   	 	MyDataMongo mydata = new MyDataMongo(area,name,address,tel);
        repository.save(mydata);
        return new ModelAndView("redirect:/edit{id}");
	    
   }

}
