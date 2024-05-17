//package com.krontech.unicorn.customer.services.customers;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.json.JacksonJsonParser;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class CustomerService2 {
//
//    @Value("${spring.datasource.url}")
//    private String jdbcUrl;
//
//    @Value("${spring.datasource.username}")
//    private String jdbcUsername;
//
//    @Value("${spring.datasource.password}")
//    private String jdbcPassword;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String jdbcDriver;
//
//    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
//    public ResponseEntity<String> add(@RequestBody String requestBody) {
//        System.out.println("Incoming request");
//        try {
//            Map<String, Object> customerMap = new JacksonJsonParser().parseMap(requestBody);
//
//            String username = (String) customerMap.get("username");
//            String name = (String) customerMap.get("name");
//            String surname = (String) customerMap.get("surname");
//            String email = (String) customerMap.get("email");
//            List<String> tags = (List<String>) customerMap.get("tags");
//
//            List<Long> tagIdList = new ArrayList<>();
//            for (String tag : tags) {
//
//                Class.forName(jdbcDriver);
//                Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("select id from tag where name = '" + tag + "'");
//                if (rs.next()) {
//                    tagIdList.add(rs.getLong(1));
//                } else {
//                    throw new IllegalArgumentException("Undefined tag: " + tag);
//                }
//                con.close();
//            }
//
//            Class.forName(jdbcDriver);
//            Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from customer where username = '" + username + "'");
//            if (rs.next()) {
//                throw new IllegalArgumentException("Username already exists: " + username);
//            }
//            con.close();
//
//            Class.forName(jdbcDriver);
//            con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from customer where email = '" + email + "'");
//            if (rs.next()) {
//                throw new IllegalArgumentException("Email already exists: " + email);
//            }
//            con.close();
//
//            if (username == null || username.trim().isEmpty()) {
//                throw new IllegalArgumentException("Missing username");
//            }
//            if (name == null || name.trim().isEmpty()) {
//                throw new IllegalArgumentException("Missing name");
//            }
//            if (surname == null || surname.trim().isEmpty()) {
//                throw new IllegalArgumentException("Missing surname");
//            }
//            if (email == null || email.trim().isEmpty()) {
//                throw new IllegalArgumentException("Missing email");
//            }
//            if (tags == null || tags.isEmpty()) {
//                throw new IllegalArgumentException("Missing tags");
//            }
//
//            Class.forName(jdbcDriver);
//            con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//            stmt = con.createStatement();
//            stmt.executeUpdate("insert into customer (username, name, surname, email) values ('" + username + "', '" + name + "', '" + surname + "', '" + email + "')");
//            con.close();
//
//            Class.forName(jdbcDriver);
//            con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select id from customer where username = '" + username + "'");
//            Long customerId;
//            if (rs.next()) {
//                customerId = rs.getLong(1);
//            } else {
//                throw new IllegalArgumentException("Username not found: " + username);
//            }
//            con.close();
//
//            for (Long tagId : tagIdList) {
//                Class.forName(jdbcDriver);
//                con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//                stmt = con.createStatement();
//                stmt.executeUpdate("insert into customer_tags (customer_id, tag_id) values (" + customerId + ", " + tagId + ")");
//            }
//            con.close();
//            System.out.println("Customer saved successfully: " + username);
//        } catch (IllegalArgumentException e) {
//            System.err.println(e);
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            System.err.println(e);
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>("Customer saved successfully", HttpStatus.OK);
//    }
//}