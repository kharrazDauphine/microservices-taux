package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.business.Rate;
import service.repositories.RateRepository;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taux-change")
public class RateController {

    @Autowired
    private RateRepository rep;




    @GetMapping("/src/{src}/dst/{dst}/date/{date}")
    public Rate getRate(@PathVariable String src, @PathVariable String dst, @PathVariable String date){

        Rate rate = null;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date retrivedDate = format.parse(date);
            rate = rep.findBySrcAndDstAndDate(src.toUpperCase(), dst.toUpperCase(), retrivedDate);
        } catch (ParseException e) {
            System.err.println("Error: Wrong date format, required: yyyy-MM-dd");
        }

        return rate;
    }

    @GetMapping("/rates")
    public List<Rate> getAllRates(){
        return rep.findAll();
    }

    @PostMapping(value = "/rates", produces = {MediaType.ALL_VALUE})
    public Rate createRate(@Valid @RequestBody Rate rate){
        return rep.save(rate);
    }

    @PutMapping("/rates/{id}")
    public Rate updateRate(@PathVariable long id, @Valid @RequestBody Rate rateDetails){

        Rate rate = rep.getOne(id);

        rate.setDate(rateDetails.getDate());
        rate.setDst(rateDetails.getDst());
        rate.setSrc(rateDetails.getSrc());
        rate.setTaux(rateDetails.getTaux());

        Rate updatedRate = rep.save(rate);
        return updatedRate;
    }

    @DeleteMapping("/rates/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable long id){
        Rate rate = rep.getOne(id);

        rep.delete(rate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rates/{id}")
    public Rate getRateById(@PathVariable long id){
        return rep.getOne(id);
    }


}
