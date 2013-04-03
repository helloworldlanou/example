package factory;

import org.dom4j.*;
import org.dom4j.io.*;

import util.constants.ConstantsUtil;

import java.util.*;
import java.io.*;


public class DaoFactory
{
    private Map<String , Object> daoMap = new HashMap<String , Object>(); 

    private static DaoFactory df;

    private DaoFactory()throws Exception
    {
		//System.out.println("abcdefghijkl");
		
        Document doc = new SAXReader().read(new File(ConstantsUtil.realPath + "//daoContext.xml"));
        Element root = doc.getRootElement();
        List el =  root.elements();
        for (Iterator it = el.iterator();it.hasNext() ; )
        {
            Element em = (Element)it.next();
            String id = em.attributeValue("id");
            String impl = em.attributeValue("class");
            Class implClazz = Class.forName(impl);
            Object d = implClazz.newInstance();
            daoMap.put(id , d);            
        }
    }

    public static DaoFactory instance()throws Exception
    {
        if (df == null)
        {
            df = new DaoFactory(); 
        }
        return df;
    }

    public Object getDao(String id)
    {
        return daoMap.get(id);
    }
}
