package org.diegoehg.atmapp

import io.cucumber.java.en.*
import org.junit.jupiter.api.Assertions.assertEquals


class StepDefinitions {
    private lateinit var today:String
    private lateinit var actualAnswer:String

    @Given("an example scenario")
    fun anExampleScenario() {
    }

    @When("all step definitions are implemented")
    fun allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    fun theScenarioPasses() {
    }

    @Given("today is {string}")
    fun today_is_sunday(today: String) {
        this.today = today
    }

    @When("I ask whether it's Friday yet")
    fun i_ask_whether_it_s_friday_yet() {
        actualAnswer = isItFriday(today)
    }

    @Then("I should be told {string}")
    fun i_should_be_told(expectedAnswer: String) {
        assertEquals(expectedAnswer, actualAnswer)
    }
}