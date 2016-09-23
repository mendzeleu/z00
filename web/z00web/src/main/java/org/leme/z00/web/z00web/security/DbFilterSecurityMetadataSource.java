package org.leme.z00.web.z00web.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mendzl on 9/20/2016.
 */
public class DbFilterSecurityMetadataSource  implements FilterInvocationSecurityMetadataSource {

    @SuppressWarnings("ConstantConditions")
    public List<ConfigAttribute> getAttributes(Object object) {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        String httpMethod = fi.getRequest().getMethod();
        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        attributes.add(ca);
        // Lookup your database (or other source) using this information and populate the
        // list of attributes

        return attributes;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
