package com.Trade.example.Trade.Controller;

import com.Trade.example.Trade.Entity.Trade;
import com.Trade.example.Trade.Service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trades")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @Autowired
    Trade Trade;

    @PostMapping
    public ResponseEntity<?>
    createTrades(@RequestBody Trade trade, @RequestHeader("Authorization") String authHeader) {
        try {
          tradeService.createTrade(trade, authHeader);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Map.of("Message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?>
    getTrades(@RequestParam Map<String, String> criteria, @RequestHeader("Authorization") String authHeader) {
        try {
            List<Trade> trade = tradeService.getTrades(criteria, authHeader);
            if (trade.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(trade, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("Message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
