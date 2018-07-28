package com.ccj.homework.homeworktest2.control.resources;

import java.util.List;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.User;
import com.ccj.homework.homeworktest2.service.dynamicqueryservice.DynamicQuery;
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

        @Autowired
        DynamicQuery dynamicQuery;

        @ApiOperation(//
                        value = "查询所有用户", //
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

        @ApiOperation(//
                        value = "根据ID查询用户", //
                        notes = "输入用户ID号"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(//
                                        name = "id", //
                                        value = "用户ID号", //
                                        dataType = "long", //
                                        paramType = "path", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @GetMapping("/{id}")
        public User findOne(@PathVariable("id") long id) {
                return userRepository.findById(id).orElse(null);
        }

        @ApiOperation(//
                        value = "根据用户属性查询用户", //
                        notes = "输入id、name、sex、email、age查询用户"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(//
                                        name = "id", //
                                        value = "用户ID", //
                                        dataType = "Long", //
                                        paramType = "query", //
                                        required = false, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "name", //
                                        value = "用户名", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = false, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "sex", //
                                        value = "用户性别", //
                                        dataType = "Boolean", //
                                        paramType = "query", //
                                        required = false, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "email", //
                                        value = "用户邮箱", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = false, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "age", //
                                        value = "用户年龄", //
                                        dataType = "Short", //
                                        paramType = "query", //
                                        required = false, //
                                        allowMultiple = false//
                        ),//

        })
        @GetMapping("/properties")
        public List<User> findByProp(Long id, //
                        String name, //
                        Boolean sex, //
                        String email, //
                        Short age//
        ) {
                return userRepository
                                .findAll(dynamicQuery.FindByUserProp(id, name, sex, email, age));
        }

}
