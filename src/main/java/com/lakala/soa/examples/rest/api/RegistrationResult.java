package com.lakala.soa.examples.rest.api;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/**
 * ClassName:RegistrationResult <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@XmlRootElement
public class RegistrationResult implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;

    public RegistrationResult() {
    }

    public RegistrationResult(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
