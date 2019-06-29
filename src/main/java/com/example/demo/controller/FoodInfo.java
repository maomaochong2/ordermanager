//package com.example.demo.controller;
//
//import com.example.demo.entity.FoodTypeInfo;
//import com.example.demo.service.FoodInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/")
//public class FoodInfo {
//    @Autowired
//    private FoodInfoService foodInfoService;
//    //首页
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
//    //菜品信息管理页面
//    @RequestMapping("/foodinfo")
//    public String foodinfo(){
//
//        return "foodinfo";
//    }
//
//    //查找food列表
//    @GetMapping("/findlist")
//    @ResponseBody
//    public List<FoodTypeInfo> findlist(){
//        List<FoodTypeInfo> list=foodInfoService.findlist();
////        System.out.println(list);
//        return list;
//    }
//    //添加页面
//    @RequestMapping("/toaddfood")
//    public String toaddfood(){
//
//        return "toaddfood";
//    }
//    //添加功能
//    @PostMapping("/addfood")
//    @ResponseBody
//    public int addfood(@Valid FoodTypeInfo foodTypeInfo){
//
//        return foodInfoService.add(foodTypeInfo);
//    }
//    //删除功能
//    @GetMapping("/deletefood/{foodid}")
//    @ResponseBody
//    public List<FoodTypeInfo> deletefood(@PathVariable("foodid") Integer foodid){
//        foodInfoService.deletefood(foodid);
//        return foodInfoService.findlist();
//    }
//    //跳转修改页面
//    @RequestMapping("/toupdatefood")
//    public String toupdatefood(Integer foodid){
//        return "toupdatefood";
//    }
//    @GetMapping("/findById/{foodid}")
//    @ResponseBody
//    public FoodTypeInfo findById(@PathVariable("foodid") Integer foodid){
//        FoodTypeInfo foodTypeInfo =foodInfoService.findById(foodid);
//        System.out.println(foodTypeInfo);
//        return foodTypeInfo;
//    }
//    //修改功能
//    @PutMapping("/updatefood")
//    @ResponseBody
//    public Integer updatefood(FoodTypeInfo foodTypeInfo){
//        return  foodInfoService.update(foodTypeInfo);
//    }
//    //根据菜名查询
//    @GetMapping("/findByfoodname/{foodname}")
//    @ResponseBody
//    public Object findByCname(@PathVariable String foodname){
//        return foodInfoService.findByfoodname(String.valueOf(foodname));
//
//    }
//}
