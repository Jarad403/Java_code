import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.AttributeInfo;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.MethodInfo;
import org.gjt.jclasslib.structures.attributes.CodeAttribute;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ModifyClassInfo {
    public static void main(String[] args) throws Exception {
        // 目标Class文件路径
        String filePath = "C:\\Users\\xxx\\Desktop\\Test\\Strike_Red.class";
        FileInputStream fis = new FileInputStream(filePath);
        DataInput di = new DataInputStream(fis);
        // 创建一个ClassFile文件以载入class文件数据
        ClassFile cf = new ClassFile();
        cf.read(di); // 载入类文件数据

        // 获取构造函数
        MethodInfo mi = cf.getMethod("<init>", "()V");
        // 方法的所有属性
        AttributeInfo[] attributes = mi.getAttributes();
        // 0号属性为Code
        CodeAttribute codeAttribute = (CodeAttribute) attributes[0];

        byte[] code = codeAttribute.getCode();  // 获取Code的二进制内容
        code[35] = 60;  // 修改35号索引内容
        codeAttribute.setCode(code);    // 重设方法的Code内容

        fis.close();
        // 保存修改后的ClassFile
        File f = new File("C:\\Users\\xxx\\Desktop\\Test\\Change\\Strike_Red.class");
        ClassFileWriter.writeToFile(f, cf);
    }
}
