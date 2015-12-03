/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.novncserviceapi;

import com.bean.ProcessInfo;
import com.bean.ResponseInfo;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld{
 
	@WebMethod 
        String getHelloWorldAsString(String name);
        
        @WebMethod 
        ResponseInfo runProcess(ProcessInfo info);
        
        @WebMethod 
        ResponseInfo stopProcess(String processId);

}