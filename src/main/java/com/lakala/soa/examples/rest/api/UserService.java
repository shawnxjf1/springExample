package com.lakala.soa.examples.rest.api;

import com.lakala.soa.examples.rest.vo.User;
/**
 * ClassName:UserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface UserService {
    User getUser(Long id);

    Long registerUser(User user);
}
