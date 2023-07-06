package org.diegoehg.atmapp

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals


class AtmWithdrawalStepDefinitions {
    private lateinit var atmCard:AtmCard

    @Given("I have an ATM card")
    fun i_have_an_atm_card() {
        atmCard = AtmCard(0)
    }

    @Given("I have a balance of \${int}")
    fun `i_have_a_balance_of_$`(balance: Int) {
        atmCard.balance = balance
    }

    @When("I withdraw \${int}")
    fun `i_withdraw_$`(withdrawalAmount: Int) {
        atmCard.withdraw(withdrawalAmount)
    }

    @Then("my balance should be \${int}")
    fun `my_balance_should_be_$`(newBalance: Int) {
        assertEquals(newBalance, atmCard.balance)
    }
}