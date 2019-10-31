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
    * @brief 	���옣�맂 �젙蹂대�� 蹂� �닔 �엳�뒗 �럹�씠吏�
    *
    * @author 	理쒖���
    * @date 	2019-10-09
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   index�럹�씠吏�瑜� 遺덈윭�샂
    * 			���옣�릺�뼱 �엳�뒗 媛믪쓣 紐⑤몢 遺덈윭�샂
    */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) 
    {
        mav.setViewName("index");
        mav.addObject("title","Find Page");
        mav.addObject("msg","MyDataMongo�쓽 �삁�젣�엯�땲�떎.");
        Iterable<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
        
    /**
    *
    * @fn 		public ModelAndView insert(ModelAndView mav) 
    * 
    * @brief 	�젙蹂대�� �엯�젰�븯�뒗 �럹�씠吏�
    *
    * @author 	理쒖���
    * @date 	2019-10-09
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   insert�럹�씠吏�瑜� 遺덈윭�샂
    * 			name,mail,tel媛믩뱾�쓣 DB�뿉 ���옣
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
		            @RequestParam("name") String name,
		            @RequestParam("mail") String mail,
		            @RequestParam("tel") String tel,
		            ModelAndView mov) 
    {
	   
    	 MyDataMongo mydata = new MyDataMongo(name,mail,tel);
         repository.save(mydata);
         return new ModelAndView("redirect:/");
	    
    }
    
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}

}
