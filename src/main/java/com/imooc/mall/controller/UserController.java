package com.imooc.mall.controller;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.validation.Valid;

import static com.imooc.mall.enums.ResponseEnum.PARAM_ERROR;

/**
 * @author SaoE
 * @date 2022/2/9 20:48
 */
@RestController
//@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;
//    @PostMapping("/register")
//    public void register(@Valid @RequestParam(value = "username") String userName){
//        log.info("username = {}", userName);
//    }

        @PostMapping("/user/register")
        public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("注册提交的参数有误,{}{}",
                    bindingResult.getFieldError().getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }
//        log.info("username = {}", userForm.getUsername());
//        return ResponseVo.success();
//        return ResponseVo.error(NEED_LOGIN);

        User user = new User();
        //对象之间拷贝
        BeanUtils.copyProperties(userRegisterForm,user);

        return userService.register(user);
        }

    /**
     * 登录
     * @param userLoginForm
     * @param bindingResult
     * @param session
     * @return
     */
        @PostMapping("/user/login")
        public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                      BindingResult bindingResult,
                                      HttpSession session){
            if (bindingResult.hasErrors()){
                return ResponseVo.error(PARAM_ERROR, bindingResult);
            }

            ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

            //设置Session
            session.setAttribute(MallConst.CURRENT_USER,userResponseVo.getData());
            log.info("/login sessionId={}",session.getId());

            return userResponseVo;

        }

    /**
     * 获取登录信息
     * @param session
     * @return
     */
    @GetMapping("/user")
        public ResponseVo<User> userInfo(HttpSession session){
            log.info("/user sessionId={}",session.getId());
            User user = (User)session.getAttribute(MallConst.CURRENT_USER);
            return ResponseVo.success(user);
        }

    /**
     * 登出
     * @param session
     * @return
     */
    @PostMapping("/user/logout")
        public ResponseVo logout(HttpSession session){
            log.info("/user/logout sessionId={}",session.getId());
            session.removeAttribute(MallConst.CURRENT_USER);
            return ResponseVo.success();
        }


}
