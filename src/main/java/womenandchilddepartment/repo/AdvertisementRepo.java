package womenandchilddepartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import womenandchilddepartment.model.Advertisement;

import java.util.List;
import java.util.Optional;

//@Repository
public interface AdvertisementRepo extends JpaRepository<Advertisement, Integer>{
	//	boolean existsByAdvertisementNo(Integer advertisementNo);
//	Advertisement findByAdvertisementNo(String advertisementNo);
	boolean existsByAdvertisementNo(String advertisementNo);
	Advertisement findOneByIgnoreCaseAdvertisementNo(String advertisementNo);
	Advertisement findByAdvertisementNo(String advertisementNo);
	void deleteByAdvertisementNo(String advertisementNo);
	//@Query(value="SELECT * FROM womenandchilddpt3.post inner join womenandchilddpt3.advertisement ON womenandchilddpt3.post.id=womenandchilddpt3.advertisement.id where womenandchilddpt3.advertisement.advertisement_no= :param ", nativeQuery = true)
	//Advertisement getElement(@Param("param") Integer param);
	//List<Advertisement> findByAdv(@Param("advertisementNo") Integer advertisementNo);
//	Advertisement findByAdvertisementId(Integer adId);
}
