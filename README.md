# jaxbdemo

使用jaxb 
 * 序列化（marshal）是指从实体转成xml/节点的过程，而反序列化（unmarshal）反过来了，是xml/节点转成实体类的问题。
 * 工具类中常用的有三个方法—实体转node,实体转String类型xml，String类型xml转实体。
 * 大体上的思路都是从JAXBContext获取JAXBContext实例，然后通过这个实例获取序列化和反序列化实例。
