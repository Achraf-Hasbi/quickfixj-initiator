package com.demo.quickfix.initiator.controller;

import com.demo.quickfix.initiator.controller.dto.OrderDto;
import io.allune.quickfixj.spring.boot.starter.template.QuickFixJTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quickfix.Initiator;
import quickfix.SessionID;
import quickfix.field.*;
import quickfix.fix42.NewOrderSingle;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final Initiator initiator;
    private final QuickFixJTemplate quickFixJTemplate;

    @PostMapping("/order")
    public void placeOrder(@RequestBody OrderDto order) {
        NewOrderSingle newOrder = new NewOrderSingle();
        newOrder.set(new ClOrdID(UUID.randomUUID().toString()));        newOrder.set(new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK));
        newOrder.set(new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK));
        newOrder.set(new Symbol(order.symbol()));
        newOrder.set(new Side(Side.BUY));
        newOrder.set(new TransactTime(LocalDateTime.now()));
        newOrder.set(new OrdType(OrdType.MARKET));
        newOrder.set(new OrderQty(order.quantity()));

        SessionID session = initiator.getSessions().getFirst();
        quickFixJTemplate.send(newOrder, session);
    }
}
