package com.neo.web;

import com.neo.entity.UserInfo;
import com.neo.sevice.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userView")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){

        return "/systemManager/user";
    }
    @RequestMapping("/findPage")
    @RequiresPermissions("userInfo:view")//权限管理;
    public ModelAndView findPage(@RequestParam(value="pageNumber",defaultValue="1")Integer pageNumber,
                           @RequestParam(value="size",defaultValue="5")Integer size){
        int page = pageNumber;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/systemManager/user");
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(pageNumber-1, size, sort);
            Page<UserInfo> all = userInfoService.findAll(pageable);
            mv.addObject("userInfoList", all);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mv;
    }
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}