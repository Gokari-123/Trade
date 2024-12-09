package com.Trade.example.Trade.Service;

import com.Trade.example.Trade.Entity.Trade;
import com.Trade.example.Trade.Entity.User;
import com.Trade.example.Trade.Repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TradeService {

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    UserService userService;

    public Trade createTrade(Trade trade,String authHeader)throws Exception{
        User user=authenticate(authHeader);
        trade.setUser(user);
       return tradeRepository.save(trade);
    }

    public List<Trade>  getTrades(Map<String,String>criteria, String authHeader)throws Exception{
        authenticate(authHeader);
        return tradeRepository.findAll();
    }

    private User authenticate(String authHeader) throws Exception{
        String[] credentials=decodeBasicAuth(authHeader);

        return userService.authenticate(credentials[0],credentials[1]);
    }

    private String[] decodeBasicAuth(String authHeader) {
        byte[] decodedBytes=java.util.Base64.getDecoder().decode(authHeader.split(" ")[1]);
        String decodedString=new String(decodedBytes);
        return decodedString.split(":");
    }
}
