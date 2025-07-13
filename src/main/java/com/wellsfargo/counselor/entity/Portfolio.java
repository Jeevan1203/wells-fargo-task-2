package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private double accountBalance;
    private String investmentPreferences;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<PortfolioSecurity> holdings;

    // Default constructor
    public Portfolio() {
    }

    // Constructor
    public Portfolio(double accountBalance, String investmentPreferences, Client client) {
        this.accountBalance = accountBalance;
        this.investmentPreferences = investmentPreferences;
        this.client = client;
    }

    // Getters and Setters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getInvestmentPreferences() {
        return investmentPreferences;
    }

    public void setInvestmentPreferences(String investmentPreferences) {
        this.investmentPreferences = investmentPreferences;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<PortfolioSecurity> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<PortfolioSecurity> holdings) {
        this.holdings = holdings;
    }
}
