/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenprojectconnectdb;

import com.nhm.pojo.Category;
import com.nhm.pojo.Choice;
import com.nhm.pojo.Question;
import com.nhm.service.QuestionService;
import com.nhm.service.StateService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MavenProjectConnectDb {

    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Hello World!");
//        QuestionService s = new QuestionService();
//        List<Question> questions = s.getQuestions(2);
//        questions.forEach(q -> {
//            try {
//                List<Choice> choices = s.getChoices(q.getId());
//                System.out.println(q);
//                for (int i = 0; i < choices.size(); i++) {
//                    System.out.printf("%d. %s\n", i + 1, choices.get(i));
//                }
//                System.out.println("Your Answer :");
//                int choice = Integer.parseInt(sc.next());
////                int ans = sc.nextByte();
//                if (choices.get(choice - 1).isCorrect()) {
//                    System.out.println("Correct!");
//                } else {
//                    System.out.println("Wrong!!");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(MavenProjectConnectDb.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        Scanner sc = new Scanner(System.in);
        QuestionService s = new QuestionService();
        List<Category> categories = s.getCategories("");
        categories.forEach(c->System.out.println(c));
//        HashMap<String,Integer> question = new HashMap<String,Integer>();

        StateService ss = new StateService();
        int count = ss.countQuestionLessFourChoice();
        System.out.printf("Count :%d",count);
    }
}
