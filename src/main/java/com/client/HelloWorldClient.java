/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import com.bean.ProcessInfo;
import com.bean.ResponseInfo;
import com.mycompany.app.novncserviceapi.HelloWorld;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost/ws/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://novncserviceapi.app.mycompany.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        List list = new ArrayList();
        list.add("notepad.exe");
        
        ProcessInfo info=new ProcessInfo();
        info.setId("notepaddProcess");
        info.setCommandList(list);
        
        ResponseInfo response=hello.runProcess(info);
        
        System.out.println(response.getMessage()+"    "+response.isError());
        

        //System.out.println(hello.getHelloWorldAsString("Abhishek"));
    }

}
