package com.example.walletservice.controller;

import com.example.walletservice.dto.WalletRequestDto;
import com.example.walletservice.exception.InsufficientFundsException;
import com.example.walletservice.exception.InvalidOperationTypeException;
import com.example.walletservice.exception.WalletNotFoundException;
import com.example.walletservice.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalletController.class)
public class WalletControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletService walletService;

    @Test
    @WithMockUser(roles = "USER")
    public void testUpdateWallet() throws Exception {
        String requestBody = "{\"walletId\":\"123e4567-e89b-12d3-a456-426614174000\",\"operationType\":\"DEPOSIT\",\"amount\":1000}";
        mockMvc.perform(post("/api/v1/wallets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Success"));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testGetWalletBalance() throws Exception {
        UUID walletId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        Long balance = 1000L;
        when(walletService.getWalletBalance(any(UUID.class))).thenReturn(balance);

        mockMvc.perform(get("/api/v1/wallets/" + walletId + "/balance"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data").value(balance));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testWalletNotFound() throws Exception {
        UUID walletId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        doThrow(new WalletNotFoundException("Wallet not found")).when(walletService).getWalletBalance(walletId);

        mockMvc.perform(get("/api/v1/wallets/" + walletId + "/balance"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Wallet not found"));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testInsufficientFunds() throws Exception {
        String requestBody = "{\"walletId\":\"123e4567-e89b-12d3-a456-426614174000\",\"operationType\":\"WITHDRAW\",\"amount\":1000}";
        doThrow(new InsufficientFundsException("Insufficient funds")).when(walletService).updateWallet(any(WalletRequestDto.class));

        mockMvc.perform(post("/api/v1/wallets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Insufficient funds"));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testInvalidOperationType() throws Exception {
        String requestBody = "{\"walletId\":\"123e4567-e89b-12d3-a456-426614174000\",\"operationType\":\"INVALID\",\"amount\":1000}";
        doThrow(new InvalidOperationTypeException("Invalid operation type")).when(walletService).updateWallet(any(WalletRequestDto.class));

        mockMvc.perform(post("/api/v1/wallets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Invalid operation type"));
    }
}
