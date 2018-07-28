package com.ccj.homework.homeworktest2.service.dynamicqueryservice;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DynamicQuery {

    public Specification<User> FindByUserProp(//
            Long id, //
            String name, //
            Boolean sex, //
            String email, //
            Short age//
    ) {
        return new Specification<User>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(//
                    Root<User> root, //
                    CriteriaQuery<?> criteriaQuery, //
                    CriteriaBuilder criteriaBuilder//
            ) {
                Predicate predicate = criteriaBuilder.conjunction();

                if (!StringUtils.isEmpty(name)) {
                    predicate.getExpressions()
                            .add(criteriaBuilder.and(root.<Long>get("id").in(id)));
                }
                if (!StringUtils.isEmpty(name)) {
                    predicate.getExpressions()
                            .add(criteriaBuilder.and(root.<String>get("name").in(name)));
                }
                if (!StringUtils.isEmpty(sex)) {
                    predicate.getExpressions()
                            .add(criteriaBuilder.and(root.<Boolean>get("sex").in(sex)));
                }
                if (!StringUtils.isEmpty(email)) {
                    predicate.getExpressions()
                            .add(criteriaBuilder.and(root.<String>get("email").in(email)));
                }
                if (!StringUtils.isEmpty(age)) {
                    predicate.getExpressions()
                            .add(criteriaBuilder.and(root.<Short>get("age").in(age)));
                }
                return predicate;
            }

        };
    }
}
