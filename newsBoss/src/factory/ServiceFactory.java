package factory;


import org.dom4j.*;
import org.dom4j.io.*;
import util.constants.ConstantsUtil;
import java.util.*;
import java.io.*;


public class ServiceFactory
{
    private Map<String , Object> serviceMap = new HashMap<String , Object>(); 

    private static ServiceFactory sf;

    private ServiceFactory()throws Exception
    {
        Document doc = new SAXReader().read(new File(ConstantsUtil.realPath + "//serviceContext.xml"));
        Element root = doc.getRootElement();
        List el =  root.elements();
        for (Iterator it = el.iterator();it.hasNext() ; )
        {
            Element em = (Element)it.next();
            String id = em.attributeValue("id");
            String impl = em.attributeValue("class");
            Class implClazz = Class.forName(impl);
            Object d = implClazz.newInstance();
            serviceMap.put(id , d);            
        }
    }

    public static ServiceFactory instance()throws Exception
    {
        if (sf == null)
        {
            sf = new ServiceFactory(); 
        }
        return sf;
    }

    public Object getService(String id)
    {
        return serviceMap.get(id);
    }
}
