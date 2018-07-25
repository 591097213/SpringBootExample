package com.ccj.homework.homeworktest2.control.resources;

import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.User;
import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * UserController
 */
@Api("查询模块")
@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        UserRepository userRepository;

        @ApiOperation(//
                        value = "查询用户", //
                        notes = "输入page和size以查询用户"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(//
                                        name = "page", //
                                        value = "页码", //
                                        dataType = "Interger", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "size", //
                                        value = "每页显示条数", //
                                        dataType = "Interger", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @GetMapping
        public Page<User> findByPage(Integer page, Integer size) {
                Pageable pageable = new PageRequest(page, size, Direction.ASC, "id");
                return userRepository.findAll(pageable);

        }

        @GetMapping("/{id}")
        public User findOne(@PathVariable("id") long id) {
                return userRepository.findById(id).orElse(null);
        }

}
