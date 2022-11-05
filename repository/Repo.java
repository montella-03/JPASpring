package com.montella.demo.repository;

import com.montella.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Repo extends JpaRepository<Students,Long> {
        List<Students> findByFirstName(String firstName);//you can look into spring data reference for more.
        List<Students> findByFirstNameContaining(String name);

        //JPQL
        @Query("select s from Students s where s.Email_id=?1")
        Students getStudentByEmail(String Email_id);

        //Native query....used in complex sql
        @Query(
                value = "SELECT * FROM students s where s.email_address=?1",
                nativeQuery = true
        )
        String getStudentByEmailNative(String email);

        @Query(
                value = "SELECT * FROM students s where s.email_address= :email",
                nativeQuery = true
        )
        String getStudentByEmailNativeNamedParams(@Param("email") String email);
        @Modifying
        @Transactional
        @Query(
                value = "update students set first_name=?1 where email_address=?2",
                nativeQuery = true
        )
        int updateStudentNameByEmail(String firstName, String Email);

}
