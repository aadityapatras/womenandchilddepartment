package womenandchilddepartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import womenandchilddepartment.model.Advertisement;
import womenandchilddepartment.model.Post;

import java.util.List;

//@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{

    boolean existsByPostName(String postName);
   // int findAllById(advertisementNo);

    List<Post> findByAdvertisementAdvertisementId(Integer advertisementId);

//    List<Post> findByadvertisementNo(Integer advertisementNo);
}
