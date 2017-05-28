package org.leme.z00.jasperscriptlib;

import org.apache.commons.collections.iterators.IteratorEnumeration;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by mendzl on 9/27/2016.
 */
public class DynamicResourceBundle extends ResourceBundle {

    Map<String, String> dictionary;

    public DynamicResourceBundle() {
        dictionary = new HashMap<>();
        dictionary.put("acct_trm", "(D) Account");
        dictionary.put("fn_trm", "(D) First Name");
        dictionary.put("fn_trm_prfx", "(D) FN: ");
        dictionary.put("urid_trm", "(D) User Role Id");
        dictionary.put("rid_trm", "(D) Role Id");
        dictionary.put("uid_trm", "(D) User Id");
        dictionary.put("un_trm", "(D) User Name");
        dictionary.put("ln_trm", "(D) Last Name");
        dictionary.put("eml_trm", "(D) Email");
        dictionary.put("role_trm", "(D) Role");
        dictionary.put("datetime.format", "yy/mm/dd HH:mm:ss");
        dictionary.put("date.format", "yy/mm/dd");
        dictionary.put("time.format","HH:mm:ss");
        dictionary.put("calendar.datetime.format", "yy/mm/dd HH:mm:ss");
        dictionary.put("calendar.date.format", "yy/mm/dd");
        dictionary.put("calendar.time.format", "HH:mm:ss");
    }

    @Override
    protected Object handleGetObject(String key) {
        String translation = dictionary.get(key);
        if (translation == null || translation.trim().length()==0) {
            return key;
        }
        return translation;
    }

    @Override
    public Enumeration<String> getKeys() {
        return new IteratorEnumeration(dictionary.keySet().iterator());
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }
}
