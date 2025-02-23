/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhm.service;

import com.mycompany.mavenprojectconnectdb.JdbcUtils;
import com.mysql.cj.xdevapi.Result;
import com.nhm.pojo.Category;
import com.nhm.pojo.Choice;
import com.nhm.pojo.Question;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {
    public List<Question> getQuestions (int num) throws SQLException{
        List<Question> questions = new ArrayList<Question>();
        try(Connection conn = JdbcUtils.getConn()){
            CallableStatement stm = conn.prepareCall(" { CALL get_questions(?) }");
        stm.setInt(1, num);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            Question q = new Question(rs.getString("id"),rs.getString("content"),rs.getInt("category_id"));
            questions.add(q);
        }
        return questions;
        }
        
    }
    public List<Choice> getChoices(String questionId) throws SQLException{
        List<Choice> choices = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            CallableStatement stm = conn.prepareCall("{ CALL get_choice(?) }");
            stm.setString(1, questionId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
             Choice c = new Choice(rs.getString("id"),rs.getString("content"),rs.getBoolean("is_correct"),rs.getString("question_id"));
             choices.add(c);
            }
            return choices;
        }
    }
    
     public List<Category> getCategories(String nameCategory) throws SQLException{
         List<Category> categories = new ArrayList<>();
          try(Connection conn = JdbcUtils.getConn()){
            CallableStatement stm = conn.prepareCall("{ CALL get_filter_question(?) }");
            stm.setString(1, nameCategory);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
             Category c = new Category(rs.getInt("id"),rs.getString("name"),rs.getInt("count"));
             categories.add(c);
            }
            return categories;
        }
     }
     
}
