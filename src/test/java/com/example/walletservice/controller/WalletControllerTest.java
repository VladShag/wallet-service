package com.example.walletservice.controller;

import com.example.walletservice.model.Wallet;
import com.example.walletservice.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalletController.class)
public class WalletControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private WalletService walletService;
//
//    @Test
//    public void testUpdateWallet() throws Exception {
//        String requestBody = "{\"walletId\":\"123e4567-e89b-12d3-a456-426614174000\",\"operationType\":\"DEPOSIT\",\"amount\":1000}";
//        mockMvc.perform(post("/api/v1/wallets")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testGetWallet() throws Exception {
//        UUID walletId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
//        Wallet wallet = new Wallet();
//        wallet.setId(walletId);
//        wallet.setBalance(1000);
//        when(walletService.getWalletBalance(any(UUID.class))).thenReturn(wallet.getBalance());
//
//        mockMvc.perform(get("/api/v1/wallets/" + walletId))
//                .andExpect(status().isOk());
//    }
}
