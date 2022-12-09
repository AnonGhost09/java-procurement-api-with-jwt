//package com.enigma.procurement.repositories.specifications;
//
//import com.enigmacamp.restapidemo.models.courseModel.Course;
//import com.enigmacamp.restapidemo.models.courseModel.CourseType;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.Join;
//
//public class CourseSpec {
//    public Specification<Course> titleLike(String title){
//        return (root, query, criteriaBuilder) ->
//               criteriaBuilder.like(root.get("title"),"%"+title+"%");
//    }
//
//    public Specification<Course> descriptionLIke(String description){
//        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),"%"+description+"%");
//    }
//
//    public  Specification<Course> titleOrDescription(String title){
//        return titleLike(title).or(descriptionLIke(title));
//    }
//
//    public Specification<Course> courseTypeId(String courseTypeId){
//        return (root, query, criteriaBuilder) -> {
//            Join<Course, CourseType> courseTypeJoin = root.join("courseType");
//            return  criteriaBuilder.equal(courseTypeJoin.get("courseTypeId"),courseTypeId);
//        };
//    }
//
//    public Specification<Course> findBy(SearchCriteria searchCriteria){
//        switch (searchCriteria.getOperator()){
//            case LIKE:
//                return (root, query, criteriaBuilder) ->
//                        criteriaBuilder.like(root.get(searchCriteria.getKey()), "%"+
//                        searchCriteria.getValue()+"%");
//            case EQUALS:
//                return  (root, query, criteriaBuilder) ->
//                        criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
//            default:
//                throw new RuntimeException("Operation Not Supported");
//        }
//    }
//}
