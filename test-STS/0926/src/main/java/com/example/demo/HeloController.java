package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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
    * @date 	2019-10-09
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
    * @date 	2019-10-09
    *
    * @param 	RequestMapping ModelAndView mav
    *
    * @remark   insert페이지를 불러옴
    * 			name,mail,tel값들을 DB에 저장
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
		            @RequestParam("check") String check,
		            ModelAndView mov) 
    {
	   
    	 MyDataMongo mydata = new MyDataMongo(name,mail,tel,check);
         repository.save(mydata);
         return new ModelAndView("redirect:/");
	    
    }

    /**
	 *
	 * @fn 		public ModelAndView detail(ModelAndView mav)
	 * 
	 * @brief 	상세 조회 페이지
	 *
	 * @author 	권연준
	 * @date 	2019-10-24
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy 를 이용한 조건검색 후 출력	[2019-10-24; 권연준] \n
	 *
	 */
    
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}

}
