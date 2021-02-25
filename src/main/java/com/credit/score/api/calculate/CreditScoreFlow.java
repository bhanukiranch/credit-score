package com.credit.score.api.calculate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.jpa.dsl.Jpa;

import javax.persistence.EntityManager;

@Configuration
@Slf4j
public class CreditScoreFlow {


    @Bean
    public IntegrationFlow loanSubmissionFlow(EntityManager entityManager) {
        return IntegrationFlows.from(Http.inboundGateway("/v1/credit/score/{id}")
                .requestMapping(m -> m.methods(HttpMethod.GET))
                .errorChannel("globalErrorChannel.input")
                .headerExpression("ssnNumber", "#pathVariables.id"))
                .wireTap("loggingFlow.input")
                .log(LoggingHandler.Level.INFO, this.getClass().getName(), m -> "Start - Retrieve the credit score")
                .handle(Jpa.retrievingGateway(entityManager).entityClass(CreditScore.class)
                        .jpaQuery("from CreditScore c where c.ssnNumber = :id")
                        .expectSingleResult(true).parameterExpression("id", "headers['ssnNumber']"))
                .<CreditScore>handle((p, h) -> p)
                .get();


    }

}
