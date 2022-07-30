package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

     @GetMapping("hello") //get메서드 url에 hello가 매칭된것을 찾아라
    public String hello(Model model){
         model.addAttribute( "data","hello!!!!");
         return "hello"; //여기 엔드포인트가 같아야함
     }
     @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
         model.addAttribute("name",name);
         return "hello-template";
     }
     @GetMapping("hello-string")
     @ResponseBody
    public String helloString(@RequestParam("name") String name){
         return "hello" + name;
     }
     @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
         Hello hello = new Hello();
         hello.setName(name);
         return hello;
     }

    static class Hello {
         private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
