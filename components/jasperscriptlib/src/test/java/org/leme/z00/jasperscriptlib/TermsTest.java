package org.leme.z00.jasperscriptlib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mendzl on 10/3/2016.
 */
public class TermsTest {


    @Test
    public void name() throws Exception {
        System.out.println(Terms.getTerms().getTerm("",1));
    }
}