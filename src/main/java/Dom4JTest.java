import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Dom4JTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        DomTest.parseXml(new File(Dom4JTest.class.getResource("test.xml").getFile()));

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(Dom4JTest.class.getResource("test.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            Iterator it=bookStore.elementIterator();
            while (it.hasNext()){
                System.out.println("=====开始遍历某一本书=====");
                Element book = (Element) it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> attributes=book.attributes();
                for (Attribute attr:attributes){

                    System.out.println("属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                }
                System.out.println("=====结束遍历某一本书=====");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
