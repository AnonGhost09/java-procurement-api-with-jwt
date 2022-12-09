//package com.enigma.procurement.repositories.specifications;
//
//import com.enigmacamp.restapidemo.models.courseModel.CourseType;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//@Component
//public class CourseTypeSpec {
//
//    public Specification<CourseType> typeNameLike1(String name){
//        return new Specification<CourseType>() {
//            @Override
//            public Predicate toPredicate(Root<CourseType> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.like(root.get("name"),"%"+name+"5");
//            }
//        };
//    }
//
//    public Specification<CourseType> typeNameLike2(String name){
//        return (root, query, criteriaBuilder) ->
//            criteriaBuilder.like(root.get("name"),"%"+name+"%");
//    }
//
//}
