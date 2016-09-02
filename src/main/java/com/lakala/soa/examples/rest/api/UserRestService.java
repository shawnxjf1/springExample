package com.lakala.soa.examples.rest.api;

import javax.validation.constraints.Min;

import com.lakala.soa.examples.rest.vo.User;
/**
 * ClassName:UserRestService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface UserRestService {

    /**
     * the request object is just used to test jax-rs injection.
     */
    User getUser(@Min(value=1L, message="User ID must be greater than 1") Long id/*, HttpServletRequest request*/);

    RegistrationResult registerUser(User user);
}
