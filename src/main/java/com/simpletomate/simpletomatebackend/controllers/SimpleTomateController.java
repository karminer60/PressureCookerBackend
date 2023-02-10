package com.simpletomate.simpletomatebackend.controllers;
import java.util.*;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTomateController {

    @Autowired
    CoinRepository coinrepos;
    // http://localhost:2019/total

    @GetMapping(value = "/total",
            produces = {"application/json"})
    public ResponseEntity<?>listAllCoins()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1,c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        double total = 0;
        for( Coin item: myList){

            System.out.println( item.getQuantity() +" " + item.getNamepural());
            total += item.getValue()*item.getQuantity();

        }

        System.out.println( "The piggy bank holds" + " " + total);
        return new ResponseEntity<>(myList, HttpStatus.OK);

    }
}
