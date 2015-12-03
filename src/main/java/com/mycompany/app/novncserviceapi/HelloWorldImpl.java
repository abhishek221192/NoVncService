/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.novncserviceapi;

import com.bean.ProcessInfo;
import com.bean.ResponseInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.app.novncserviceapi.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    private static Map<String, Process> processStore = new HashMap<String, Process>();

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }

    @Override
    public ResponseInfo runProcess(ProcessInfo info) {
        try {
            ProcessBuilder builder = new ProcessBuilder(info.getCommandList());
            Map<String, String> environ = builder.environment();
            Process process = builder.start();
            
            processStore.put(info.getId(), process);
            
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Program terminated!");

            return new ResponseInfo("Sucsess", true);

        } catch (IOException ex) {
            Logger.getLogger(HelloWorldImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseInfo("Fail", false);
    }

    @Override
    public ResponseInfo stopProcess(String id) {
        Process process = processStore.get(id);
        if (process != null) {
            process.destroy();
            return new ResponseInfo("Sucsess", true);
        }
        return new ResponseInfo("Process is "+process+"  processStore "+processStore, false);
    }

}
