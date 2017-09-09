package com.flybeifeng.dao;

import com.flybeifeng.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public interface StudentDao {

   /* public List<Student> findAll() {
        List<Student> all = new ArrayList<Student>();
        all.add(new Student(1, "tom", 18, true));
        all.add(new Student(2, "cat", 28, true));
        all.add(new Student(3, "lxk", 18, true));
        all.add(new Student(4, "cms", 18, true));
        return all;
    }*/

    @Select("select * from student where id=#{id} limit 1")
    Student getOneUser(int id);

    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into student value (#{id},#{name},#{age},#{sex});")
    void addOneUser(@Param("id") int id,
                    @Param("name") String name,
                    @Param("age") int age,
                    @Param("sex") boolean sex);

    @Update("UPDATE student SET age = #{age} WHERE id = #{id};")
    void updateUserById(@Param("id") int id,
                        @Param("age") int age);

    @Delete("delete from student where id=#{id};")
    void deleteUserById(int id);
}
