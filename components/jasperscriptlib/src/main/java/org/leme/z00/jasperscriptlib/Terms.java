package org.leme.z00.jasperscriptlib;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mendzl on 10/3/2016.
 */
public class Terms {

    private static TermsHolder termsHolder;

    private Terms(){
    }

    public static TermsHolder getTerms(){
        if(termsHolder == null){
            System.out.println("#create termHolder");
            termsHolder = new TermsHolder();
        }else{
            System.out.println("#from existing termHolder");
        }
        return termsHolder;
    }

    public static class TermsHolder{

        private Map<String, Map<String,String>> orgs;

        private TermsHolder() {
            orgs = new HashMap<>();
        }

        public String getTerm(String term, Integer facId){
            return "Test";
        }
    }

}
