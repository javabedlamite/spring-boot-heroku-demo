/*
 * Copyright 2015 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heroku.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static boolean flag = false;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
    	System.out.println("java_bedlamite");
        return "home";
    }
    
    @RequestMapping(method = RequestMethod.GET,path = "index")
    public String index() throws InterruptedException {
    	System.out.println("index");
    	if(!flag){
    		flag = true;
    		String[] args = new String[]{ "l:10001", "l:10002"};
    		RTCP.rtcp(args); 
    	}
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.GET,path = "dsm")
    public String dsm() throws UnknownHostException {
    	System.out.println("dsm");
    	System.out.println("本机的IP = " + InetAddress.getLocalHost());
    	//return "redirect:http://192.168.1.184:5000";
        return "home";
    }

}
