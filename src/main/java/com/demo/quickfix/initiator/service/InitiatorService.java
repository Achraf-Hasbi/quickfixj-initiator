package com.demo.quickfix.initiator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quickfix.*;
import quickfix.fix42.ExecutionReport;

@Slf4j
@Service
public class InitiatorService extends MessageCracker implements Application {

    @Override
    public void onCreate(SessionID sessionID) {
        log.info("Session created {}", sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("Logon successful {}", sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.info("Logout successful {}", sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.info("To admin {}", sessionID);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) {
        log.info("From admin {}", sessionID);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) {
        log.info("Sending Message {}", message);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws UnsupportedMessageType, IncorrectTagValue, FieldNotFound {
        crack(message, sessionID);
    }

    @Handler
    public void onMessage(ExecutionReport executionReport, SessionID sessionID) {
        log.info("Received ExecutionReport {}", executionReport);
    }
}
