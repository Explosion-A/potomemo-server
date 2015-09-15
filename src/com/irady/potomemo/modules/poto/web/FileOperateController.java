package com.irady.potomemo.modules.poto.web;  
  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.ServletRequestUtils;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  

import com.irady.potomemo.common.utils.FileOperateUtil;
  
  
@Controller  
@RequestMapping(value = "modules/poto/fileOperate")  
public class FileOperateController {  
    /** 
     * 到上传文件的位置 
     *  
    
     * @return 
     */  
    @RequestMapping(value = "to_upload")  
    public ModelAndView toUpload() {  
        return new ModelAndView("modules/poto/upload");  
    }
  
    /** 
     * 上传文件 
     *  
   
     * @param request 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping(value = "upload")  
    public ModelAndView upload(HttpServletRequest request) throws Exception {
  
        Map<String, Object> map = new HashMap<String, Object>();  
  
        // 别名  
        String[] alaises = ServletRequestUtils.getStringParameters(request,  
                "alais");  
  
        String[] params = new String[] { "alais" };  
        Map<String, Object[]> values = new HashMap<String, Object[]>();  
        values.put("alais", alaises);  
  
        List<Map<String, Object>> result = FileOperateUtil.upload(request,  
                params, values);  
  
        map.put("result", result);  
  
        return new ModelAndView("modules/poto/list", map);  
    }  
  
    /** 
  
     * @param attachment 
     * @param request 
     * @param response 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping(value = "download")  
    public ModelAndView download(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
  
        String storeName = "201205051340364510870879724.zip";  
        String realName = "Java设计模式.zip";  
        String contentType = "application/octet-stream";  
  
        FileOperateUtil.download(request, response, storeName, contentType,  
                realName);  
  
        return null;  
    }  
}  