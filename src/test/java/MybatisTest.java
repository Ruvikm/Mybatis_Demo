import com.DAO.IStudentDao;
import com.Entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Ruvik
 * @date 10/16/2020 8:44 PM
 * ```
 * ```
 * █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 * ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 * ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░     ░ ░      ░  ░
 **/
public class MybatisTest {


    private InputStream in;
    private SqlSession session;
    private IStudentDao studentDao;

    @Before //用于在测试方法之前运行
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SQL_Manager.xml");
        //2.创建SQL_Manager工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SQL_Manager对象
        session = factory.openSession();
        //4.使用SQL_Manager创建Dao接口的代理对象
        studentDao = session.getMapper(IStudentDao.class);
    }

    @After //用于在测试方法之后运行
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setUserName("Ruvikm");
        student.setSex("女");
        student.setBirthYear("2020-10-21");
        student.setGrade("2015-09-02");
        student.setCollegeID(2);
        //插入
        studentDao.AddStudent(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setUserID(10014);
        student.setUserName("Lord");
        //插入
        studentDao.UpdateStudent(student);
    }


    @Test
    public void testFindAll() {

        //5.使用代理对象的执行方法
        List<Student> students = studentDao.FindAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testDelete(){
        studentDao.DeleteStudent(10014);
    }

    @Test
    public void testFindById() {

        Student student= studentDao.CheckById(10001);
        System.out.println(student);
    }

    @Test
    public void testFindBySchool() {

        //5.使用代理对象的执行方法
        List<Student> students = studentDao.CheckBySchool(2);
        for (Student student : students) {
            System.out.println(student);
        }
    }

}