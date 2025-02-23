/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhm.service;

import com.mycompany.mavenprojectconnectdb.JdbcUtils;
import com.nhm.pojo.Choice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class StateService {
    public int countQuestionLessFourChoice () throws SQLException{
        int count =0;
        try (Connection conn = JdbcUtils.getConn()){
            CallableStatement stm = conn.prepareCall("{ CALL count_question_less_4_ans() }");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                count = rs.getInt("count");
            }
            return count;
        }
    }
}
