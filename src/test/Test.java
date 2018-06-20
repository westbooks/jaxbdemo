package test;

import utils.JAXBUtils;
import utils.XMLs;
import vo.StudentVO;

import java.io.File;

/**
 * @author 施晓峰
 * @create 2018-06-20 14:50
 * @desc
 **/

public class Test {

    public static void main(String[] args) {
//        StudentVO student = new StudentVO();
//        student.setAddress("江苏南通张芝山镇");
//        student.setName("袁胜男");
//        student.setAge(29);
//        String xml = JAXBUtils.modelToStringXML(student);
//        System.out.println("-------------------------------");
//        System.out.println(xml);


        File file = new File("D:\\workspaces\\jaxbdemo\\xml\\StudentVO.xml");
        StudentVO stu = (StudentVO) JAXBUtils.documentToModel(new StudentVO(), XMLs.getDocFromStringXml(file));
        System.out.println(stu.getAddress()+"  "+stu.getAge()+" "+stu.getName()) ;


    }
}
