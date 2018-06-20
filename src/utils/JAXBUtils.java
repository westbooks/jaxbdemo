package utils;

import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;

/**
 * @author 施晓峰
 * @create 2018-06-20 14:44
 * @desc
 * 工具类 JAXBUtils。
 * 序列化（marshal）是指从实体转成xml/节点的过程，而反序列化（unmarshal）反过来了，是xml/节点转成实体类的问题。
 * 工具类中常用的有三个方法—实体转node,实体转String类型xml，String类型xml转实体。
 * 大体上的思路都是从JAXBContext获取JAXBContext实例，然后通过这个实例获取序列化和反序列化实例。
 **/
public class JAXBUtils {

    /**
     * 获取JAXBContext实例。
     * @return
     */
    @SuppressWarnings("unused")
    private static final JAXBContext getJAXBContext(Class<?> c){
        JAXBContext jaxbContext=null;
        try {
            jaxbContext = JAXBContext.newInstance(c);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return jaxbContext;
    }


    /**
     * 将报文节点反序列化为实体类
     * @param obj
     * @param node
     * @return
     */
    public static final Object documentToModel(Object obj,Node node){
        if(node == null){
            return null;
        }
        JAXBContext jaxbContext = getJAXBContext(obj.getClass());
        try {
            //得到反序列化实例Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            obj= unmarshaller.unmarshal(node);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 将实体类转序列化为对应String类型xml节点
     * @param obj
     * @return
     */
    public static final String modelToStringXML(Object obj){
        StringWriter writer= new StringWriter();
        JAXBContext jaxbContext = getJAXBContext(obj.getClass());
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            //设置序列化的编码格式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //设置格式化输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();

    }



    /**
     * 将实体类转序列化为对应node节点
     * @param obj   实体类
     * @param node  创建的新节点
     * @return
     */
    public static final Node modelToNode(Object obj,Node node){
        JAXBContext jaxbContext = getJAXBContext(obj.getClass());
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, node);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return node;

    }
}
