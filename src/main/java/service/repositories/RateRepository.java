package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.business.Rate;

import java.util.Date;

public interface RateRepository extends JpaRepository<Rate, Long> {

    Rate findBySrcAndDstAndDate(String src, String dst, Date date);

    Rate findBySrcAndDst(String src, String dst);

}
