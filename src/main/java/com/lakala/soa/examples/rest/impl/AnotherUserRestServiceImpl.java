package com.lakala.soa.examples.rest.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lakala.soa.examples.rest.api.AnotherUserRestService;
import com.lakala.soa.examples.rest.api.RegistrationResult;
import com.lakala.soa.examples.rest.api.UserService;
import com.lakala.soa.examples.rest.vo.User;
/**
 * ClassName:AnotherUserRestServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class AnotherUserRestServiceImpl implements AnotherUserRestService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser(Long id) {
        System.out.println("Client name is " + RpcContext.getContext().getAttachment("clientName"));
        System.out.println("Client impl is " + RpcContext.getContext().getAttachment("clientImpl"));
        return userService.getUser(id);
    }

    public RegistrationResult registerUser(User user) {
        return new RegistrationResult(userService.registerUser(user));
    }
}
